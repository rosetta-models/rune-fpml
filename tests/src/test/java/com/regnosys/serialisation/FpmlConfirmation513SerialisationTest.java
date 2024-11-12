package com.regnosys.serialisation;

import com.regnosys.TestUtil;
import fpml.confirmation.DataDocument;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

import static com.regnosys.TestUtil.*;

public class FpmlConfirmation513SerialisationTest {

    private static final String XSD_SCHEMA_NAME = "schemas/fpml-5-13/confirmation/fpml-main-5-13.xsd";
    private static final String EXPECTED_SCHEMA_LOCATION = "http://www.fpml.org/FpML-5/confirmation ../../../../schemas/fpml-5-13/confirmation/" + XSD_SCHEMA_NAME;

    private static SerialisationTestUtil<DataDocument> serialisationTestUtil;

    @BeforeAll
    static void setup() {
        serialisationTestUtil = new SerialisationTestUtil<>(
                DataDocument.class,
                XSD_SCHEMA_NAME,
                XML_CONFIG_NAME,
                EXPECTED_SCHEMA_LOCATION
        );
    }

    public static Stream<Arguments> xmlSampleFiles() {
        return TestUtil.getXmlSampleFiles(INPUT_ROOT_PATH, EXCLUDED_FILES);
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("xmlSampleFiles")
    public void testSerialisation(String name, Path samplePath) throws IOException {
        serialisationTestUtil.assertXmlRoundTrip(samplePath);
    }
}
