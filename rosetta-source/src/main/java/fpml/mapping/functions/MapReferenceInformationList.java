package fpml.mapping.functions;

import cdm.product.asset.ReferenceInformation;
import cdm.product.asset.ReferenceInformation.ReferenceInformationBuilder;
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


@ImplementedBy(MapReferenceInformationList.MapReferenceInformationListDefault.class)
public abstract class MapReferenceInformationList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapLegalEntity mapLegalEntity;
	@Inject protected MapPrice mapPrice;
	@Inject protected MapReferenceObligationList mapReferenceObligationList;

	/**
	* @param fpmlDataDocument 
	* @return referenceInformationList 
	*/
	public List<? extends ReferenceInformation> evaluate(DataDocument fpmlDataDocument) {
		List<ReferenceInformation.ReferenceInformationBuilder> referenceInformationListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends ReferenceInformation> referenceInformationList;
		if (referenceInformationListBuilder == null) {
			referenceInformationList = null;
		} else {
			referenceInformationList = referenceInformationListBuilder.stream().map(ReferenceInformation::build).collect(Collectors.toList());
			objectValidator.validate(ReferenceInformation.class, referenceInformationList);
		}
		
		return referenceInformationList;
	}

	protected abstract List<ReferenceInformation.ReferenceInformationBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapReferenceInformationListDefault extends MapReferenceInformationList {
		@Override
		protected List<ReferenceInformation.ReferenceInformationBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<ReferenceInformation.ReferenceInformationBuilder> referenceInformationList = new ArrayList<>();
			return assignOutput(referenceInformationList, fpmlDataDocument);
		}
		
		protected List<ReferenceInformation.ReferenceInformationBuilder> assignOutput(List<ReferenceInformation.ReferenceInformationBuilder> referenceInformationList, DataDocument fpmlDataDocument) {
			referenceInformationList.addAll(toBuilder(MapperC.<ReferenceInformation>of(MapperS.of(ReferenceInformation.builder()
				.setReferenceEntity(mapLegalEntity.evaluate(fpmlDataDocument))
				.setReferenceObligation(new ArrayList(mapReferenceObligationList.evaluate(fpmlDataDocument)))
				.setNoReferenceObligation(null)
				.setUnknownReferenceObligation(null)
				.setAllGuarantees(null)
				.setReferencePrice(mapPrice.evaluate(fpmlDataDocument))
				.setReferencePolicy(null)
				.setSecuredList(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(referenceInformationList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
