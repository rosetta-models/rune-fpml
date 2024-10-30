package fpml.mapping.functions;

import cdm.base.staticdata.asset.common.Cash;
import cdm.base.staticdata.asset.common.Cash.CashBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCash.MapCashDefault.class)
public abstract class MapCash implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetIdentifierList mapAssetIdentifierList;
	@Inject protected MapLegalEntity mapLegalEntity;
	@Inject protected MapLegalEntityList mapLegalEntityList;
	@Inject protected MapTaxonomyList mapTaxonomyList;

	/**
	* @param fpmlDataDocument 
	* @return cash 
	*/
	public Cash evaluate(DataDocument fpmlDataDocument) {
		Cash.CashBuilder cashBuilder = doEvaluate(fpmlDataDocument);
		
		final Cash cash;
		if (cashBuilder == null) {
			cash = null;
		} else {
			cash = cashBuilder.build();
			objectValidator.validate(Cash.class, cash);
		}
		
		return cash;
	}

	protected abstract Cash.CashBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCashDefault extends MapCash {
		@Override
		protected Cash.CashBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Cash.CashBuilder cash = Cash.builder();
			return assignOutput(cash, fpmlDataDocument);
		}
		
		protected Cash.CashBuilder assignOutput(Cash.CashBuilder cash, DataDocument fpmlDataDocument) {
			cash = toBuilder(Cash.builder()
				.setIdentifier(new ArrayList(mapAssetIdentifierList.evaluate(fpmlDataDocument)))
				.setTaxonomy(new ArrayList(mapTaxonomyList.evaluate(fpmlDataDocument)))
				.setIsExchangeListed(null)
				.setExchange(mapLegalEntity.evaluate(fpmlDataDocument))
				.setRelatedExchange(new ArrayList(mapLegalEntityList.evaluate(fpmlDataDocument)))
				.build());
			
			return Optional.ofNullable(cash)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
