package jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class JacksonTest {

    @Test
    public void test() throws Exception {
        ObjectMapper mapper = new XmlMapper();

        String xml = """
                <Person>
                  <name>John</name>
                  <age>30</age>
                  <houseNumber>1</houseNumber>
                  <street>Some Avenue</street>
                </Person>
                """;

        Person personDeserialised = mapper.readValue(xml, Person.class);
        String personSerialised = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(personDeserialised);
        assertThat(personSerialised, equalTo(xml));
    }
}
