package com.regnosys;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.regnosys.rosetta.common.serialisation.RosettaObjectMapperCreator;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Optional;

public class TestUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestUtil.class);

    private static final boolean WRITE_EXPECTATIONS =
            Optional.ofNullable(System.getenv("WRITE_EXPECTATIONS"))
                    .map(Boolean::parseBoolean)
                    .orElse(false);

    public static void assertEquals(Path expectedPath, String actual) {
        String expected = readFile(expectedPath);
        if (!Objects.equals(expected, actual)) {
            if (WRITE_EXPECTATIONS) {
                writeFile(expectedPath, actual);
            }
        }
        Assertions.assertEquals(expected, actual);
    }

    private static String readFile(Path path) {
        try {
            return Files.readString(path);
        } catch (IOException e) {
            LOGGER.error("Failed to read file {}", path, e);
            return null;
        }
    }

    private static void writeFile(Path filePath, String content) {
        try {
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, content.getBytes());
            LOGGER.warn("Updated sample file {}", filePath);
        } catch (IOException e) {
            LOGGER.error("Failed to write sample file {}", filePath, e);
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
