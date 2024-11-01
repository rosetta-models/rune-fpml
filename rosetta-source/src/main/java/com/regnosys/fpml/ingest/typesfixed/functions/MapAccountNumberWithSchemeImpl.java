package com.regnosys.fpml.ingest.typesfixed.functions;

import com.rosetta.model.metafields.FieldWithMetaString;
import fpml.ingest.typesfixed.functions.MapAccountNumberWithScheme;

import static com.regnosys.fpml.ingest.typesfixed.functions.MetaUtils.createStringWithMetaScheme;

public class MapAccountNumberWithSchemeImpl extends MapAccountNumberWithScheme {
    @Override
    protected FieldWithMetaString doEvaluate(String accountNumber, String scheme) {
        return createStringWithMetaScheme(accountNumber, scheme).build();

    }
}
