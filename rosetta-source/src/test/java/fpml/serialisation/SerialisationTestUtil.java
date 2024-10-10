package fpml.serialisation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.common.io.Resources;
import com.regnosys.rosetta.common.serialisation.RosettaObjectMapperCreator;
import com.regnosys.rosetta.common.util.ClassPathUtils;
import com.regnosys.rosetta.common.util.PathUtils;
import com.regnosys.rosetta.common.util.UrlUtils;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.params.provider.Arguments;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.xmlunit.matchers.CompareMatcher.isSimilarTo;

public class SerialisationTestUtil<T> {
    
    private final Class<T> rootType;
    private final Validator xsdValidator;
    private final ObjectMapper xmlMapper;
    private final ObjectWriter xmlWriter;

    public SerialisationTestUtil(Class<T> rootType, String xsdSchemaPath, String xmlConfigPath, String expectedSchemaLocationAttribute) throws IOException, SAXException {
        this.rootType = rootType;
        URL schemaFile = Resources.getResource(xsdSchemaPath);
        SchemaFactory schemaFactory = SchemaFactory
                .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        schemaFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, false);
        Schema schema = schemaFactory.newSchema(schemaFile);
        this.xsdValidator = schema.newValidator();
        this.xmlMapper = RosettaObjectMapperCreator.forXML(
                Resources.getResource(xmlConfigPath).openStream()).create();
        this.xmlWriter = xmlMapper
                .writerWithDefaultPrettyPrinter()
                .withAttribute("schemaLocation", expectedSchemaLocationAttribute);
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

    private Path getExpectedSamplePath(Path samplePath) {
        return Path.of(samplePath.toString().replace("class/sample-files", "test-classes/expected-sample-files"));
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
    
    public static Stream<Arguments> getSampleFiles(String sampleFileDirectory) throws IOException {
        return ClassPathUtils
                .findPathsFromClassPath(List.of(sampleFileDirectory), ".*\\.xml", Optional
                        .empty(), SerialisationTestUtil.class.getClassLoader())
                .stream()
                .map(UrlUtils::toUrl)
                .map(UrlUtils::toPath)
                .map(path -> Arguments.of(path.getFileName().toString(), path));
    }
}
