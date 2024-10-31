package com.regnosys.fpml.ingest.typesfixed.functions;

import com.rosetta.model.metafields.FieldWithMetaString;
import fpml.ingest.typesfixed.functions.MapIdentifierWithScheme;

import java.util.Optional;

public class MapIdentifierWithSchemeImpl extends MapIdentifierWithScheme {
    @Override
    protected FieldWithMetaString doEvaluate(String identifier, String scheme) {
        FieldWithMetaString.FieldWithMetaStringBuilder builder = FieldWithMetaString.builder();
        Optional.ofNullable(identifier).ifPresent(builder::setValue);
        Optional.ofNullable(scheme).ifPresent(builder.getOrCreateMeta()::setScheme);
        return builder.build();
    }
}
