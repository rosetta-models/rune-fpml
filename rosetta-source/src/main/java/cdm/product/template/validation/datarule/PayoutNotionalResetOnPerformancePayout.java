package cdm.product.template.validation.datarule;

import cdm.product.asset.CommodityPayout;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.common.settlement.Cashflow;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.AssetPayout;
import cdm.product.template.FixedPricePayout;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.SettlementPayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 6.0.0-dev.76
 */
@RosettaDataRule("PayoutNotionalResetOnPerformancePayout")
@ImplementedBy(PayoutNotionalResetOnPerformancePayout.Default.class)
public interface PayoutNotionalResetOnPerformancePayout extends Validator<Payout> {
	
	String NAME = "PayoutNotionalResetOnPerformancePayout";
	String DEFINITION = "creditDefaultPayout -> priceQuantity -> reset is absent and assetPayout -> priceQuantity -> reset is absent and commodityPayout -> priceQuantity -> reset is absent and fixedPricePayout -> priceQuantity -> reset is absent and settlementPayout -> priceQuantity -> reset is absent and optionPayout -> priceQuantity -> reset is absent and cashflow -> priceQuantity -> reset is absent";
	
	ValidationResult<Payout> validate(RosettaPath path, Payout payout);
	
	class Default implements PayoutNotionalResetOnPerformancePayout {
	
		@Override
		public ValidationResult<Payout> validate(RosettaPath path, Payout payout) {
			ComparisonResult result = executeDataRule(payout);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Payout", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "Payout", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(Payout payout) {
			try {
				return notExists(MapperS.of(payout).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", creditDefaultPayout -> creditDefaultPayout.getPriceQuantity()).<Boolean>map("getReset", resolvablePriceQuantity -> resolvablePriceQuantity.getReset())).and(notExists(MapperS.of(payout).<AssetPayout>mapC("getAssetPayout", _payout -> _payout.getAssetPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", assetPayout -> assetPayout.getPriceQuantity()).<Boolean>map("getReset", resolvablePriceQuantity -> resolvablePriceQuantity.getReset()))).and(notExists(MapperS.of(payout).<CommodityPayout>mapC("getCommodityPayout", _payout -> _payout.getCommodityPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", commodityPayout -> commodityPayout.getPriceQuantity()).<Boolean>map("getReset", resolvablePriceQuantity -> resolvablePriceQuantity.getReset()))).and(notExists(MapperS.of(payout).<FixedPricePayout>mapC("getFixedPricePayout", _payout -> _payout.getFixedPricePayout()).<ResolvablePriceQuantity>map("getPriceQuantity", fixedPricePayout -> fixedPricePayout.getPriceQuantity()).<Boolean>map("getReset", resolvablePriceQuantity -> resolvablePriceQuantity.getReset()))).and(notExists(MapperS.of(payout).<SettlementPayout>mapC("getSettlementPayout", _payout -> _payout.getSettlementPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<Boolean>map("getReset", resolvablePriceQuantity -> resolvablePriceQuantity.getReset()))).and(notExists(MapperS.of(payout).<OptionPayout>mapC("getOptionPayout", _payout -> _payout.getOptionPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", optionPayout -> optionPayout.getPriceQuantity()).<Boolean>map("getReset", resolvablePriceQuantity -> resolvablePriceQuantity.getReset()))).and(notExists(MapperS.of(payout).<Cashflow>mapC("getCashflow", _payout -> _payout.getCashflow()).<ResolvablePriceQuantity>map("getPriceQuantity", cashflow -> cashflow.getPriceQuantity()).<Boolean>map("getReset", resolvablePriceQuantity -> resolvablePriceQuantity.getReset())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PayoutNotionalResetOnPerformancePayout {
	
		@Override
		public ValidationResult<Payout> validate(RosettaPath path, Payout payout) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Payout", path, DEFINITION);
		}
	}
}
