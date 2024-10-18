package com.regnosys.ingest.fpml;

import com.regnosys.fpml.FpmlConfirmationToTradeStateIngestionService;
import com.regnosys.ingest.IngestionService;
import fpml.confirmation.DataDocument;
import org.finos.cdm.CdmRuntimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

import static com.regnosys.TestUtil.*;

class FpmlConfirmation510ProductIngestionTest {

    private static IngestTestUtil test;

    @BeforeAll
    static void setup() {
        CdmRuntimeModule runtimeModule = new CdmRuntimeModule();
        IngestionService ingestionService = new FpmlConfirmationToTradeStateIngestionService(runtimeModule);
        test = new IngestTestUtil(DataDocument.class, XML_CONFIG_NAME, ingestionService);
    }

    @SuppressWarnings("unused") //used by the junit parameterized test
    private static Stream<Arguments> xmlSampleFiles() {
        return getXmlSampleFiles(INPUT_ROOT_PATH + FPML_5_10_PRODUCTS);
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("xmlSampleFiles")
    protected void ingest(String name, Path samplePath) throws IOException {
        test.assertIngest(samplePath);
    }
}