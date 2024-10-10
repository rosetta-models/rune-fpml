package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BrokerEquityOption;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.EquityExerciseValuationSettlement;
import fpml.confirmation.EquityOptionTypeEnum;
import fpml.confirmation.EquityPremium;
import fpml.confirmation.EquityStrike;
import fpml.confirmation.FeatureModel;
import fpml.confirmation.Money;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.ProductModel;
import fpml.confirmation.StrategyFeature;
import fpml.confirmation.Underlyer;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BrokerEquityOptionValidator implements Validator<BrokerEquityOption> {

	private List<ComparisonResult> getComparisonResults(BrokerEquityOption o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerSellerModel", (BuyerSellerModel) o.getBuyerSellerModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("optionType", (EquityOptionTypeEnum) o.getOptionType() != null ? 1 : 0, 1, 1), 
				checkCardinality("equityEffectiveDate", (Date) o.getEquityEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyer", (Underlyer) o.getUnderlyer() != null ? 1 : 0, 1, 1), 
				checkCardinality("notional", (NonNegativeMoney) o.getNotional() != null ? 1 : 0, 0, 1), 
				checkCardinality("equityExercise", (EquityExerciseValuationSettlement) o.getEquityExercise() != null ? 1 : 0, 1, 1), 
				checkCardinality("featureModel", (FeatureModel) o.getFeatureModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("strategyFeature", (StrategyFeature) o.getStrategyFeature() != null ? 1 : 0, 0, 1), 
				checkCardinality("strike", (EquityStrike) o.getStrike() != null ? 1 : 0, 1, 1), 
				checkCardinality("spotPrice", (BigDecimal) o.getSpotPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("numberOfOptions", (BigDecimal) o.getNumberOfOptions() != null ? 1 : 0, 1, 1), 
				checkCardinality("equityPremium", (EquityPremium) o.getEquityPremium() != null ? 1 : 0, 1, 1), 
				checkCardinality("deltaCrossed", (Boolean) o.getDeltaCrossed() != null ? 1 : 0, 1, 1), 
				checkCardinality("brokerageFee", (Money) o.getBrokerageFee() != null ? 1 : 0, 1, 1), 
				checkCardinality("brokerNotes", (String) o.getBrokerNotes() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<BrokerEquityOption> validate(RosettaPath path, BrokerEquityOption o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("BrokerEquityOption", ValidationType.CARDINALITY, "BrokerEquityOption", path, "", error);
		}
		return success("BrokerEquityOption", ValidationType.CARDINALITY, "BrokerEquityOption", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BrokerEquityOption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BrokerEquityOption", ValidationType.CARDINALITY, "BrokerEquityOption", path, "", res.getError());
				}
				return success("BrokerEquityOption", ValidationType.CARDINALITY, "BrokerEquityOption", path, "");
			})
			.collect(toList());
	}

}
