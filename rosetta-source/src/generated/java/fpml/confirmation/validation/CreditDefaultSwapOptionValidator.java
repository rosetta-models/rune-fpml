package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.CreditDefaultSwap;
import fpml.confirmation.CreditDefaultSwapOption;
import fpml.confirmation.CreditOptionStrike;
import fpml.confirmation.Exercise;
import fpml.confirmation.ExerciseProcedure;
import fpml.confirmation.Money;
import fpml.confirmation.NotionalAmountReference;
import fpml.confirmation.OptionDenominationModel;
import fpml.confirmation.OptionFeature;
import fpml.confirmation.OptionSettlementModel;
import fpml.confirmation.OptionTypeEnum;
import fpml.confirmation.Premium;
import fpml.confirmation.ProductModel;
import fpml.confirmation.SwaptionPhysicalSettlement;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CreditDefaultSwapOptionValidator implements Validator<CreditDefaultSwapOption> {

	private List<ComparisonResult> getComparisonResults(CreditDefaultSwapOption o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerSellerModel", (BuyerSellerModel) o.getBuyerSellerModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("optionType", (OptionTypeEnum) o.getOptionType() != null ? 1 : 0, 1, 1), 
				checkCardinality("premium", (Premium) o.getPremium() != null ? 1 : 0, 0, 1), 
				checkCardinality("exercise", (Exercise) o.getExercise() != null ? 1 : 0, 1, 1), 
				checkCardinality("exerciseProcedure", (ExerciseProcedure) o.getExerciseProcedure() != null ? 1 : 0, 1, 1), 
				checkCardinality("feature", (OptionFeature) o.getFeature() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalReference", (NotionalAmountReference) o.getNotionalReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalAmount", (Money) o.getNotionalAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionDenominationModel", (OptionDenominationModel) o.getOptionDenominationModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionSettlementModel", (OptionSettlementModel) o.getOptionSettlementModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("clearingInstructions", (SwaptionPhysicalSettlement) o.getClearingInstructions() != null ? 1 : 0, 0, 1), 
				checkCardinality("strike", (CreditOptionStrike) o.getStrike() != null ? 1 : 0, 1, 1), 
				checkCardinality("creditDefaultSwap", (CreditDefaultSwap) o.getCreditDefaultSwap() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CreditDefaultSwapOption> validate(RosettaPath path, CreditDefaultSwapOption o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CreditDefaultSwapOption", ValidationType.CARDINALITY, "CreditDefaultSwapOption", path, "", error);
		}
		return success("CreditDefaultSwapOption", ValidationType.CARDINALITY, "CreditDefaultSwapOption", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditDefaultSwapOption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditDefaultSwapOption", ValidationType.CARDINALITY, "CreditDefaultSwapOption", path, "", res.getError());
				}
				return success("CreditDefaultSwapOption", ValidationType.CARDINALITY, "CreditDefaultSwapOption", path, "");
			})
			.collect(toList());
	}

}
