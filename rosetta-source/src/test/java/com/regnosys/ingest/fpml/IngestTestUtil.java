package com.regnosys.ingest.fpml;

import cdm.event.common.TradeState;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.regnosys.TestUtil;
import com.regnosys.ingest.IngestionService;
import com.regnosys.rosetta.common.serialisation.RosettaObjectMapper;
import com.regnosys.rosetta.common.util.Report;
import fpml.confirmation.DataDocument;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.regnosys.TestUtil.*;
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

        // hardcode to DataDocument for now
        DataDocument dataDocument = (DataDocument) xmlMapper.readValue(inputXml, rootType);

        Report<TradeState> ingestReport = ingestionService.ingestAndPostProcess(dataDocument);
        assertNotNull(ingestReport);

        String actualJson = jsonWriter.writeValueAsString(ingestReport.getRosettaModelInstance());

        // compare against expected output
        Path expectedOutputPath = getExpectedOutputPath(samplePath);
        String expectedJson = Files.readString(expectedOutputPath);
        assertEquals(expectedJson, actualJson, expectedOutputPath);

        // compare against target output
        Path targetOutputPath = getTargetOutputPath(samplePath);
        String targetJson = Files.readString(targetOutputPath);
        Assertions.assertEquals(targetJson, actualJson);
    }
}
