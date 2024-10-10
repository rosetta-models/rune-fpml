package fpml.serialisation;

import fpml.confirmation.DataDocument;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FpmlConfirmationSerialisationTest {
    
    private static final String XML_CONFIG_NAME = "xml-config/xml-config.json";
    private static final String SAMPLE_FILE_DIRECTORY = "sample-files/fpml-5-10/products/";

    private static final String XSD_SCHEMA_NAME = "schemas/fpml-5-10/confirmation/fpml-main-5-10.xsd";
    private static final String EXPECTED_SCHEMA_LOCATION = "urn:iso:std:iso:20022:tech:xsd:auth.030.001.03 ../../../main/resources/" + XSD_SCHEMA_NAME;

    private final SerialisationTestUtil<DataDocument> serialisationTestUtil;

    public FpmlConfirmationSerialisationTest() throws IOException, SAXException {
        this.serialisationTestUtil = new SerialisationTestUtil<>(
                DataDocument.class,
                XSD_SCHEMA_NAME,
                XML_CONFIG_NAME,
                EXPECTED_SCHEMA_LOCATION
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("getSampleFiles")
    public void testSerialisation(String name, Path samplePath) throws IOException {
        serialisationTestUtil.assertXmlRoundTrip(samplePath);
    }

    public static Stream<Arguments> getSampleFiles() throws IOException {
        return SerialisationTestUtil.getSampleFiles(SAMPLE_FILE_DIRECTORY);
    }
}
