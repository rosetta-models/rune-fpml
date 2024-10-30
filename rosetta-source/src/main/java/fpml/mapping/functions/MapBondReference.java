package fpml.mapping.functions;

import cdm.product.asset.BondReference;
import cdm.product.asset.BondReference.BondReferenceBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapBondReference.MapBondReferenceDefault.class)
public abstract class MapBondReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFixedRateSpecification mapFixedRateSpecification;
	@Inject protected MapSecurity mapSecurity;

	/**
	* @param fpmlDataDocument 
	* @return bondReference 
	*/
	public BondReference evaluate(DataDocument fpmlDataDocument) {
		BondReference.BondReferenceBuilder bondReferenceBuilder = doEvaluate(fpmlDataDocument);
		
		final BondReference bondReference;
		if (bondReferenceBuilder == null) {
			bondReference = null;
		} else {
			bondReference = bondReferenceBuilder.build();
			objectValidator.validate(BondReference.class, bondReference);
		}
		
		return bondReference;
	}

	protected abstract BondReference.BondReferenceBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapBondReferenceDefault extends MapBondReference {
		@Override
		protected BondReference.BondReferenceBuilder doEvaluate(DataDocument fpmlDataDocument) {
			BondReference.BondReferenceBuilder bondReference = BondReference.builder();
			return assignOutput(bondReference, fpmlDataDocument);
		}
		
		protected BondReference.BondReferenceBuilder assignOutput(BondReference.BondReferenceBuilder bondReference, DataDocument fpmlDataDocument) {
			bondReference = toBuilder(BondReference.builder()
				.setBond(mapSecurity.evaluate(fpmlDataDocument))
				.setConditionPrecedentBond(null)
				.setDiscrepancyClause(null)
				.setCouponRate(mapFixedRateSpecification.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(bondReference)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
