package com.regnosys.model;

import com.regnosys.rosetta.rosetta.RosettaBasicType;
import com.regnosys.rosetta.rosetta.RosettaEnumeration;
import com.regnosys.rosetta.rosetta.RosettaType;
import com.regnosys.rosetta.rosetta.simple.Attribute;
import com.regnosys.rosetta.rosetta.simple.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class RosettaMappingFunctionGenerator {
    private Queue<FunctionToGenerate> functionToGenerateQueue;
    private Set<String> imports;

    public String generateMappingFunctions(Data cdmType) {
        functionToGenerateQueue = new LinkedList<>();
        functionToGenerateQueue.add(new FunctionToGenerate(cdmType, null, false, List.of()));
        imports = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        sb.append("import cdm.fpml.confirmation.* as fpml\n\n");

        while (!functionToGenerateQueue.isEmpty()) {
            FunctionToGenerate functionToGenerate = functionToGenerateQueue.remove();
            String mappingFunction = functionToGenerate.outputType instanceof Data ? generateDataTypeMappingFunction(functionToGenerate) : generateBasicTypeMappingFunction(functionToGenerate);
            sb.append(mappingFunction);
            sb.append("\n\n");
        }

        imports.forEach(i -> sb.insert(0, i + "\n"));
        return sb.toString();
    }

    private String generateDataTypeMappingFunction(FunctionToGenerate functionToGenerate) {
        addImport(functionToGenerate);
        StringBuilder sb = new StringBuilder();
        Data cdmType = (Data) functionToGenerate.outputType;
        boolean isOutputMulti = functionToGenerate.isMulti;
        String outputTypeName = cdmType.getName();
        String outputAttributeName = toLowerFirstChar(outputTypeName);

        generateFunctionHeader(sb, generateDataMappingFunctionName(functionToGenerate), outputAttributeName, outputTypeName, functionToGenerate.metas, isOutputMulti, true);

        for (Attribute attribute : cdmType.getAttributes()) {
            List<String> metas = getMetas(attribute);
            RosettaType type = attribute.getTypeCall().getType();
            if (type instanceof RosettaBasicType basicType) {
                if (metas.isEmpty()) {

                } else {
                    FunctionToGenerate newFunctionToGenerate = new FunctionToGenerate(basicType, attribute.getName(), attribute.getCard().isIsMany(), metas);
                    functionToGenerateQueue.add(newFunctionToGenerate);
                }
            } else if (type instanceof Data data) {
                FunctionToGenerate newFunctionToGenerate = new FunctionToGenerate(data, attribute.getName(), attribute.getCard().isIsMany(), List.of());
                functionToGenerateQueue.add(newFunctionToGenerate);
            } else if (type instanceof RosettaEnumeration enumeration) {
                if (metas.isEmpty()) {

                } else {
                    FunctionToGenerate newFunctionToGenerate = new FunctionToGenerate(enumeration, attribute.getName(), attribute.getCard().isIsMany(), metas);
                    functionToGenerateQueue.add(newFunctionToGenerate);
                }
            } else {
                throw new UnsupportedOperationException("Unsupported type: " + type);
            }
        }

        generateFooter(sb, isOutputMulti, true);

        return sb.toString();
    }

    private String generateBasicTypeMappingFunction(FunctionToGenerate functionToGenerate) {
        addImport(functionToGenerate);
        RosettaBasicType cdmType = (RosettaBasicType) functionToGenerate.outputType;
        boolean isOutputMulti = functionToGenerate.isMulti;
        String outputTypeName = cdmType.getName();
        String outputAttributeName = toLowerFirstChar(functionToGenerate.attributeName);

        StringBuilder sb = new StringBuilder();
        generateFunctionHeader(sb, generateNonDataMappingFunctionName(functionToGenerate.attributeName), outputAttributeName, outputTypeName, functionToGenerate.metas, isOutputMulti, false);


        generateFooter(sb, isOutputMulti, false);

        return sb.toString();
    }

    private void generateFunctionHeader(StringBuilder sb,
                                        String mappingFunctionName,
                                        String outputAttributeName,
                                        String outputTypeName,
                                        List<String> metas,
                                        boolean isOutputMulti,
                                        boolean isDataTypeFunction) {
        String indent = isOutputMulti ? "\t" : "";

        sb.append("func %s:\n".formatted(mappingFunctionName));
        sb.append("\tinputs:\n");
        sb.append("\t\tfpmlDataDocument fpml.DataDocument (0..1)\n");
        sb.append("\toutput:\n");
        sb.append("\t\t%s %s (0..%s)\n".formatted(outputAttributeName, outputTypeName, isOutputMulti ? "*" : "1"));
        metas.forEach(m -> {
            sb.append("\t\t// [metadata %s]\n".formatted(m));
        });
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

    private String generateNonDataMappingFunctionName(String attributeName) {
        return "Map%s".formatted(StringUtils.capitalize(attributeName));
    }

    private String generateDataMappingFunctionName(FunctionToGenerate functionToGenerate) {
        return "Map%s%s".formatted(functionToGenerate.outputType.getName(), functionToGenerate.isMulti ? "List" : "");
    }

    private record FunctionToGenerate(RosettaType outputType, String attributeName, boolean isMulti, List<String> metas) {}
}
