package com.regnosys.model;

import com.regnosys.rosetta.generator.java.enums.EnumHelper;
import com.regnosys.rosetta.rosetta.RosettaEnumSynonym;
import com.regnosys.rosetta.rosetta.RosettaEnumValue;
import com.regnosys.rosetta.rosetta.RosettaExternalEnum;

import java.util.List;

public class JavaEnumGenerator {

    public String generateJavaEnum(RosettaExternalEnum rosettaExternalEnum) {
        StringBuilder sb = new StringBuilder();
        String javaEnumName = rosettaExternalEnum.getEnumeration().getName();
        sb.append("private Optional<").append(javaEnumName).append("> valueTo").append(javaEnumName).append("(String value) {\n");
        sb.append("\tif (value == null || value.isEmpty()) {\n");
        sb.append("\t\treturn Optional.empty();\n");
        sb.append("\t}\n");

        sb.append("\treturn Optional.ofNullable(switch (value) {\n");
        rosettaExternalEnum.getRegularValues().forEach(enumValueSynonym -> {
            RosettaEnumValue enumRef = enumValueSynonym.getEnumRef();
            String enumValue = "%s.%s".formatted(javaEnumName, EnumHelper.formatEnumName(enumRef.getName()));
            List<String> synonyms = enumValueSynonym.getExternalEnumSynonyms().stream().map(RosettaEnumSynonym::getSynonymValue).toList();
            synonyms.forEach(s -> {
                sb.append("\t\tcase \"%s\" -> %s;\n".formatted(s, enumValue));
            });
        });

        sb.append("\t\tdefault -> null;\n");
        sb.append("\t});\n");
        sb.append("}\n");
        return sb.toString();
    }
}
