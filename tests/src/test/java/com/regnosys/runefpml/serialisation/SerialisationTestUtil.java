package com.regnosys.runefpml.serialisation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.regnosys.rosetta.common.util.UrlUtils;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.provider.Arguments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;
import org.xmlunit.matchers.CompareMatcher;

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
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.regnosys.runefpml.TestUtil.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SerialisationTestUtil<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SerialisationTestUtil.class);

    public static final String INPUT_ROOT_PATH = "serialisation/input";
    public static final String EXPECTED_INPUT_ROOT_PATH = "serialisation/output";

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
        URL schemaFile = Objects.requireNonNull(SerialisationTestUtil.class.getResource("/" + xsdSchemaPath));
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
        Boolean validAgainstSchema = isValidAgainstSchema(inputXml);
        assertNotNull(validAgainstSchema);
        assertTrue(validAgainstSchema);

        T document = xmlMapper.readValue(inputXml, rootType);

        // Check serialised document against expectations
        String actualXml = xmlWriter.writeValueAsString(document);
        Path expectedXmlSamplePath = getExpectedXmlSamplePath(samplePath);
        assertEquals(expectedXmlSamplePath, actualXml);

        // Check actual XML also follows the XSD schema
//        assertTrue(isValidAgainstSchema(actualXml));

        // Check serialised document is similar to the original XML
//        assertAgainstInputXml(actualXml, inputXml, document);

        // Check deserialisation results again in the same Document
//        assertAgainstInputObject(actualXml, document);
    }

    private void assertAgainstInputObject(String actualXml, T inputDocument) throws JsonProcessingException {
        T actualDocument = xmlMapper.readValue(actualXml, rootType);
        
        Assertions.assertEquals(inputDocument, actualDocument);
    }

    private void assertAgainstInputXml(String actualXml, String inputXml) {
        MatcherAssert.assertThat(
                actualXml, CompareMatcher.isSimilarTo(inputXml)
                        .ignoreWhitespace()
                        .ignoreComments());
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

    public static Stream<Arguments> getXmlSampleFiles(String sampleFileDirectory, Set<String> excludedFiles) {
        URL url = Objects.requireNonNull(SerialisationTestUtil.class.getResource("/" + sampleFileDirectory));
        Path start = UrlUtils.toPath(url);
        PathMatcher xmlFileMatcher = FileSystems.getDefault().getPathMatcher("glob:*.xml");
        try (Stream<Path> paths = Files.walk(start)) {
            List<Path> sampleFilePaths = paths
                    .filter(Files::isRegularFile)
                    .filter(p -> xmlFileMatcher.matches(p.getFileName()))
                    .filter(Files::exists)
                    .filter(p -> excludedFiles.stream().noneMatch(ep -> p.toString().endsWith(ep)))
                    .collect(Collectors.toList());
            return sampleFilePaths.stream()
                    .map(path -> Arguments.of(getTestName(path), path));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private static String getTestName(Path path) {
        return path.toString().split(INPUT_ROOT_PATH)[1].substring(1);
    }

    private static Path getExpectedXmlSamplePath(Path samplePath) {
        String samplePathStr = samplePath.toString();
        return Path.of("src/test/resources/" + samplePathStr
                        .substring(samplePathStr.indexOf(INPUT_ROOT_PATH))
                        .replace(INPUT_ROOT_PATH, EXPECTED_INPUT_ROOT_PATH))
                .toAbsolutePath();
    }
}
