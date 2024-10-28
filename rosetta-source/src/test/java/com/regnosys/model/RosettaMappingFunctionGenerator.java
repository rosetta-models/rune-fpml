package com.regnosys.model;

import com.regnosys.rosetta.rosetta.RosettaBasicType;
import com.regnosys.rosetta.rosetta.RosettaEnumeration;
import com.regnosys.rosetta.rosetta.RosettaType;
import com.regnosys.rosetta.rosetta.simple.Attribute;
import com.regnosys.rosetta.rosetta.simple.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RosettaMappingFunctionGenerator {
    private Queue<TypeToGenerate> typesQueue;
    private Set<String> imports;

    public String generateMappingFunctions(Data cdmType) {
        typesQueue = new LinkedList<>();
        typesQueue.add(new TypeToGenerate(cdmType, false));
        imports = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        sb.append("import cdm.fpml.confirmation.* as fpml\n\n");

        while (!typesQueue.isEmpty()) {
            TypeToGenerate typeToGenerate = typesQueue.remove();
            String mappingFunction = generateMappingFunction(typeToGenerate);
            sb.append(mappingFunction);
            sb.append("\n\n");
        }

        imports.forEach(i -> sb.insert(0, i + "\n"));
        return sb.toString();
    }

    private String generateMappingFunction(TypeToGenerate typeToGenerate) {
        addImport(typeToGenerate);
        StringBuilder sb = new StringBuilder();
        Data cdmType = typeToGenerate.cdmType;
        boolean isOutputMulti = typeToGenerate.isMulti;
        String outputTypeName = cdmType.getName();
        String outputAttributeName = toLowerFirstChar(outputTypeName);

        sb.append("func %s:\n".formatted(generateMappingFunctionName(typeToGenerate)));
        sb.append("\tinputs:\n");
        sb.append("\t\tfpmlDataDocument fpml.DataDocument (0..1)\n");
        sb.append("\toutput:\n");
        sb.append("\t\t%s %s (0..1)\n".formatted(outputAttributeName, outputTypeName));
        sb.append("\t%s %s:\n".formatted(isOutputMulti ? "add" : "set", outputAttributeName));
        if (isOutputMulti) {
            sb.append("\t\t[\n");
        }
        String indent = isOutputMulti ? "\t" : "";
        sb.append("%s\t\t%s {\n".formatted(indent, outputTypeName));

        for (Attribute attribute : cdmType.getAttributes()) {
            RosettaType type = attribute.getTypeCall().getType();
            if (type instanceof RosettaBasicType) {
                RosettaBasicType basicType = (RosettaBasicType) type;
            } else if (type instanceof Data) {
                Data data = (Data) type;
                boolean isMany = attribute.getCard().isIsMany();
                TypeToGenerate newTypeToGenerate = new TypeToGenerate(data, isMany);
                typesQueue.add(newTypeToGenerate);
            } else if (type instanceof RosettaEnumeration) {
                RosettaEnumeration enumeration = (RosettaEnumeration) type;
            } else {
                throw new UnsupportedOperationException("Unsupported type: " + type);
            }
        }

        sb.append("%s\t\t}\n".formatted(indent));
        if (isOutputMulti) {
            sb.append("\t\t]\n");
        }

        return sb.toString();
    }

    private void addImport(TypeToGenerate function) {
        imports.add("import %s.*".formatted(function.cdmType.getModel().getName()));
    }

    private String toLowerFirstChar(String s) {
        return StringUtils.uncapitalize(s);
    }

    private String generateMappingFunctionName(TypeToGenerate typeToGenerate) {
        return "Map%s%s".formatted(typeToGenerate.cdmType.getName(), typeToGenerate.isMulti ? "List" : "");
    }

    private record TypeToGenerate(Data cdmType, boolean isMulti) {}
}
