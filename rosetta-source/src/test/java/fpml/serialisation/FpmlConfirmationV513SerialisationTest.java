package fpml.serialisation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.xml.sax.SAXException;

import javax.swing.text.Document;
import java.io.IOException;
import java.net.URL;
import java.util.stream.Stream;

/*public class FpmlConfirmationV513SerialisationTest {
    private static final String XSD_SCHEMA_NAME = "schemas/fpml-5-13/confirmation/fpml-main-5-13.xsd";
    private static final String XML_CONFIG_NAME = "xml-config/confirmation-v5-13-rosetta-xml-config.json";
    private static final String SAMPLE_FILE_DIRECTORY = "fpml-5-13/confirmation";
    private static final String EXPECTED_SCHEMA_LOCATION = "urn:iso:std:iso:20022:tech:xsd:auth.030.001.03 ../../../main/resources/" + XSD_SCHEMA_NAME;

    private final SerialisationTestUtil<Document> serialisationTestUtil;

    public FpmlConfirmationV513SerialisationTest() throws IOException, SAXException {
        serialisationTestUtil = new SerialisationTestUtil<>(
                Document.class,
                XSD_SCHEMA_NAME,
                XML_CONFIG_NAME,
                EXPECTED_SCHEMA_LOCATION
        );
    }

    @ParameterizedTest
    @MethodSource("getSampleFiles")
    public void testSerialisation(URL sample) throws IOException, SAXException {
        serialisationTestUtil.assertXMLRoundtrip(sample);
    }

    public static Stream<Arguments> getSampleFiles() throws IOException {
        return SerialisationTestUtil.getSampleFiles(SAMPLE_FILE_DIRECTORY);
    }
}*/
