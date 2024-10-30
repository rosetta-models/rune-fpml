package fpml.mapping.functions;

import cdm.product.asset.BasketReferenceInformation;
import cdm.product.asset.BasketReferenceInformation.BasketReferenceInformationBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapBasketReferenceInformation.MapBasketReferenceInformationDefault.class)
public abstract class MapBasketReferenceInformation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBasketIdWithSchemeList mapBasketIdWithSchemeList;
	@Inject protected MapBasketNameWithScheme mapBasketNameWithScheme;
	@Inject protected MapReferencePool mapReferencePool;
	@Inject protected MapTranche mapTranche;

	/**
	* @param fpmlDataDocument 
	* @return basketReferenceInformation 
	*/
	public BasketReferenceInformation evaluate(DataDocument fpmlDataDocument) {
		BasketReferenceInformation.BasketReferenceInformationBuilder basketReferenceInformationBuilder = doEvaluate(fpmlDataDocument);
		
		final BasketReferenceInformation basketReferenceInformation;
		if (basketReferenceInformationBuilder == null) {
			basketReferenceInformation = null;
		} else {
			basketReferenceInformation = basketReferenceInformationBuilder.build();
			objectValidator.validate(BasketReferenceInformation.class, basketReferenceInformation);
		}
		
		return basketReferenceInformation;
	}

	protected abstract BasketReferenceInformation.BasketReferenceInformationBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapBasketReferenceInformationDefault extends MapBasketReferenceInformation {
		@Override
		protected BasketReferenceInformation.BasketReferenceInformationBuilder doEvaluate(DataDocument fpmlDataDocument) {
			BasketReferenceInformation.BasketReferenceInformationBuilder basketReferenceInformation = BasketReferenceInformation.builder();
			return assignOutput(basketReferenceInformation, fpmlDataDocument);
		}
		
		protected BasketReferenceInformation.BasketReferenceInformationBuilder assignOutput(BasketReferenceInformation.BasketReferenceInformationBuilder basketReferenceInformation, DataDocument fpmlDataDocument) {
			basketReferenceInformation = toBuilder(BasketReferenceInformation.builder()
				.setBasketNameValue(mapBasketNameWithScheme.evaluate(fpmlDataDocument))
				.setBasketIdValue(mapBasketIdWithSchemeList.evaluate(fpmlDataDocument))
				.setReferencePool(mapReferencePool.evaluate(fpmlDataDocument))
				.setNthToDefault(null)
				.setMthToDefault(null)
				.setTranche(mapTranche.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(basketReferenceInformation)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
