package com.regnosys.fpml.ingest.types.functions;

import cdm.base.staticdata.party.Party;
import fpml.ingest.types.functions.EnrichPartyWithExternalKey;

import java.util.Optional;

public class EnrichPartyWithExternalKeyImpl extends EnrichPartyWithExternalKey {
    @Override
    protected Party.PartyBuilder doEvaluate(Party party, String externalKey) {
        Party.PartyBuilder builder = party.toBuilder();
        Optional.ofNullable(externalKey)
                .ifPresent(builder.getOrCreateMeta()::setExternalKey);
        return builder;
    }
}
