package com.regnosys.runefpml.serialisation;

import com.regnosys.runefpml.RuneFpmlModelConfig;
import fpml.consolidated.doc.Document;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;
import java.util.stream.Stream;

import static com.regnosys.runefpml.serialisation.SerialisationTestUtil.INPUT_ROOT_PATH;

public class FpmlConfirmationSerialisationTest {
    
    private static final Set<String> DISABLED_TESTS = Set.of();

    private static SerialisationTestUtil<Document> serialisationTestUtil;

    @BeforeAll
    static void setup() {
        serialisationTestUtil = new SerialisationTestUtil<>(
                Document.class,
                RuneFpmlModelConfig.FPML_CONFIRMATION_SCHEMA_PATH,
                RuneFpmlModelConfig.FPML_CONFIRMATION_XML_CONFIG_PATH,
                "http://www.fpml.org/FpML-5/confirmation schemas/fpml-5-13/confirmation/fpml-main-5-13.xsd"
        );
    }

    public static Stream<Arguments> xmlSampleFiles() {
        return SerialisationTestUtil.getXmlSampleFiles(INPUT_ROOT_PATH, DISABLED_TESTS);
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("xmlSampleFiles")
    public void testSerialisation(String name, Path samplePath) throws IOException {
        serialisationTestUtil.assertXmlRoundTrip(samplePath);
    }
}
