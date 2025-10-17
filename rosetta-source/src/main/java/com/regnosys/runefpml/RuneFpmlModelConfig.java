package com.regnosys.runefpml;

import com.google.common.collect.ImmutableMap;
import fpml.consolidated.doc.Document;

public class RuneFpmlModelConfig {

    public static String FPML_CONFIRMATION_SCHEMA_PATH = "schemas/fpml-5-13-7-rec-1/confirmation/fpml-main-5-13.xsd";
    public static String FPML_RECORDKEEPING_SCHEMA_PATH = "schemas/fpml-5-13-7-rec-1/confirmation/fpml-main-5-13.xsd";
    public static final String FPML_CONFIRMATION_XML_CONFIG_PATH = "xml-config/fpml-5-13-confirmation-xml-config.json";
    public static final String FPML_RECORDKEEPING_XML_CONFIG_PATH = "xml-config/fpml-5-13-recordkeeping-xml-config.json";
    public static final ImmutableMap<Class<?>, String> TYPE_TO_SCHEMA_MAP =
            ImmutableMap.<Class<?>, String>builder()
                    .put(Document.class, FPML_CONFIRMATION_SCHEMA_PATH)
                    .build();

    public static final ImmutableMap<Class<?>, String> TYPE_TO_XML_CONFIG_MAP =
            ImmutableMap.<Class<?>, String>builder()
                    .put(Document.class, FPML_CONFIRMATION_XML_CONFIG_PATH)
                    .build();
}
