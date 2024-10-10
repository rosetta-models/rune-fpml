package com.regnosys.ingest;

import com.regnosys.rosetta.common.util.Report;
import com.rosetta.model.lib.RosettaModelObject;
import fpml.confirmation.DataDocument;

public interface IngestionService {

    <T extends RosettaModelObject> Report<T> ingestAndPostProcess(DataDocument dataDocument);
}
