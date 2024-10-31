package com.regnosys.fpml.ingest.typesfixed.functions;

import com.rosetta.model.metafields.FieldWithMetaString;
import fpml.ingest.typesfixed.functions.MapAccountNumberWithScheme;

import java.util.Optional;

public class MapAccountNumberWithSchemeImpl extends MapAccountNumberWithScheme {
    @Override
    protected FieldWithMetaString doEvaluate(String accountNumber, String scheme) {
        FieldWithMetaString.FieldWithMetaStringBuilder builder = FieldWithMetaString.builder();
        Optional.ofNullable(accountNumber).ifPresent(builder::setValue);
        Optional.ofNullable(scheme).ifPresent(builder.getOrCreateMeta()::setScheme);
        return builder.build();
    }
}
