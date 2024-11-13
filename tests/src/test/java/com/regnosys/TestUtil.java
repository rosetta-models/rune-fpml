package com.regnosys;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.google.common.io.Resources;
import com.regnosys.rosetta.common.serialisation.RosettaObjectMapperCreator;
import com.regnosys.rosetta.common.util.UrlUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.provider.Arguments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestUtil {

    public static final String XML_CONFIG_NAME = "xml-config/confirmation-v5_13-rosetta-xml-config.json";

    public static final String INPUT_ROOT_PATH = "serialisation/input";
    public static final String EXPECTED_INPUT_ROOT_PATH = "serialisation/output";

    public static Set<String> EXCLUDED_FILES = Set.of(
            "com-ex09-oil-put-option-american.xml",
            "eqs-ex03-european-call-price-return-Index.xml",
            "cds-index-tranche.xml");

    private static final Logger LOGGER = LoggerFactory.getLogger(TestUtil.class);
    private static final boolean WRITE_EXPECTATIONS =
            Optional.ofNullable(System.getenv("WRITE_EXPECTATIONS"))
                    .map(Boolean::parseBoolean)
                    .orElse(false);

    public static Stream<Arguments> getXmlSampleFiles(String sampleFileDirectory, Set<String> excludedFiles) {
        URL url = Objects.requireNonNull(TestUtil.class.getResource("/" + sampleFileDirectory));
        Path start = UrlUtils.toPath(url);
        PathMatcher xmlFileMatcher = FileSystems.getDefault().getPathMatcher("glob:*.xml");
        try (Stream<Path> paths = Files.walk(start)) {
            List<Path> sampleFilePaths = paths
                    .filter(Files::isRegularFile)
                    .filter(p -> xmlFileMatcher.matches(p.getFileName()))
                    .filter(Files::exists)
                    .filter(p -> !excludedFiles.contains(p.getFileName().toString()))
                    .collect(Collectors.toList());
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
            URL url = Objects.requireNonNull(TestUtil.class.getResource("/" + xmlConfigPath));
            ObjectMapper mapper = RosettaObjectMapperCreator.forXML(url.openStream()).create();
            ((XmlMapper) mapper).configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
            return mapper;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
