package fpml.mapping.functions;

import cdm.product.collateral.SubstitutionProvisions;
import cdm.product.collateral.SubstitutionProvisions.SubstitutionProvisionsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapSubstitutionProvisions.MapSubstitutionProvisionsDefault.class)
public abstract class MapSubstitutionProvisions implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPeriod mapPeriod;

	/**
	* @param fpmlDataDocument 
	* @return substitutionProvisions 
	*/
	public SubstitutionProvisions evaluate(DataDocument fpmlDataDocument) {
		SubstitutionProvisions.SubstitutionProvisionsBuilder substitutionProvisionsBuilder = doEvaluate(fpmlDataDocument);
		
		final SubstitutionProvisions substitutionProvisions;
		if (substitutionProvisionsBuilder == null) {
			substitutionProvisions = null;
		} else {
			substitutionProvisions = substitutionProvisionsBuilder.build();
			objectValidator.validate(SubstitutionProvisions.class, substitutionProvisions);
		}
		
		return substitutionProvisions;
	}

	protected abstract SubstitutionProvisions.SubstitutionProvisionsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapSubstitutionProvisionsDefault extends MapSubstitutionProvisions {
		@Override
		protected SubstitutionProvisions.SubstitutionProvisionsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			SubstitutionProvisions.SubstitutionProvisionsBuilder substitutionProvisions = SubstitutionProvisions.builder();
			return assignOutput(substitutionProvisions, fpmlDataDocument);
		}
		
		protected SubstitutionProvisions.SubstitutionProvisionsBuilder assignOutput(SubstitutionProvisions.SubstitutionProvisionsBuilder substitutionProvisions, DataDocument fpmlDataDocument) {
			substitutionProvisions = toBuilder(SubstitutionProvisions.builder()
				.setNumberOfSubstitutionsAllowed(null)
				.setNoticeDeadlinePeriod(mapPeriod.evaluate(fpmlDataDocument))
				.setNoticeDeadlineDateTime(null)
				.build());
			
			return Optional.ofNullable(substitutionProvisions)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
