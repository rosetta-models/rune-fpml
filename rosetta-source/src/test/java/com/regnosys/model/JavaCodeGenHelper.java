package com.regnosys.model;

import cdm.legaldocumentation.common.ContractualDefinitionsEnum;
import cdm.legaldocumentation.common.ContractualSupplementTypeEnum;
import cdm.legaldocumentation.common.MatrixTermEnum;
import cdm.legaldocumentation.common.MatrixTypeEnum;
import cdm.legaldocumentation.master.MasterAgreementTypeEnum;
import cdm.legaldocumentation.master.MasterConfirmationAnnexTypeEnum;
import cdm.legaldocumentation.master.MasterConfirmationTypeEnum;
import cdm.product.collateral.CreditSupportAgreementTypeEnum;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.regnosys.rosetta.common.util.ClassPathUtils;
import com.regnosys.rosetta.common.util.UrlUtils;
import com.regnosys.rosetta.generator.java.enums.EnumHelper;
import com.regnosys.rosetta.rosetta.*;
import com.regnosys.rosetta.rosetta.simple.Data;
import com.regnosys.rosetta.transgest.ModelLoader;
import com.regnosys.testing.RosettaTestingInjectorProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Loads the model and prints out stuff.
 */
public class JavaCodeGenHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(JavaCodeGenHelper.class);

    @Inject
    ModelLoader loader;

    public static void main(String[] args) {
        Injector injector = new RosettaTestingInjectorProvider().getInjector();
        JavaCodeGenHelper helper = injector.getInstance(JavaCodeGenHelper.class);
        helper.run();
    }

    public void run() {
        List<RosettaModel> models = loader.loadRosettaModels(ClassPathUtils.findRosettaFilePaths().stream().map(UrlUtils::toUrl));

        var enumsToGenerate = Set.of(MasterAgreementTypeEnum.class,
                        MasterConfirmationTypeEnum.class,
                        MasterConfirmationAnnexTypeEnum.class,
                        CreditSupportAgreementTypeEnum.class,
                        ContractualDefinitionsEnum.class,
                        MatrixTypeEnum.class,
                        MatrixTermEnum.class,
                        ContractualSupplementTypeEnum.class)
                .stream().map(Class::getSimpleName).collect(Collectors.toSet());

        Set<RosettaExternalEnum> allExternalEnums = findAllExternalEnums(models);

        allExternalEnums.stream().filter(e -> enumsToGenerate.contains(e.getEnumeration().getName()))
                        .map(this::generateJavaSwitch)
                                .forEach(System.out::println);

        allExternalEnums.stream().map(this::generateRosettaEnum).forEach(System.out::println);
    }

    private String generateRosettaEnum(RosettaExternalEnum rosettaExternalEnum) {
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

    private String generateJavaSwitch(RosettaExternalEnum rosettaExternalEnum) {
        StringBuilder sb = new StringBuilder();
        String javaEnumName = rosettaExternalEnum.getEnumeration().getName();
        sb.append("private Optional<").append(javaEnumName).append("> valueTo").append(javaEnumName).append("(String value) {\n");
        sb.append("\tif (value == null || value.isEmpty()) {\n");
        sb.append("\t\treturn Optional.empty();\n");
        sb.append("\t}\n");

        sb.append("\treturn Optional.ofNullable(switch (value) {\n");
        rosettaExternalEnum.getRegularValues().forEach(enumValueSynonym -> {
            RosettaEnumValue enumRef = enumValueSynonym.getEnumRef();
            String enumValue = "%s.%s".formatted(javaEnumName,EnumHelper.formatEnumName(enumRef.getName()));
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

    private String getQualifiedName(RosettaType type) {
        return type.getModel().getName() + "." + type.getName();
    }

    private Set<RosettaEnumeration> findAllEnums(List<RosettaModel> models) {
        Set<RosettaEnumeration> listOfEnums = new HashSet<>();

        for (RosettaModel model : models) {
            model.getElements().stream()
                    .filter(RosettaEnumeration.class::isInstance)
                    .map(RosettaEnumeration.class::cast)
                    .forEach(enumeration -> {
                        LOGGER.trace("Processing enumeration type {}", getQualifiedName(enumeration));
                        listOfEnums.add(enumeration);
                    });
        }
        return listOfEnums;
    }

    private Set<RosettaExternalEnum> findAllExternalEnums(List<RosettaModel> models) {
        Set<RosettaExternalEnum> listOfExternalEnums = new HashSet<>();

        models.stream()
                .filter(m -> m.getName().startsWith("cdm.mapping.fpml"))
                .flatMap(m -> m.getElements().stream())
                .filter(RosettaExternalSynonymSource.class::isInstance)
                .map(RosettaExternalSynonymSource.class::cast)
                .forEach(externalSynonymSource -> {
                    externalSynonymSource.getExternalEnums().forEach(externalEnum -> {
                        listOfExternalEnums.add(externalEnum);
                    });
                });
        return listOfExternalEnums;
    }

    private Set<Data> findAllTypes(List<RosettaModel> models) {
        Set<Data> listOfTypes = new HashSet<>();

        for (RosettaModel model : models) {
            model.getElements().stream()
                    .filter(Data.class::isInstance)
                    .map(Data.class::cast)
                    .forEach(dataType -> {
                        LOGGER.trace(" Processing data type: {}", getQualifiedName(dataType));
                        listOfTypes.add(dataType);
                    });
        }
        return listOfTypes;
    }
}
