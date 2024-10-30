package fpml.mapping.functions;

import cdm.product.asset.GeneralTerms;
import cdm.product.asset.GeneralTerms.GeneralTermsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapGeneralTerms.MapGeneralTermsDefault.class)
public abstract class MapGeneralTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdditionalTermWithSchemeList mapAdditionalTermWithSchemeList;
	@Inject protected MapBasketReferenceInformation mapBasketReferenceInformation;
	@Inject protected MapCreditIndex mapCreditIndex;
	@Inject protected MapReferenceInformation mapReferenceInformation;

	/**
	* @param fpmlDataDocument 
	* @return generalTerms 
	*/
	public GeneralTerms evaluate(DataDocument fpmlDataDocument) {
		GeneralTerms.GeneralTermsBuilder generalTermsBuilder = doEvaluate(fpmlDataDocument);
		
		final GeneralTerms generalTerms;
		if (generalTermsBuilder == null) {
			generalTerms = null;
		} else {
			generalTerms = generalTermsBuilder.build();
			objectValidator.validate(GeneralTerms.class, generalTerms);
		}
		
		return generalTerms;
	}

	protected abstract GeneralTerms.GeneralTermsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapGeneralTermsDefault extends MapGeneralTerms {
		@Override
		protected GeneralTerms.GeneralTermsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			GeneralTerms.GeneralTermsBuilder generalTerms = GeneralTerms.builder();
			return assignOutput(generalTerms, fpmlDataDocument);
		}
		
		protected GeneralTerms.GeneralTermsBuilder assignOutput(GeneralTerms.GeneralTermsBuilder generalTerms, DataDocument fpmlDataDocument) {
			generalTerms = toBuilder(GeneralTerms.builder()
				.setReferenceInformation(mapReferenceInformation.evaluate(fpmlDataDocument))
				.setIndexReferenceInformation(mapCreditIndex.evaluate(fpmlDataDocument))
				.setBasketReferenceInformation(mapBasketReferenceInformation.evaluate(fpmlDataDocument))
				.setAdditionalTermValue(mapAdditionalTermWithSchemeList.evaluate(fpmlDataDocument))
				.setSubstitution(null)
				.setModifiedEquityDelivery(null)
				.build());
			
			return Optional.ofNullable(generalTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
