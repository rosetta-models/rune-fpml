package com.regnosys.ingest.fpml;

import cdm.event.common.TradeState;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.regnosys.TestUtil;
import com.regnosys.ingest.IngestionService;
import com.regnosys.rosetta.common.serialisation.RosettaObjectMapper;
import com.regnosys.rosetta.common.util.Report;
import fpml.confirmation.DataDocument;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class IngestTestUtil<T> {

    private final Class<T> rootType;
    private final ObjectMapper xmlMapper;
    private final ObjectMapper jsonMapper;
    private final ObjectWriter jsonWriter;
    private final IngestionService ingestionService;

    public IngestTestUtil(Class<T> rootType, String xmlConfigPath, IngestionService ingestionService) {
        this.rootType = rootType;
        this.xmlMapper = TestUtil.getXmlMapper(xmlConfigPath);
        this.jsonMapper = RosettaObjectMapper.getNewMinimalRosettaObjectMapper();
        this.jsonWriter = jsonMapper.writerWithDefaultPrettyPrinter();
        this.ingestionService = ingestionService;
    }

    public void assertIngest(Path samplePath) throws IOException {
        String inputXml = Files.readString(samplePath);

        DataDocument dataDocument = null; // (DataDocument) xmlMapper.readValue(inputXml, rootType);

        Report<TradeState> ingestReport = ingestionService.ingestAndPostProcess(dataDocument);

        assertNotNull(ingestReport);

        String actualJson = jsonWriter.writeValueAsString(ingestReport.getRosettaModelInstance());

        Path expectedOutputPath = getExpectedOutputPath(samplePath);
        String expectedJson = Files.readString(expectedOutputPath);

        assertEquals(expectedJson, actualJson);
    }

    public static Path getExpectedOutputPath(Path samplePath) {
        return Path.of(samplePath.toString()
                .replace("classes/sample-files", "test-classes/expected-output-files")
                .replace(".xml", ".json"));
    }
}
