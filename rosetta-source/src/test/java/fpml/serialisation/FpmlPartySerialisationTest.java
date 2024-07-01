package fpml.serialisation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.regnosys.rosetta.common.serialisation.RosettaObjectMapperCreator;
import com.rosetta.model.lib.RosettaModelObject;
import fpml.confirmation.v5.group.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class FpmlPartySerialisationTest {

    @Test
    public void testSerialisationNoGroup() throws IOException {
        ObjectMapper objectMapper = createObjectMapper("fpml.confirmation.v5.nogroup");

        String xml = """
                <party id="party1">
                  <partyId partyIdScheme="http://www.fpml.org/coding-scheme/external/iso17442">54930084UKLVMY22DS16</partyId>
                  <partyName>Party A</partyName>
                </party>
                """;

        RosettaModelObject deserialised = objectMapper.readValue(xml, fpml.confirmation.v5.nogroup.Party.class);
        String serialised = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(deserialised);
        assertThat(serialised, equalTo(xml));
    }

    // No need to get this working in mixins
    @Disabled
    @Test
    public void testSerialisationWithGroup() throws IOException {
        ObjectMapper objectMapper = createObjectMapper("fpml.confirmation.v5.group")
                .addMixIn(fpml.confirmation.v5.group.Party.PartyImpl.class, PartyMixin.class)
                .addMixIn(fpml.confirmation.v5.group.Party.PartyBuilderImpl.class, PartyBuilderMixin.class)
                .addMixIn(fpml.confirmation.v5.group.PartyModel.PartyModelBuilderImpl.class, PartyModelBuilderMixin.class);

        String xml = """
                <party id="party1">
                  <partyId partyIdScheme="http://www.fpml.org/coding-scheme/external/iso17442">54930084UKLVMY22DS16</partyId>
                  <partyName>Party A</partyName>
                </party>
                """;

        RosettaModelObject deserialised = objectMapper.readValue(xml, fpml.confirmation.v5.group.Party.class);
        String serialised = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(deserialised);
        assertThat(serialised, equalTo(xml));
    }

    @Test
    public void testSerialisationWithGroupStaticJava() throws IOException {
        ObjectMapper objectMapper = createObjectMapper("fpml.confirmation.v5.staticgroup");

        String xml = """
                <party id="party1">
                  <partyId partyIdScheme="http://www.fpml.org/coding-scheme/external/iso17442">54930084UKLVMY22DS16</partyId>
                  <partyName>Party A</partyName>
                </party>
                """;

        RosettaModelObject deserialised = objectMapper.readValue(xml, fpml.confirmation.v5.staticgroup.Party.class);
        String serialised = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(deserialised);
        assertThat(serialised, equalTo(xml));
    }

    private static ObjectMapper createObjectMapper(String packageName) throws IOException {
        RosettaObjectMapperCreator rosettaObjectMapperCreator = RosettaObjectMapperCreator.forXML(new ByteArrayInputStream("""
      {
        "%s.Party": {
          "xmlRootElementName" : "party",
          "attributes": {
            "id": {
              "xmlName": "id",
              "xmlRepresentation": "ATTRIBUTE"
            }
          }
        },
        "%s.PartyId": {
          "attributes": {
            "value": {
              "xmlRepresentation": "VALUE"
            },
            "partyIdScheme": {
              "xmlName": "partyIdScheme",
              "xmlRepresentation": "ATTRIBUTE"
            }
          }
        },
        "%s.PartyName": {
          "attributes": {
            "value": {
              "xmlRepresentation": "VALUE"
            },
            "partyNameScheme": {
              "xmlName": "partyNameScheme",
              "xmlRepresentation": "ATTRIBUTE"
            }
          }
        }
      }
      """.formatted(packageName, packageName, packageName).getBytes()));
        return rosettaObjectMapperCreator.create();
    }

}
