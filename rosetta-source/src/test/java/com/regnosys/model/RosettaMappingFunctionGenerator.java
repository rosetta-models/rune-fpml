package com.regnosys.model;

import com.regnosys.rosetta.rosetta.RosettaBasicType;
import com.regnosys.rosetta.rosetta.RosettaEnumeration;
import com.regnosys.rosetta.rosetta.RosettaType;
import com.regnosys.rosetta.rosetta.simple.Attribute;
import com.regnosys.rosetta.rosetta.simple.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class RosettaMappingFunctionGenerator {
    private Queue<FunctionToGenerate> functionToGenerateQueue;
    private Set<String> imports;

    public void generateMappingFunctions(Data cdmType) throws IOException {
        functionToGenerateQueue = new LinkedList<>();
        functionToGenerateQueue.add(new FunctionToGenerate(cdmType, null, false, List.of()));
        imports = new HashSet<>();
        Path tempContents = Files.createTempFile("mappingFnContent", null);
        BufferedWriter contentWriter = new BufferedWriter(new FileWriter(tempContents.toFile()));

        contentWriter.append("import cdm.fpml.confirmation.* as fpml\n\n");

        while (!functionToGenerateQueue.isEmpty()) {
            FunctionToGenerate functionToGenerate = functionToGenerateQueue.remove();
            String mappingFunction = functionToGenerate.outputType instanceof Data ? generateDataTypeMappingFunction(functionToGenerate) : generateNonDataTypeMappingFunction(functionToGenerate);
            contentWriter.append(mappingFunction);
            contentWriter.append("\n\n");
        }
        contentWriter.close();

        Path tempImports = Files.createTempFile("mappingFnImports", null);
        BufferedWriter importsWriter = new BufferedWriter(new FileWriter(tempImports.toFile()));
        for (String i : imports) {
            importsWriter.append(i).append("\n");
        }
        importsWriter.close();

        Path outputPath = Path.of("./rosetta-source/src/main/rosetta/mapping-functions.rosetta");

        try(OutputStream output = Files.newOutputStream(outputPath)) {
            Files.copy(tempImports, output);
            Files.copy(tempContents, output);
        }
    }

    private String generateDataTypeMappingFunction(FunctionToGenerate functionToGenerate) {
        addImport(functionToGenerate);
        StringBuilder sb = new StringBuilder();
        Data cdmType = (Data) functionToGenerate.outputType;
        boolean isOutputMulti = functionToGenerate.isMulti;

        generateFunctionHeader(sb, functionToGenerate, generateDataMappingFunctionName(functionToGenerate), true);

        for (Attribute attribute : cdmType.getAttributes()) {
            List<String> metas = getMetas(attribute);
            RosettaType type = attribute.getTypeCall().getType();
            if (type instanceof RosettaBasicType || type instanceof RosettaEnumeration) {
                if (metas.isEmpty()) {
                    generateAttributeSetter(sb, attribute.getName(), attribute.getCard().isIsMany(), isOutputMulti);
                } else {
                    FunctionToGenerate newFunctionToGenerate = new FunctionToGenerate(type, attribute.getName(), attribute.getCard().isIsMany(), metas);
                    functionToGenerateQueue.add(newFunctionToGenerate);
                    generateFunctionCallAttributeSetter(sb, newFunctionToGenerate, isOutputMulti);
                }
            } else if (type instanceof Data data) {
                FunctionToGenerate newFunctionToGenerate = new FunctionToGenerate(data, attribute.getName(), attribute.getCard().isIsMany(), metas);
                functionToGenerateQueue.add(newFunctionToGenerate);
                generateFunctionCallAttributeSetter(sb, newFunctionToGenerate, isOutputMulti);
            } else {
                throw new UnsupportedOperationException("Unsupported type: " + type);
            }
        }

        generateFooter(sb, isOutputMulti, true);
        return sb.toString();
    }

    private String generateNonDataTypeMappingFunction(FunctionToGenerate functionToGenerate) {
        addImport(functionToGenerate);
        boolean isOutputMulti = functionToGenerate.isMulti;

        StringBuilder sb = new StringBuilder();
        generateFunctionHeader(sb, functionToGenerate, generateNonDataMappingFunctionName(functionToGenerate), false);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(" empty");

        generateFooter(sb, isOutputMulti, false);
        return sb.toString();
    }

    private void generateFunctionHeader(StringBuilder sb,
                                        FunctionToGenerate functionToGenerate,
                                        String mappingFunctionName,
                                        boolean isDataTypeFunction) {
        boolean isOutputMulti = functionToGenerate.isMulti;
        String indent = isOutputMulti ? "\t" : "";
        String outputTypeName = functionToGenerate.outputType.getName();
        String outputAttributeName = toLowerFirstChar(functionToGenerate.attributeName) + (isOutputMulti ? "List" : "");
        List<String> metas = functionToGenerate.metas;

        sb.append("func %s:\n".formatted(mappingFunctionName));
        sb.append("\tinputs:\n");
        sb.append("\t\tfpmlDataDocument fpml.DataDocument (0..1)\n");
        sb.append("\toutput:\n");
        sb.append("\t\t%s %s (0..%s)\n".formatted(outputAttributeName, outputTypeName, isOutputMulti ? "*" : "1"));
        metas.forEach(m -> sb.append("\t\t// [metadata %s]\n".formatted(m)));
        sb.append("\t%s %s:\n".formatted(isOutputMulti ? "add" : "set", outputAttributeName));
        if (isOutputMulti) {
            sb.append("\t\t[\n");
        }
        if (isDataTypeFunction) {
            sb.append("%s\t\t%s {\n".formatted(indent, outputTypeName));
        }
    }

    private void generateFooter(StringBuilder sb, boolean isOutputMulti, boolean isDataTypeFunction) {
        String indent = isOutputMulti ? "\t" : "";
        if (isDataTypeFunction) {
            sb.append("%s\t\t}\n".formatted(indent));
        }
        if (isOutputMulti) {
            sb.append("\t\t]\n");
        }
    }

    private void generateFunctionCallAttributeSetter(StringBuilder sb, FunctionToGenerate functionToGenerate, boolean isOutputMulti) {
        String indent = isOutputMulti ? "\t" : "";
        String attributeName = functionToGenerate.attributeName;
        boolean isDataType = functionToGenerate.outputType instanceof Data;
        String mappingFunctionName = isDataType ? generateDataMappingFunctionName(functionToGenerate) : generateNonDataMappingFunctionName(functionToGenerate);
        sb.append("%s\t\t\t%s: %s(fpmlDataDocument),\n".formatted(indent, attributeName, mappingFunctionName));
    }

    private void generateAttributeSetter(StringBuilder sb, String attributeName, boolean isAttributeMulti, boolean isOutputMulti) {
        String indent = isOutputMulti ? "\t" : "";
        sb.append("%s\t\t\t%s: %sempty%s,\n".formatted(indent, attributeName, isAttributeMulti ? "[" : "", isAttributeMulti ? "]" : ""));
    }

    private List<String> getMetas(Attribute attribute) {
        return attribute.getAnnotations().stream()
                .filter(a -> a.getAnnotation().getName().equals("metadata"))
                .map(annotationRef -> annotationRef.getAttribute().getName())
                .toList();
    }

    private void addImport(FunctionToGenerate function) {
        imports.add("import %s.*".formatted(function.outputType.getModel().getName()));
    }

    private String toLowerFirstChar(String s) {
        return StringUtils.uncapitalize(s);
    }

    private String generateNonDataMappingFunctionName(FunctionToGenerate functionToGenerate) {
        return "Map%s%s".formatted(StringUtils.capitalize(functionToGenerate.attributeName), functionToGenerate.isMulti ? "List" : "");
    }

    private String generateDataMappingFunctionName(FunctionToGenerate functionToGenerate) {
        return "Map%s%s".formatted(functionToGenerate.outputType.getName(), functionToGenerate.isMulti ? "List" : "");
    }

    private record FunctionToGenerate(RosettaType outputType, String attributeName, boolean isMulti, List<String> metas) {}
}
