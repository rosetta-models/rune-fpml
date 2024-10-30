package cdm.product.template.validation.datarule;

import cdm.product.asset.InterestRatePayout;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.EconomicTerms;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.Underlier;
import cdm.product.template.util.ProductDeepPathUtil;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 6.0.0-dev.76
 */
@RosettaDataRule("PayoutQuantity")
@ImplementedBy(PayoutQuantity.Default.class)
public interface PayoutQuantity extends Validator<Payout> {
	
	String NAME = "PayoutQuantity";
	String DEFINITION = "if optionPayout exists then optionPayout -> priceQuantity exists or optionPayout -> underlier -> Product ->> economicTerms -> payout -> interestRatePayout count = 2";
	
	ValidationResult<Payout> validate(RosettaPath path, Payout payout);
	
	class Default implements PayoutQuantity {
	
		@Inject protected ProductDeepPathUtil productDeepPathUtil;
		
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
				if (exists(MapperS.of(payout).<OptionPayout>mapC("getOptionPayout", _payout -> _payout.getOptionPayout())).getOrDefault(false)) {
					return exists(MapperS.of(payout).<OptionPayout>mapC("getOptionPayout", _payout -> _payout.getOptionPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", optionPayout -> optionPayout.getPriceQuantity())).or(areEqual(MapperS.of(MapperS.of(payout).<OptionPayout>mapC("getOptionPayout", _payout -> _payout.getOptionPayout()).<Underlier>map("getUnderlier", optionPayout -> optionPayout.getUnderlier()).<Product>map("getProduct", underlier -> underlier.getProduct()).<EconomicTerms>map("chooseEconomicTerms", product -> productDeepPathUtil.chooseEconomicTerms(product)).<Payout>map("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).resultCount()), MapperS.of(2), CardinalityOperator.All));
				}
				return ComparisonResult.successEmptyOperand("");
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PayoutQuantity {
	
		@Override
		public ValidationResult<Payout> validate(RosettaPath path, Payout payout) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Payout", path, DEFINITION);
		}
	}
}
