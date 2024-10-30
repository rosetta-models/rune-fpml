package fpml.mapping.functions;

import cdm.base.staticdata.asset.common.ListedDerivative;
import cdm.base.staticdata.asset.common.ListedDerivative.ListedDerivativeBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapListedDerivative.MapListedDerivativeDefault.class)
public abstract class MapListedDerivative implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetIdentifierList mapAssetIdentifierList;
	@Inject protected MapLegalEntity mapLegalEntity;
	@Inject protected MapLegalEntityList mapLegalEntityList;
	@Inject protected MapTaxonomyList mapTaxonomyList;

	/**
	* @param fpmlDataDocument 
	* @return listedDerivative 
	*/
	public ListedDerivative evaluate(DataDocument fpmlDataDocument) {
		ListedDerivative.ListedDerivativeBuilder listedDerivativeBuilder = doEvaluate(fpmlDataDocument);
		
		final ListedDerivative listedDerivative;
		if (listedDerivativeBuilder == null) {
			listedDerivative = null;
		} else {
			listedDerivative = listedDerivativeBuilder.build();
			objectValidator.validate(ListedDerivative.class, listedDerivative);
		}
		
		return listedDerivative;
	}

	protected abstract ListedDerivative.ListedDerivativeBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapListedDerivativeDefault extends MapListedDerivative {
		@Override
		protected ListedDerivative.ListedDerivativeBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ListedDerivative.ListedDerivativeBuilder listedDerivative = ListedDerivative.builder();
			return assignOutput(listedDerivative, fpmlDataDocument);
		}
		
		protected ListedDerivative.ListedDerivativeBuilder assignOutput(ListedDerivative.ListedDerivativeBuilder listedDerivative, DataDocument fpmlDataDocument) {
			listedDerivative = toBuilder(ListedDerivative.builder()
				.setIdentifier(new ArrayList(mapAssetIdentifierList.evaluate(fpmlDataDocument)))
				.setTaxonomy(new ArrayList(mapTaxonomyList.evaluate(fpmlDataDocument)))
				.setIsExchangeListed(null)
				.setExchange(mapLegalEntity.evaluate(fpmlDataDocument))
				.setRelatedExchange(new ArrayList(mapLegalEntityList.evaluate(fpmlDataDocument)))
				.setDeliveryTerm(null)
				.setOptionType(null)
				.setStrike(null)
				.build());
			
			return Optional.ofNullable(listedDerivative)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
