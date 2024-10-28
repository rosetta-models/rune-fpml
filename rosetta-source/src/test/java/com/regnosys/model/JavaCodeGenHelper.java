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
    @Inject
    RosettaEnumGenerator rosettaEnumGenerator;
    @Inject
    JavaEnumGenerator   javaEnumGenerator;

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
                        .map(javaEnumGenerator::generateJavaEnum)
                                .forEach(System.out::println);

        allExternalEnums.stream().map(rosettaEnumGenerator::generateRosettaEnum).forEach(System.out::println);
    }

    private String getQualifiedName(RosettaType type) {
        return type.getModel().getName() + "." + type.getName();
    }

    private Set<RosettaExternalEnum> findAllExternalEnums(List<RosettaModel> models) {
        Set<RosettaExternalEnum> listOfExternalEnums = new HashSet<>();

        models.stream()
                .filter(m -> m.getName().startsWith("cdm.mapping.fpml"))
                .flatMap(m -> m.getElements().stream())
                .filter(RosettaExternalSynonymSource.class::isInstance)
                .map(RosettaExternalSynonymSource.class::cast)
                .forEach(externalSynonymSource -> {
                    listOfExternalEnums.addAll(externalSynonymSource.getExternalEnums());
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
