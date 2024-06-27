package fpml.confirmation.v5.group;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public abstract class PartyMixin {
    @JsonUnwrapped
    abstract PartyModel getPartyModel();

}
