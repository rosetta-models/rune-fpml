package fpml.mapping.functions;

import cdm.base.staticdata.party.ReferenceBanks;
import cdm.base.staticdata.party.ReferenceBanks.ReferenceBanksBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapReferenceBanks.MapReferenceBanksDefault.class)
public abstract class MapReferenceBanks implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapReferenceBankList mapReferenceBankList;

	/**
	* @param fpmlDataDocument 
	* @return referenceBanks 
	*/
	public ReferenceBanks evaluate(DataDocument fpmlDataDocument) {
		ReferenceBanks.ReferenceBanksBuilder referenceBanksBuilder = doEvaluate(fpmlDataDocument);
		
		final ReferenceBanks referenceBanks;
		if (referenceBanksBuilder == null) {
			referenceBanks = null;
		} else {
			referenceBanks = referenceBanksBuilder.build();
			objectValidator.validate(ReferenceBanks.class, referenceBanks);
		}
		
		return referenceBanks;
	}

	protected abstract ReferenceBanks.ReferenceBanksBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapReferenceBanksDefault extends MapReferenceBanks {
		@Override
		protected ReferenceBanks.ReferenceBanksBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ReferenceBanks.ReferenceBanksBuilder referenceBanks = ReferenceBanks.builder();
			return assignOutput(referenceBanks, fpmlDataDocument);
		}
		
		protected ReferenceBanks.ReferenceBanksBuilder assignOutput(ReferenceBanks.ReferenceBanksBuilder referenceBanks, DataDocument fpmlDataDocument) {
			referenceBanks = toBuilder(ReferenceBanks.builder()
				.setReferenceBank(new ArrayList(mapReferenceBankList.evaluate(fpmlDataDocument)))
				.build());
			
			return Optional.ofNullable(referenceBanks)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
