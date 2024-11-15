package fpml;

import com.google.common.collect.ImmutableMap;
import fpml.confirmation.DataDocument;

public class FpmlModelConfig {

    public static String SCHEMA_PATH = "schemas/fpml-5-13/confirmation/fpml-main-5-13.xsd";
    public static final String XML_CONFIG_PATH = "xml-config/confirmation-v5_13-rosetta-xml-config.json";
    
    public static final ImmutableMap<Class<?>, String> TYPE_TO_SCHEMA_MAP = ImmutableMap.of(
           DataDocument.class, SCHEMA_PATH);


    public static final ImmutableMap<Class<?>, String> TYPE_TO_XML_CONFIG_MAP = ImmutableMap.of(
            DataDocument.class, XML_CONFIG_PATH);



}
