package com.regnosys.fpml.ingest.typesfixed.functions;

import com.rosetta.model.metafields.FieldWithMetaString;
import fpml.ingest.typesfixed.functions.MapIdentifierWithScheme;

import static com.regnosys.fpml.ingest.typesfixed.functions.MetaUtils.createStringWithMetaScheme;

public class MapIdentifierWithSchemeImpl extends MapIdentifierWithScheme {
    @Override
    protected FieldWithMetaString doEvaluate(String identifier, String scheme) {
        return createStringWithMetaScheme(identifier, scheme).build();

    }
}
