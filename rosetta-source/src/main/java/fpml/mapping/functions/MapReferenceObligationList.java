package fpml.mapping.functions;

import cdm.product.asset.ReferenceObligation;
import cdm.product.asset.ReferenceObligation.ReferenceObligationBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapReferenceObligationList.MapReferenceObligationListDefault.class)
public abstract class MapReferenceObligationList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapLegalEntity mapLegalEntity;
	@Inject protected MapLoan mapLoan;
	@Inject protected MapSecurity mapSecurity;

	/**
	* @param fpmlDataDocument 
	* @return referenceObligationList 
	*/
	public List<? extends ReferenceObligation> evaluate(DataDocument fpmlDataDocument) {
		List<ReferenceObligation.ReferenceObligationBuilder> referenceObligationListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends ReferenceObligation> referenceObligationList;
		if (referenceObligationListBuilder == null) {
			referenceObligationList = null;
		} else {
			referenceObligationList = referenceObligationListBuilder.stream().map(ReferenceObligation::build).collect(Collectors.toList());
			objectValidator.validate(ReferenceObligation.class, referenceObligationList);
		}
		
		return referenceObligationList;
	}

	protected abstract List<ReferenceObligation.ReferenceObligationBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapReferenceObligationListDefault extends MapReferenceObligationList {
		@Override
		protected List<ReferenceObligation.ReferenceObligationBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<ReferenceObligation.ReferenceObligationBuilder> referenceObligationList = new ArrayList<>();
			return assignOutput(referenceObligationList, fpmlDataDocument);
		}
		
		protected List<ReferenceObligation.ReferenceObligationBuilder> assignOutput(List<ReferenceObligation.ReferenceObligationBuilder> referenceObligationList, DataDocument fpmlDataDocument) {
			referenceObligationList.addAll(toBuilder(MapperC.<ReferenceObligation>of(MapperS.of(ReferenceObligation.builder()
				.setSecurity(mapSecurity.evaluate(fpmlDataDocument))
				.setLoan(mapLoan.evaluate(fpmlDataDocument))
				.setPrimaryObligor(mapLegalEntity.evaluate(fpmlDataDocument))
				.setPrimaryObligorReferenceValue(mapLegalEntity.evaluate(fpmlDataDocument))
				.setGuarantor(mapLegalEntity.evaluate(fpmlDataDocument))
				.setGuarantorReference(null)
				.setStandardReferenceObligation(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(referenceObligationList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
