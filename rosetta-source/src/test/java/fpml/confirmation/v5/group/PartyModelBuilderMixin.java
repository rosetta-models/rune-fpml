package fpml.confirmation.v5.group;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.rosetta.model.lib.annotations.RosettaAttribute;

import java.util.List;

public abstract class PartyModelBuilderMixin {
    @RosettaAttribute("partyId")
    @JsonSetter("partyId")
    abstract PartyModel.PartyModelBuilder addPartyId(PartyId partyId);

    @RosettaAttribute("xxxxxxx")
    @JsonSetter("xxxxxx")
    abstract PartyModel.PartyModelBuilder setPartyId(List<? extends PartyId> partyIds);

}
