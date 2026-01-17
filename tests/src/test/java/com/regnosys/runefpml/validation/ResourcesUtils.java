package com.regnosys.runefpml.validation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;
import com.regnosys.rosetta.common.hashing.ReferenceConfig;
import com.regnosys.rosetta.common.hashing.ReferenceResolverProcessStep;
import com.regnosys.rosetta.common.serialisation.RosettaObjectMapperCreator;
import com.regnosys.runefpml.RuneFpmlModelConfig;
import com.rosetta.model.lib.RosettaModelObject;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class ResourcesUtils {

    private static final ObjectMapper XML_OBJECT_MAPPER = getXmlMapper();

    public static String getContent(String resourceName) {
        try {
            URL url = Resources.getResource(resourceName);
            return Resources.toString(url, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static <T extends RosettaModelObject> T getObject(Class<T> clazz, String resourceName) {
        try {
            String xml = getContent(resourceName);
            return XML_OBJECT_MAPPER.readValue(xml, clazz);
        } catch (JsonProcessingException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static <T extends RosettaModelObject> T getObjectAndResolveReferences(Class<T> clazz, String resourceName) {
        T object = getObject(clazz, resourceName);
        return resolveReferences(object);
    }

    private static <T extends RosettaModelObject> T resolveReferences(T object) {
        RosettaModelObject builder = object.toBuilder();
        new ReferenceResolverProcessStep(ReferenceConfig.noScopeOrExcludedPaths()).runProcessStep(builder.getType(), builder);
        //noinspection unchecked
        return (T) builder.build();
    }

    private static ObjectMapper getXmlMapper() {
        ClassLoader classLoader = ResourcesUtils.class.getClassLoader();
        URL resource = Objects.requireNonNull(classLoader.getResource(RuneFpmlModelConfig.XML_CONFIG_PATH));
        try {
            return RosettaObjectMapperCreator.forXML(resource.openStream(), classLoader).create();
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to create XML mapper", e);
        }
    }
}
