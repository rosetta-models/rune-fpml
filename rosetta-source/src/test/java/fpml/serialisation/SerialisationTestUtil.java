package fpml.serialisation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.common.io.Resources;
import com.regnosys.rosetta.common.serialisation.RosettaObjectMapperCreator;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.provider.Arguments;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
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
        schemaFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING,false);
        Schema schema = schemaFactory.newSchema(schemaFile);
        xsdValidator = schema.newValidator();

        xmlMapper = RosettaObjectMapperCreator.forXML(
                Resources.getResource(xmlConfigPath).openStream()).create();
        xmlWriter = xmlMapper
                .writerWithDefaultPrettyPrinter()
                .withAttribute("schemaLocation", expectedSchemaLocationAttribute);
    }

    public void assertXMLRoundtrip(URL sample) throws IOException {
        String expectedXML = Resources.toString(sample, StandardCharsets.UTF_8);

        // Sanity check: input follows the XSD schema
        assertDoesNotThrow(() -> xsdValidator.validate(new StreamSource(new ByteArrayInputStream(expectedXML.getBytes(StandardCharsets.UTF_8)))));

        // Check deserialisation does not throw
        T document = xmlMapper.readValue(sample, rootType);

        // Check serialised document is similar to the original XML
        String actualXML = xmlWriter.writeValueAsString(document);
        assertThat(
                actualXML, isSimilarTo(expectedXML)
                        .ignoreWhitespace()
                        .ignoreComments()
        );

        // Check actual XML also follows the XSD schema
        assertDoesNotThrow(() -> xsdValidator.validate(new StreamSource(new ByteArrayInputStream(actualXML.getBytes(StandardCharsets.UTF_8)))));

        // Check deserialisation results again in the same Document
        assertEquals(document, xmlMapper.readValue(actualXML, rootType));
    }

    public static Stream<Arguments> getSampleFiles(String sampleFileDirectory) throws IOException {
        return Resources.readLines(Resources.getResource(sampleFileDirectory), StandardCharsets.UTF_8)
                .stream()
                .map(sampleName ->
                        Arguments.of(Named.of(sampleName, Resources.getResource(sampleFileDirectory + "/" + sampleName))));
    }
}
