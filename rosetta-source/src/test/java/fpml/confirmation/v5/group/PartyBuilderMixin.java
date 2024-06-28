package fpml.confirmation.v5.group;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

public abstract class PartyBuilderMixin {
    @JsonUnwrapped
    abstract PartyModel.PartyModelBuilder getPartyModel();
    @JsonUnwrapped
    abstract Party.PartyBuilder setPartyModel(PartyModel partyModel);

}
