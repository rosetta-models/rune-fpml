package com.regnosys.fpml.ingest.typesfixed.functions;

import com.rosetta.model.metafields.FieldWithMetaString;
import fpml.ingest.typesfixed.functions.MapAccountNameWithScheme;

import java.util.Optional;

public class MapAccountNameWithSchemeImpl extends MapAccountNameWithScheme {
    @Override
    protected FieldWithMetaString doEvaluate(String accountName, String scheme) {
        FieldWithMetaString.FieldWithMetaStringBuilder builder = FieldWithMetaString.builder();
        Optional.ofNullable(accountName).ifPresent(builder::setValue);
        Optional.ofNullable(scheme).ifPresent(builder.getOrCreateMeta()::setScheme);
        return builder.build();
    }
}
