package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.CalculationAgent;
import fpml.confirmation.CashSettlement;
import fpml.confirmation.Exercise;
import fpml.confirmation.ExerciseProcedure;
import fpml.confirmation.ProductModel;
import fpml.confirmation.Swap;
import fpml.confirmation.Swaption;
import fpml.confirmation.SwaptionAdjustedDates;
import fpml.confirmation.SwaptionPhysicalSettlement;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SwaptionValidator implements Validator<Swaption> {

	private List<ComparisonResult> getComparisonResults(Swaption o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerSellerModel", (BuyerSellerModel) o.getBuyerSellerModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("exercise", (Exercise) o.getExercise() != null ? 1 : 0, 1, 1), 
				checkCardinality("exerciseProcedure", (ExerciseProcedure) o.getExerciseProcedure() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationAgent", (CalculationAgent) o.getCalculationAgent() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashSettlement", (CashSettlement) o.getCashSettlement() != null ? 1 : 0, 0, 1), 
				checkCardinality("physicalSettlement", (SwaptionPhysicalSettlement) o.getPhysicalSettlement() != null ? 1 : 0, 0, 1), 
				checkCardinality("swaptionStraddle", (Boolean) o.getSwaptionStraddle() != null ? 1 : 0, 1, 1), 
				checkCardinality("swaptionAdjustedDates", (SwaptionAdjustedDates) o.getSwaptionAdjustedDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("swap", (Swap) o.getSwap() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<Swaption> validate(RosettaPath path, Swaption o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Swaption", ValidationType.CARDINALITY, "Swaption", path, "", error);
		}
		return success("Swaption", ValidationType.CARDINALITY, "Swaption", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Swaption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Swaption", ValidationType.CARDINALITY, "Swaption", path, "", res.getError());
				}
				return success("Swaption", ValidationType.CARDINALITY, "Swaption", path, "");
			})
			.collect(toList());
	}

}
