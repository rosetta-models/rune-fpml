package com.regnosys.runefpml;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The confirmation and recordkeeping views have distinct target namespaces, so a document of one view never
 * validates against the other view's schema.
 */
class RuneFpmlModelConfigTest {

    @Test
    void confirmationSchemaPathPointsAtConfirmationView() throws Exception {
        assertEquals("http://www.fpml.org/FpML-5/confirmation",
                targetNamespace(RuneFpmlModelConfig.FPML_CONFIRMATION_SCHEMA_PATH));
    }

    @Test
    void recordkeepingSchemaPathPointsAtRecordkeepingView() throws Exception {
        assertEquals("http://www.fpml.org/FpML-5/recordkeeping",
                targetNamespace(RuneFpmlModelConfig.FPML_RECORDKEEPING_SCHEMA_PATH));
    }

    private static String targetNamespace(String schemaPath) throws Exception {
        try (InputStream schema = Objects.requireNonNull(
                RuneFpmlModelConfigTest.class.getResourceAsStream("/" + schemaPath), schemaPath)) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            Document document = factory.newDocumentBuilder().parse(schema);
            return document.getDocumentElement().getAttribute("targetNamespace");
        }
    }
}
