package fpml.mapping.functions;

import cdm.observable.asset.SettlementRateOption;
import cdm.observable.asset.SettlementRateOption.SettlementRateOptionBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapSettlementRateOption.MapSettlementRateOptionDefault.class)
public abstract class MapSettlementRateOption implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPriceSourceDisruption mapPriceSourceDisruption;
	@Inject protected MapSettlementRateOptionWithScheme mapSettlementRateOptionWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return settlementRateOption 
	*/
	public SettlementRateOption evaluate(DataDocument fpmlDataDocument) {
		SettlementRateOption.SettlementRateOptionBuilder settlementRateOptionBuilder = doEvaluate(fpmlDataDocument);
		
		final SettlementRateOption settlementRateOption;
		if (settlementRateOptionBuilder == null) {
			settlementRateOption = null;
		} else {
			settlementRateOption = settlementRateOptionBuilder.build();
			objectValidator.validate(SettlementRateOption.class, settlementRateOption);
		}
		
		return settlementRateOption;
	}

	protected abstract SettlementRateOption.SettlementRateOptionBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapSettlementRateOptionDefault extends MapSettlementRateOption {
		@Override
		protected SettlementRateOption.SettlementRateOptionBuilder doEvaluate(DataDocument fpmlDataDocument) {
			SettlementRateOption.SettlementRateOptionBuilder settlementRateOption = SettlementRateOption.builder();
			return assignOutput(settlementRateOption, fpmlDataDocument);
		}
		
		protected SettlementRateOption.SettlementRateOptionBuilder assignOutput(SettlementRateOption.SettlementRateOptionBuilder settlementRateOption, DataDocument fpmlDataDocument) {
			settlementRateOption = toBuilder(SettlementRateOption.builder()
				.setSettlementRateOptionValue(mapSettlementRateOptionWithScheme.evaluate(fpmlDataDocument))
				.setPriceSourceDisruption(mapPriceSourceDisruption.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(settlementRateOption)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
