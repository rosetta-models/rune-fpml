package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.ExerciseProcedure;
import fpml.confirmation.FxDigitalOption;
import fpml.confirmation.FxDigitalOptionSequence0;
import fpml.confirmation.FxDigitalOptionSequence1;
import fpml.confirmation.FxOptionPayout;
import fpml.confirmation.Period;
import fpml.confirmation.ProductModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxDigitalOptionValidator implements Validator<FxDigitalOption> {

	private List<ComparisonResult> getComparisonResults(FxDigitalOption o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerSellerModel", (BuyerSellerModel) o.getBuyerSellerModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("effectiveDate", (AdjustableOrRelativeDate) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("tenorPeriod", (Period) o.getTenorPeriod() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxDigitalOptionSequence0", (FxDigitalOptionSequence0) o.getFxDigitalOptionSequence0() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxDigitalOptionSequence1", (FxDigitalOptionSequence1) o.getFxDigitalOptionSequence1() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseProcedure", (ExerciseProcedure) o.getExerciseProcedure() != null ? 1 : 0, 0, 1), 
				checkCardinality("payout", (FxOptionPayout) o.getPayout() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<FxDigitalOption> validate(RosettaPath path, FxDigitalOption o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxDigitalOption", ValidationType.CARDINALITY, "FxDigitalOption", path, "", error);
		}
		return success("FxDigitalOption", ValidationType.CARDINALITY, "FxDigitalOption", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxDigitalOption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxDigitalOption", ValidationType.CARDINALITY, "FxDigitalOption", path, "", res.getError());
				}
				return success("FxDigitalOption", ValidationType.CARDINALITY, "FxDigitalOption", path, "");
			})
			.collect(toList());
	}

}
