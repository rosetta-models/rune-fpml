package fpml.confirmation.v5.group;

import com.fasterxml.jackson.annotation.JsonSetter;

public abstract class PartyModelBuilderMixin {
    @JsonSetter(value = "partyId")
    abstract PartyModel.PartyModelBuilder addPartyId(PartyId partyId);
}
