package fpml.mapping.functions;

import cdm.product.template.AssetPayout;
import cdm.product.template.AssetPayout.AssetPayoutBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAssetPayout.MapAssetPayoutDefault.class)
public abstract class MapAssetPayout implements RosettaFunction {
	
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
	* @return assetPayout 
	*/
	public AssetPayout evaluate(DataDocument fpmlDataDocument) {
		AssetPayout.AssetPayoutBuilder assetPayoutBuilder = doEvaluate(fpmlDataDocument);
		
		final AssetPayout assetPayout;
		if (assetPayoutBuilder == null) {
			assetPayout = null;
		} else {
			assetPayout = assetPayoutBuilder.build();
			objectValidator.validate(AssetPayout.class, assetPayout);
		}
		
		return assetPayout;
	}

	protected abstract AssetPayout.AssetPayoutBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAssetPayoutDefault extends MapAssetPayout {
		@Override
		protected AssetPayout.AssetPayoutBuilder doEvaluate(DataDocument fpmlDataDocument) {
			AssetPayout.AssetPayoutBuilder assetPayout = AssetPayout.builder();
			return assignOutput(assetPayout, fpmlDataDocument);
		}
		
		protected AssetPayout.AssetPayoutBuilder assignOutput(AssetPayout.AssetPayoutBuilder assetPayout, DataDocument fpmlDataDocument) {
			assetPayout = toBuilder(AssetPayout.builder()
				.setPayerReceiver(mapPayerReceiver.evaluate(fpmlDataDocument))
				.setPriceQuantity(mapResolvablePriceQuantity.evaluate(fpmlDataDocument))
				.setPrincipalPayment(mapPrincipalPayments.evaluate(fpmlDataDocument))
				.setSettlementTerms(mapSettlementTerms.evaluate(fpmlDataDocument))
				.setAssetLeg(new ArrayList(mapAssetLegList.evaluate(fpmlDataDocument)))
				.setUnderlier(mapAsset.evaluate(fpmlDataDocument))
				.setMinimumFee(mapMoney.evaluate(fpmlDataDocument))
				.setDividendTerms(mapDividendTerms.evaluate(fpmlDataDocument))
				.setRepoType(null)
				.build());
			
			return Optional.ofNullable(assetPayout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
