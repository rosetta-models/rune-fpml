package com.regnosys.model;

import com.regnosys.rosetta.rosetta.RosettaEnumSynonym;
import com.regnosys.rosetta.rosetta.RosettaEnumValue;
import com.regnosys.rosetta.rosetta.RosettaEnumeration;
import com.regnosys.rosetta.rosetta.RosettaExternalEnum;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RosettaEnumGenerator {


    public void generateRosettaEnum(List<RosettaExternalEnum> rosettaExternalEnums) throws IOException {
        Set<String> imports = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (RosettaExternalEnum rosettaExternalEnum : rosettaExternalEnums) {
            RosettaEnumeration enumeration = rosettaExternalEnum.getEnumeration();
            imports.add("import %s.*".formatted(enumeration.getModel().getName()));
            String enumName = enumeration.getName();
            sb.append("func Map%s:\n".formatted(enumName));
            sb.append("\tinputs:\n");
            sb.append("\t\tvalue string (0..1)\n");
            sb.append("\toutput:\n");
            sb.append("\t\tresult %s (0..1)\n".formatted(enumName));
            sb.append("\tset result: value switch\n");
            Set<SynonymEnumValuePair> synonymEnumValuePairs = new HashSet<>();  //This is to get rid of duplicate junk synonyms in the model
            rosettaExternalEnum.getRegularValues().forEach(enumValueSynonym -> {
                RosettaEnumValue enumRef = enumValueSynonym.getEnumRef();
                String enumValue = enumRef.getName();
                List<String> synonyms = enumValueSynonym.getExternalEnumSynonyms().stream().map(RosettaEnumSynonym::getSynonymValue).toList();
                synonyms.forEach(s -> {
                    SynonymEnumValuePair synonymEnumValuePair = new SynonymEnumValuePair(s, enumValue);
                    if (!synonymEnumValuePairs.contains(synonymEnumValuePair)) {
                        sb.append("\t\t\"%s\" then %s,\n".formatted(s, enumValue));
//                        synonymEnumValuePairs.add(synonymEnumValuePair);
                    }
                });
            });
            sb.append("\t\tdefault empty\n\n");
        }

        imports.forEach(i -> sb.insert(0, i + "\n"));

        Path outputFile = Path.of("./rosetta-source/src/main/rosetta/enumeration-mapping-functions.rosetta");
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile.toFile()));
        writer.append("namespace fpml.enumeration.mapping : < \"fpml enumeration mappings\" >\n");
        writer.append("version \"${project.version}\"\n\n");
        writer.append(sb.toString());
        writer.close();
    }

    private record SynonymEnumValuePair(String synonym, String enumValue) {}
}
