package com.regnosys;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.regnosys.rosetta.common.serialisation.RosettaObjectMapperCreator;
import com.regnosys.rosetta.common.util.UrlUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.provider.Arguments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class TestUtil {

    public static final String XML_CONFIG_NAME = "xml-config/confirmation-v5_10-rosetta-xml-config.json";
    
    public static final String INPUT_ROOT_PATH = "sample-files";
    public static final String EXPECTED_INPUT_ROOT_PATH = "expected-sample-files";
    public static final String EXPECTED_OUTPUT_ROOT_PATH = "expected-output-files";
    public static final String TARGET_OUTPUT_ROOT_PATH = "target-output-files";

    public static Set<String> EXCLUDED_FILES = Set.of(
            "com-ex09-oil-put-option-american.xml", 
            "eqs-ex03-european-call-price-return-Index.xml", 
            "cds-index-tranche.xml");
    
    public static final String FPML_5_10_PRODUCTS = "/fpml-5-10/products";

    private static final Logger LOGGER = LoggerFactory.getLogger(TestUtil.class);
    private static final boolean WRITE_EXPECTATIONS =
            Optional.ofNullable(System.getenv("WRITE_EXPECTATIONS"))
                    .map(Boolean::parseBoolean).orElse(false);

    public static Stream<Arguments> getXmlSampleFiles(String sampleFileDirectory, Set<String> excludedFiles) {
        Path start = UrlUtils.toPath(TestUtil.class.getResource("/" + sampleFileDirectory));
        PathMatcher xmlFileMatcher = FileSystems.getDefault().getPathMatcher("glob:*.xml");
        try (Stream<Path> paths = Files.walk(start)) {
            List<Path> sampleFilePaths = paths
                    .filter(Files::isRegularFile)
                    .filter(p -> xmlFileMatcher.matches(p.getFileName()))
                    .filter(Files::exists)
                    .filter(p -> !excludedFiles.contains(p.getFileName().toString()))
                    .toList();
            return sampleFilePaths.stream()
                    .map(path -> Arguments.of(path.getFileName().toString(), path));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static Path getExpectedXmlSamplePath(Path samplePath) {
        String samplePathStr = samplePath.toString();
        return Path.of("src/test/resources/" + samplePathStr
                        .substring(samplePathStr.indexOf(INPUT_ROOT_PATH))
                        .replace(INPUT_ROOT_PATH, EXPECTED_INPUT_ROOT_PATH))
                .toAbsolutePath();
    }

    public static Path getExpectedOutputPath(Path samplePath) {
        String samplePathStr = samplePath.toString();
        return Path.of("src/test/resources/" + samplePathStr
                        .substring(samplePathStr.indexOf(INPUT_ROOT_PATH))
                        .replace(INPUT_ROOT_PATH, EXPECTED_OUTPUT_ROOT_PATH)
                        .replace(".xml", ".json"))
                .toAbsolutePath();
    }

    public static Path getTargetOutputPath(Path samplePath) {
        String samplePathStr = samplePath.toString();
        return Path.of("src/test/resources/" + samplePathStr
                        .substring(samplePathStr.indexOf(INPUT_ROOT_PATH))
                        .replace(INPUT_ROOT_PATH, TARGET_OUTPUT_ROOT_PATH)
                        .replace(".xml", ".json"))
                .toAbsolutePath();
    }
    
    public static void assertEquals(String expected, String actual, Path filePath) {
        if (!expected.equals(actual)) {
            if (WRITE_EXPECTATIONS) {
                writeExpectation(filePath, actual);
            }
        }
        Assertions.assertEquals(expected, actual);
    }

    private static void writeExpectation(Path filePath, String content) {
        if (Files.exists(filePath)) {
            try {
                Files.createDirectories(filePath.getParent());
                Files.write(filePath, content.getBytes());
                LOGGER.warn("Updated expectation file {}", filePath);
            } catch (IOException e) {
                LOGGER.error("Failed to write expectation file {}", filePath, e);
            }
        }
    }

    public static ObjectMapper getXmlMapper(String xmlConfigPath) {
        try {
            return RosettaObjectMapperCreator.forXML(
                    TestUtil.class.getResource("/" + xmlConfigPath).openStream()).create();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
