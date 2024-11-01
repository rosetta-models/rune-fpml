package com.regnosys.fpml.ingest.typesfixed.functions;

import com.rosetta.model.metafields.FieldWithMetaString;
import fpml.ingest.typesfixed.functions.MapNameWithScheme;

import static com.regnosys.fpml.ingest.typesfixed.functions.MetaUtils.createStringWithMetaScheme;

public class MapNameWithSchemeImpl extends MapNameWithScheme {
    @Override
    protected FieldWithMetaString doEvaluate(String name, String scheme) {
        return createStringWithMetaScheme(name, scheme).build();

    }
}
