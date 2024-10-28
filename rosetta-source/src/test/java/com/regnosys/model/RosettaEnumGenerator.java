package com.regnosys.model;

import com.regnosys.rosetta.rosetta.RosettaEnumSynonym;
import com.regnosys.rosetta.rosetta.RosettaEnumValue;
import com.regnosys.rosetta.rosetta.RosettaExternalEnum;

import java.util.List;

public class RosettaEnumGenerator {


    public String generateRosettaEnum(RosettaExternalEnum rosettaExternalEnum) {
        StringBuilder sb = new StringBuilder();
        String enumName = rosettaExternalEnum.getEnumeration().getName();
        sb.append("func ValueTo%s:\n".formatted(enumName));
        sb.append("\tinputs:\n");
        sb.append("\t\tvalue string (1..1)\n");
        sb.append("\toutput:\n");
        sb.append("\t\tresult %s (0..1)\n".formatted(enumName));
        sb.append("\tset result: value switch\n");
        rosettaExternalEnum.getRegularValues().forEach(enumValueSynonym -> {
            RosettaEnumValue enumRef = enumValueSynonym.getEnumRef();
            String enumValue = enumRef.getName();
            List<String> synonyms = enumValueSynonym.getExternalEnumSynonyms().stream().map(RosettaEnumSynonym::getSynonymValue).toList();
            synonyms.forEach(s -> {
                sb.append("\t\t\"%s\" then %s,\n".formatted(s, enumValue));
            });
        });
        sb.delete(sb.length() - 2, sb.length());
        sb.append("\n");
        return sb.toString();
    }
}
