package com.regnosys.fpml.ingest.types.functions;

import com.rosetta.model.metafields.FieldWithMetaString;
import fpml.ingest.types.functions.MapIdentifierWithScheme;

import static com.regnosys.fpml.ingest.types.functions.MetaUtils.createStringWithMetaScheme;

public class MapIdentifierWithSchemeImpl extends MapIdentifierWithScheme {
    @Override
    protected FieldWithMetaString doEvaluate(String identifier, String scheme) {
        return createStringWithMetaScheme(identifier, scheme).build();

    }
}
