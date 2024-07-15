package fpml.serialisation;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.regnosys.rosetta.common.serialisation.RosettaObjectMapperCreator;
import fpml.minparty.Party;
import fpml.minparty.PartyId;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class FlattenedFpmlPartySerialisationTest {

    @Test
    void testMinimalFpmlPartySerialisation() throws IOException {
        ObjectMapper objectMapper = createObjectMapper("fpml.minparty");

        File file = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("fpml-xml/minimal-party.xml")).getFile());
        String xml = stripDataDocument(FileUtils.readFileToString(file, "UTF-8"));

        Party party = objectMapper.readValue(xml, Party.class);

        assertThat(party.getId(), equalTo("party1"));
        PartyId partyId = party.getPartyId().get(0);
        assertThat(partyId.getValue(), equalTo("549300VBWWV6BYQOWM67"));
        assertThat(partyId.getPartyIdScheme(), equalTo("http://www.fpml.org/coding-scheme/external/iso17442"));
        assertThat(party.getPartyName().getValue(), equalTo("PARTYA"));
    }

    private String stripDataDocument(String xml) {
        return xml.replaceAll("(?s)<dataDocument.+?>(.*)</dataDocument>", "$1");
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
                """.formatted(packageName, packageName, packageName, packageName).getBytes()));
        return rosettaObjectMapperCreator.create();
    }
}
