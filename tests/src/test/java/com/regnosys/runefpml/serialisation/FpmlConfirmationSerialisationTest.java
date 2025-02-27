package com.regnosys.runefpml.serialisation;

import fpml.confirmation.DataDocument;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;
import java.util.stream.Stream;

import static com.regnosys.runefpml.serialisation.SerialisationTestUtil.INPUT_ROOT_PATH;

public class FpmlConfirmationSerialisationTest {

    private static final String XSD_SCHEMA_NAME = "schemas/fpml-5-13/confirmation/fpml-main-5-13.xsd";
    private static final String EXPECTED_SCHEMA_LOCATION = "http://www.fpml.org/FpML-5/confirmation " + XSD_SCHEMA_NAME;
    private static final String XML_CONFIG_NAME = "xml-config/confirmation-v5_13-rosetta-xml-config.json";


    private static final Set<String> DISABLED_TESTS = Set.of(
            "fpml-5-10/products/credit/cds-index-tranche.xml", // works for other fpml versions
            "fpml-5-10/incomplete-products/commodity-derivatives/com-ex43-WTI-variance-swap.xml",
            "fpml-5-13/incomplete-products/commodity-derivatives/com-ex43-WTI-variance-swap.xml",
            "fpml-5-10/incomplete-products/equity-options/eqd-ex05-asian-long-form.xml",
            "fpml-5-13/incomplete-products/equity-options/eqd-ex05-asian-long-form.xml",
            "fpml-5-10/incomplete-products/equity-options/eqd-ex06-averaging-in-long-form.xml",
            "fpml-5-13/incomplete-products/equity-options/eqd-ex06-averaging-in-long-form.xml",
            "fpml-5-13/products/inflation-swaps/inflation-swap-ex06-zc.xml",
            "fpml-5-12/products/rates/ird-ex32-zero-coupon-swap-normal-rate.xml",
            "fpml-5-13/products/interest-rate-derivatives/ird-ex32-zero-coupon-swap-normal-rate.xml",
            "fpml-5-13/products/interest-rate-derivatives/ird-ex37-zero-coupon-swap-known-amount-schedule.xml",
            "fpml-5-10/incomplete-products/securities/sec-ex001-trade-execution-future.xml");

    private static SerialisationTestUtil<DataDocument> serialisationTestUtil;

    @BeforeAll
    static void setup() {
        serialisationTestUtil = new SerialisationTestUtil<>(
                DataDocument.class,
                XSD_SCHEMA_NAME,
                XML_CONFIG_NAME,
                EXPECTED_SCHEMA_LOCATION
        );
    }

    public static Stream<Arguments> xmlSampleFiles() {
        return SerialisationTestUtil.getXmlSampleFiles(INPUT_ROOT_PATH, DISABLED_TESTS);
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("xmlSampleFiles")
    public void testSerialisation(String name, Path samplePath) throws IOException {
        serialisationTestUtil.assertXmlRoundTrip(samplePath);
    }
}
