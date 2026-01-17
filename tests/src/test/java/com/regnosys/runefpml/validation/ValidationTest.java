package com.regnosys.runefpml.validation;

import com.google.inject.Guice;
import com.regnosys.rosetta.common.validation.RosettaTypeValidator;
import com.regnosys.rosetta.common.validation.ValidationReport;
import com.regnosys.runefpml.RuneFpmlTestRuntimeModule;
import fpml.confirmation.DataDocument;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class ValidationTest {

    @Inject
    private RosettaTypeValidator validateProcessor;

    @BeforeEach
    void createInjectorAndInject() {
        Guice.createInjector(new RuneFpmlTestRuntimeModule()).injectMembers(this);
    }
    
    @Test
    void shouldValidateSample() throws RuntimeException {
        // Deserialise (and resolve references)
        String resourceName = "serialisation/input/fpml-5-10/products/credit/cd-ex01-long-asia-corp-fixreg-versioned.xml";
        DataDocument dataDocument = ResourcesUtils.getObjectAndResolveReferences(DataDocument.class, resourceName);
        DataDocument.DataDocumentBuilder dataDocumentBuilder = dataDocument.toBuilder();

        // Validate
        ValidationReport validationReport = validateProcessor.runProcessStep(DataDocument.class, dataDocumentBuilder);
        validationReport.logReport(); // logs validation failures as DEBUG and validation success as TRACE
        assertThat(validationReport.validationFailures(), hasSize(12));
    }
}
