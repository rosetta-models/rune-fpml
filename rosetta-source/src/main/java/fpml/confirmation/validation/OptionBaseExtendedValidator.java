package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.Exercise;
import fpml.confirmation.ExerciseProcedure;
import fpml.confirmation.Money;
import fpml.confirmation.NotionalAmountReference;
import fpml.confirmation.OptionBaseExtended;
import fpml.confirmation.OptionDenominationModel;
import fpml.confirmation.OptionFeature;
import fpml.confirmation.OptionSettlementModel;
import fpml.confirmation.OptionTypeEnum;
import fpml.confirmation.Premium;
import fpml.confirmation.ProductModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OptionBaseExtendedValidator implements Validator<OptionBaseExtended> {

	private List<ComparisonResult> getComparisonResults(OptionBaseExtended o) {
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
				checkCardinality("optionSettlementModel", (OptionSettlementModel) o.getOptionSettlementModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<OptionBaseExtended> validate(RosettaPath path, OptionBaseExtended o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OptionBaseExtended", ValidationType.CARDINALITY, "OptionBaseExtended", path, "", error);
		}
		return success("OptionBaseExtended", ValidationType.CARDINALITY, "OptionBaseExtended", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionBaseExtended o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionBaseExtended", ValidationType.CARDINALITY, "OptionBaseExtended", path, "", res.getError());
				}
				return success("OptionBaseExtended", ValidationType.CARDINALITY, "OptionBaseExtended", path, "");
			})
			.collect(toList());
	}

}
