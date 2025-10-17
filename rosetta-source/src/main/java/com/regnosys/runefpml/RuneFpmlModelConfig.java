package com.regnosys.runefpml;

import com.google.common.collect.ImmutableMap;
import fpml.consolidated.doc.Document;

public class RuneFpmlModelConfig {

    public static String SCHEMA_PATH = "schemas/fpml-5-13/confirmation/fpml-main-5-13.xsd";
    public static final String XML_CONFIG_PATH = "xml-config/fpml-5-13-confirmation-xml-config.json";

    public static final ImmutableMap<Class<?>, String> TYPE_TO_SCHEMA_MAP =
            ImmutableMap.<Class<?>, String>builder()
                    .put(Document.class, SCHEMA_PATH)
                    .build();

    public static final ImmutableMap<Class<?>, String> TYPE_TO_XML_CONFIG_MAP =
            ImmutableMap.<Class<?>, String>builder()
                    .put(Document.class, XML_CONFIG_PATH)
                    .build();
}
