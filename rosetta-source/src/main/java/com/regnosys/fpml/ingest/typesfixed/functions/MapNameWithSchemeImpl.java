package com.regnosys.fpml.ingest.typesfixed.functions;

import com.rosetta.model.metafields.FieldWithMetaString;
import fpml.ingest.typesfixed.functions.MapNameWithScheme;

import java.util.Optional;

public class MapNameWithSchemeImpl extends MapNameWithScheme {
    @Override
    protected FieldWithMetaString doEvaluate(String name, String scheme) {
        FieldWithMetaString.FieldWithMetaStringBuilder builder = FieldWithMetaString.builder();
        Optional.ofNullable(name).ifPresent(builder::setValue);
        Optional.ofNullable(scheme).ifPresent(builder.getOrCreateMeta()::setScheme);
        return builder.build();
    }
}
