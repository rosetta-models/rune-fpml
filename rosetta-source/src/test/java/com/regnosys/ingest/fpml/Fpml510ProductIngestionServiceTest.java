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

class Fpml510ProductIngestionServiceTest {

    private static IngestionService ingestionService;
    private static IngestTestUtil test;

    @BeforeAll
    static void setup() {
        CdmRuntimeModule runtimeModule = new CdmRuntimeModule();
        IngestionService ingestionService = new FpmlConfirmationToTradeStateIngestionService(runtimeModule);
        test = new IngestTestUtil(DataDocument.class, XML_CONFIG_NAME, ingestionService);
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("fpMLFiles")
    protected void ingest(String name, Path samplePath) throws IOException {
        test.assertIngest(samplePath);
    }

    @SuppressWarnings("unused")//used by the junit parameterized test
    private static Stream<Arguments> fpMLFiles() {
        return getXmlSampleFiles(SAMPLE_FILES_PATH + "/fpml-5-10/products");
    }
}