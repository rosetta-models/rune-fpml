package fpml.mapping.functions;

import cdm.event.common.CollateralBalance;
import cdm.event.common.CollateralBalance.CollateralBalanceBuilder;
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


@ImplementedBy(MapCollateralBalanceList.MapCollateralBalanceListDefault.class)
public abstract class MapCollateralBalanceList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapMoney mapMoney;
	@Inject protected MapPartyReferencePayerReceiver mapPartyReferencePayerReceiver;

	/**
	* @param fpmlDataDocument 
	* @return collateralBalanceList 
	*/
	public List<? extends CollateralBalance> evaluate(DataDocument fpmlDataDocument) {
		List<CollateralBalance.CollateralBalanceBuilder> collateralBalanceListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends CollateralBalance> collateralBalanceList;
		if (collateralBalanceListBuilder == null) {
			collateralBalanceList = null;
		} else {
			collateralBalanceList = collateralBalanceListBuilder.stream().map(CollateralBalance::build).collect(Collectors.toList());
			objectValidator.validate(CollateralBalance.class, collateralBalanceList);
		}
		
		return collateralBalanceList;
	}

	protected abstract List<CollateralBalance.CollateralBalanceBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCollateralBalanceListDefault extends MapCollateralBalanceList {
		@Override
		protected List<CollateralBalance.CollateralBalanceBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<CollateralBalance.CollateralBalanceBuilder> collateralBalanceList = new ArrayList<>();
			return assignOutput(collateralBalanceList, fpmlDataDocument);
		}
		
		protected List<CollateralBalance.CollateralBalanceBuilder> assignOutput(List<CollateralBalance.CollateralBalanceBuilder> collateralBalanceList, DataDocument fpmlDataDocument) {
			collateralBalanceList.addAll(toBuilder(MapperC.<CollateralBalance>of(MapperS.of(CollateralBalance.builder()
				.setCollateralBalanceStatus(null)
				.setHaircutIndicator(null)
				.setAmountBaseCurrency(mapMoney.evaluate(fpmlDataDocument))
				.setPayerReceiver(mapPartyReferencePayerReceiver.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(collateralBalanceList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
