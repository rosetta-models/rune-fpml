package com.regnosys;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;
import com.regnosys.rosetta.common.serialisation.RosettaObjectMapperCreator;
import com.regnosys.rosetta.common.util.ClassPathUtils;
import com.regnosys.rosetta.common.util.UrlUtils;
import com.regnosys.serialisation.SerialisationTestUtil;
import org.junit.jupiter.params.provider.Arguments;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class TestUtil {

    public static final String XML_CONFIG_NAME = "xml-config/xml-config.json";
    public static final String SAMPLE_FILE_DIRECTORY = "sample-files/fpml-5-10/products/";
    
    public static Stream<Arguments> getSampleFiles(String sampleFileDirectory) {
        return ClassPathUtils
                .findPathsFromClassPath(List.of(sampleFileDirectory), ".*\\.xml", Optional
                        .empty(), SerialisationTestUtil.class.getClassLoader())
                .stream()
                .map(UrlUtils::toUrl)
                .map(UrlUtils::toPath)
                .map(path -> Arguments.of(path.getFileName().toString(), path));
    }

    public static ObjectMapper getXmlMapper(String xmlConfigPath) {
        try {
            return RosettaObjectMapperCreator.forXML(
                    Resources.getResource(xmlConfigPath).openStream()).create();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
