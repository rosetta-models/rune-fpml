package com.regnosys.runefpml;

import com.google.common.collect.ImmutableMap;
import fpml.confirmation.*;

public class RuneFpmlModelConfig {

    public static String SCHEMA_PATH = "schemas/fpml-5-13/confirmation/fpml-main-5-13.xsd";
    public static final String XML_CONFIG_PATH = "xml-config/confirmation-v5_13-rosetta-xml-config.json";

    public static final ImmutableMap<Class<?>, String> TYPE_TO_SCHEMA_MAP =
            ImmutableMap.<Class<?>, String>builder()
                    .put(Document.class, SCHEMA_PATH)
                    .put(DataDocument.class, SCHEMA_PATH)
                    .put(ClearingConfirmed.class, SCHEMA_PATH)
                    .put(ExecutionAdvice.class, SCHEMA_PATH)
                    .put(ExecutionAdviceRetracted.class, SCHEMA_PATH)
                    .put(ExecutionNotification.class, SCHEMA_PATH)
                    .put(RequestClearing.class, SCHEMA_PATH)
                    .put(TradeChangeAdvice.class, SCHEMA_PATH)
                    .build();

    public static final ImmutableMap<Class<?>, String> TYPE_TO_XML_CONFIG_MAP =
            ImmutableMap.<Class<?>, String>builder()
                    .put(Document.class, SCHEMA_PATH)
                    .put(DataDocument.class, XML_CONFIG_PATH)
                    .put(ClearingConfirmed.class, XML_CONFIG_PATH)
                    .put(ExecutionAdvice.class, XML_CONFIG_PATH)
                    .put(ExecutionAdviceRetracted.class, XML_CONFIG_PATH)
                    .put(ExecutionNotification.class, XML_CONFIG_PATH)
                    .put(RequestClearing.class, XML_CONFIG_PATH)
                    .put(TradeChangeAdvice.class, XML_CONFIG_PATH)
                    .build();
}
