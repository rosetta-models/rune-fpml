package com.regnosys.fpml.ingest.types.functions;

import com.rosetta.model.metafields.FieldWithMetaString;
import fpml.ingest.types.functions.MapNameWithScheme;

import static com.regnosys.fpml.ingest.types.functions.MetaUtils.createStringWithMetaScheme;

public class MapNameWithSchemeImpl extends MapNameWithScheme {
    @Override
    protected FieldWithMetaString doEvaluate(String name, String scheme) {
        return createStringWithMetaScheme(name, scheme).build();

    }
}
