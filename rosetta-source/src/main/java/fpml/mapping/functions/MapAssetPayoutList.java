package fpml.mapping.functions;

import cdm.product.template.AssetPayout;
import cdm.product.template.AssetPayout.AssetPayoutBuilder;
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


@ImplementedBy(MapAssetPayoutList.MapAssetPayoutListDefault.class)
public abstract class MapAssetPayoutList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAsset mapAsset;
	@Inject protected MapAssetLegList mapAssetLegList;
	@Inject protected MapDividendTerms mapDividendTerms;
	@Inject protected MapMoney mapMoney;
	@Inject protected MapPayerReceiver mapPayerReceiver;
	@Inject protected MapPrincipalPayments mapPrincipalPayments;
	@Inject protected MapResolvablePriceQuantity mapResolvablePriceQuantity;
	@Inject protected MapSettlementTerms mapSettlementTerms;

	/**
	* @param fpmlDataDocument 
	* @return assetPayoutList 
	*/
	public List<? extends AssetPayout> evaluate(DataDocument fpmlDataDocument) {
		List<AssetPayout.AssetPayoutBuilder> assetPayoutListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends AssetPayout> assetPayoutList;
		if (assetPayoutListBuilder == null) {
			assetPayoutList = null;
		} else {
			assetPayoutList = assetPayoutListBuilder.stream().map(AssetPayout::build).collect(Collectors.toList());
			objectValidator.validate(AssetPayout.class, assetPayoutList);
		}
		
		return assetPayoutList;
	}

	protected abstract List<AssetPayout.AssetPayoutBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAssetPayoutListDefault extends MapAssetPayoutList {
		@Override
		protected List<AssetPayout.AssetPayoutBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<AssetPayout.AssetPayoutBuilder> assetPayoutList = new ArrayList<>();
			return assignOutput(assetPayoutList, fpmlDataDocument);
		}
		
		protected List<AssetPayout.AssetPayoutBuilder> assignOutput(List<AssetPayout.AssetPayoutBuilder> assetPayoutList, DataDocument fpmlDataDocument) {
			assetPayoutList.addAll(toBuilder(MapperC.<AssetPayout>of(MapperS.of(AssetPayout.builder()
				.setPayerReceiver(mapPayerReceiver.evaluate(fpmlDataDocument))
				.setPriceQuantity(mapResolvablePriceQuantity.evaluate(fpmlDataDocument))
				.setPrincipalPayment(mapPrincipalPayments.evaluate(fpmlDataDocument))
				.setSettlementTerms(mapSettlementTerms.evaluate(fpmlDataDocument))
				.setAssetLeg(new ArrayList(mapAssetLegList.evaluate(fpmlDataDocument)))
				.setUnderlier(mapAsset.evaluate(fpmlDataDocument))
				.setMinimumFee(mapMoney.evaluate(fpmlDataDocument))
				.setDividendTerms(mapDividendTerms.evaluate(fpmlDataDocument))
				.setRepoType(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(assetPayoutList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
