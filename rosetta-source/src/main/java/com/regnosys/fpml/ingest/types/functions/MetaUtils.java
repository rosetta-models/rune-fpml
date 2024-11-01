package com.regnosys.fpml.ingest.types.functions;

import com.rosetta.model.metafields.FieldWithMetaString;

import java.util.Optional;

public class MetaUtils {
    public static FieldWithMetaString.FieldWithMetaStringBuilder createStringWithMetaScheme(String value, String scheme) {
        FieldWithMetaString.FieldWithMetaStringBuilder builder = FieldWithMetaString.builder();
        Optional.ofNullable(value).ifPresent(builder::setValue);
        Optional.ofNullable(scheme).ifPresent(builder.getOrCreateMeta()::setScheme);
        return builder;
    }
}
