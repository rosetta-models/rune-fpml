package fpml.serialisation;

import org.junit.jupiter.api.Test;

public class FpmlPartySerialisationTest {

    @Test
    public void testSerialisation() {
        String xml = """
                <party id="party1">
                  <partyId partyIdScheme="http://www.fpml.org/coding-scheme/external/iso17442">54930084UKLVMY22DS16</partyId>
                  <partyName>Party A</partyName>
                </party>
                """;
    }

}
