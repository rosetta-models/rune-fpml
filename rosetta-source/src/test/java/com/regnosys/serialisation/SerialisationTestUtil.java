package com.regnosys.serialisation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.google.common.io.Resources;
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

import static com.regnosys.TestUtil.getXmlMapper;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SerialisationTestUtil<T> {

    private final Class<T> rootType;
    private final Validator xsdValidator;
    private final ObjectMapper xmlMapper;
    private final ObjectWriter xmlWriter;

    public SerialisationTestUtil(Class<T> rootType, String xsdSchemaPath, String xmlConfigPath, String expectedSchemaLocationAttribute) {
        this.rootType = rootType;
        this.xsdValidator = getXmlValidator(xsdSchemaPath);
        this.xmlMapper = getXmlMapper(xmlConfigPath);
        ((XmlMapper)xmlMapper).configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
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

        assertEquals(expectedXml, actualXml);

//        assertThat(
//                actualXml, isSimilarTo(expectedXml)
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
            //LOGGER.error("Schema validation failed: {}", e.getMessage());
            return false;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static Path getExpectedSamplePath(Path samplePath) {
        return Path.of(samplePath.toString()
                .replace("classes/sample-files", "test-classes/expected-sample-files"));
    }
}
