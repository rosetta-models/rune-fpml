package com.regnosys.model;

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

//        Set<RosettaEnumeration> allEnums = findAllEnums(models);
//        allEnums.forEach(enumeration -> {
//            System.out.println("enum " + getQualifiedName(enumeration));
//            enumeration.getEnumValues().forEach(enumValue ->
//                    System.out.println("  " + EnumHelper.formatEnumName(enumValue.getName())));
//        });

//        Set<Data> allTypes = findAllTypes(models);
//        allTypes.forEach(type -> {
//            System.out.println("type " + getQualifiedName(type));
//            type.getAttributes().forEach(attr ->
//                    System.out.println("  " + attr.getName()));
//        });
        
        Set<RosettaExternalEnum> allExternalEnums = findAllExternalEnums(models);
        allExternalEnums.forEach(externalEnum -> {
            System.out.println("enum synonym " + getQualifiedName(externalEnum.getEnumeration()));
            externalEnum.getRegularValues().forEach(enumValueSynonym ->
            {
                RosettaEnumValue enumRef = enumValueSynonym.getEnumRef();
                System.out.println(String.format("  %s -> %s", EnumHelper.formatEnumName(enumRef.getName()), 
                        enumValueSynonym.getExternalEnumSynonyms().stream().map(ees -> ees.getSynonymValue()).collect(Collectors.joining(", "))));
            });
        });


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
