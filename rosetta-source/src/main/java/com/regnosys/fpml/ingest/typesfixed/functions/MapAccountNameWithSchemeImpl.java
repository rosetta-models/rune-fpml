package com.regnosys.fpml.ingest.typesfixed.functions;

import com.rosetta.model.metafields.FieldWithMetaString;
import fpml.ingest.typesfixed.functions.MapAccountNameWithScheme;

import static com.regnosys.fpml.ingest.typesfixed.functions.MetaUtils.createStringWithMetaScheme;

public class MapAccountNameWithSchemeImpl extends MapAccountNameWithScheme {
    @Override
    protected FieldWithMetaString doEvaluate(String accountName, String scheme) {
        return createStringWithMetaScheme(accountName, scheme).build();
    }

}
