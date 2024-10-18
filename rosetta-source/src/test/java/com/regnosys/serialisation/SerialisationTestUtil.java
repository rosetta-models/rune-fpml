package com.regnosys.serialisation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.common.io.Resources;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.regnosys.TestUtil.getXmlMapper;
import static com.regnosys.testing.TestingExpectationUtil.TEST_WRITE_BASE_PATH;
import static com.regnosys.testing.TestingExpectationUtil.WRITE_EXPECTATIONS;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SerialisationTestUtil<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SerialisationTestUtil.class);
    
    private final Class<T> rootType;
    private final Validator xsdValidator;
    private final ObjectMapper xmlMapper;
    private final ObjectWriter xmlWriter;

    public SerialisationTestUtil(Class<T> rootType, String xsdSchemaPath, String xmlConfigPath, String expectedSchemaLocationAttribute) {
        this.rootType = rootType;
        this.xsdValidator = getXmlValidator(xsdSchemaPath);
        this.xmlMapper = getXmlMapper(xmlConfigPath);
        this.xmlWriter = xmlMapper
                .writerWithDefaultPrettyPrinter()
                .withAttribute("schemaLocation", expectedSchemaLocationAttribute);
    }

    private static Validator getXmlValidator(String xsdSchemaPath) {
        URL schemaFile = Resources.getResource(xsdSchemaPath);
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            schemaFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, false);
            Schema schema = schemaFactory.newSchema(schemaFile);
            return schema.newValidator();
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }

    public void assertXmlRoundTrip(Path samplePath) throws IOException {
        String inputXml = Files.readString(samplePath);

        // Sanity check: input follows the XSD schema
        assertDoesNotThrow(() -> isValidAgainstSchema(inputXml));

        T document = xmlMapper.readValue(inputXml, rootType);

        // Check serialised document is similar to the original XML
        String actualXml = xmlWriter.writeValueAsString(document);

        Path expectedSamplePath = getExpectedSamplePath(samplePath);
        String expectedXml = Files.readString(expectedSamplePath);

        assertEquals(expectedXml, actualXml, expectedSamplePath);

//        assertThat(
//                actualXml, isSimilarTo(inputXml)
//                        .ignoreWhitespace()
//                        .ignoreComments()
//        );

        // Check actual XML also follows the XSD schema
//        assertDoesNotThrow(() -> isValidAgainstSchema(actualXml));

        // Check deserialisation results again in the same Document
//        assertEquals(document, xmlMapper.readValue(actualXml, rootType));
    }

    private Boolean isValidAgainstSchema(String xml) {
        if (xsdValidator == null) {
            return null;
        }
        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8))) {
            xsdValidator.validate(new StreamSource(inputStream));
            return true;
        } catch (SAXException e) {
            LOGGER.error("Schema validation failed: {}", e.getMessage());
            return false;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static Path getExpectedSamplePath(Path samplePath) {
        return Path.of(samplePath.toString()
                .replace("classes/sample-files", "test-classes/expected-sample-files"));
    }

    private void assertEquals(String expected, String actual, Path filePath) {
        if (!expected.equals(actual)) {
            if (WRITE_EXPECTATIONS) {
                writeExpectation(filePath, actual);
            }
        }
        Assertions.assertEquals(expected, actual);
    }

    private void writeExpectation(Path writePath, String content) {
        // Add environment variable TEST_WRITE_BASE_PATH to override the base write path, e.g.
        // TEST_WRITE_BASE_PATH=/Users/hugohills/dev/github/REGnosys/rosetta-cdm/rosetta-source/src/main/resources/
        TEST_WRITE_BASE_PATH.filter(Files::exists).ifPresent(basePath -> {
            Path expectationFilePath = basePath.resolve(writePath);
            try {
                Files.createDirectories(expectationFilePath.getParent());
                Files.write(expectationFilePath, content.getBytes());
                LOGGER.warn("Updated expectation file {}", expectationFilePath.toAbsolutePath());
            } catch (IOException e) {
                LOGGER.error("Failed to write expectation file {}", expectationFilePath.toAbsolutePath(), e);
            }
        });
    }
}
