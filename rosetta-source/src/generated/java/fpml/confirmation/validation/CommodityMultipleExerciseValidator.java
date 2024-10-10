package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityMultipleExercise;
import fpml.confirmation.CommodityNotionalQuantity;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityMultipleExerciseValidator implements Validator<CommodityMultipleExercise> {

	private List<ComparisonResult> getComparisonResults(CommodityMultipleExercise o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("integralMultipleQuantity", (CommodityNotionalQuantity) o.getIntegralMultipleQuantity() != null ? 1 : 0, 0, 1), 
				checkCardinality("minimumNotionalQuantity", (CommodityNotionalQuantity) o.getMinimumNotionalQuantity() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CommodityMultipleExercise> validate(RosettaPath path, CommodityMultipleExercise o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityMultipleExercise", ValidationType.CARDINALITY, "CommodityMultipleExercise", path, "", error);
		}
		return success("CommodityMultipleExercise", ValidationType.CARDINALITY, "CommodityMultipleExercise", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityMultipleExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityMultipleExercise", ValidationType.CARDINALITY, "CommodityMultipleExercise", path, "", res.getError());
				}
				return success("CommodityMultipleExercise", ValidationType.CARDINALITY, "CommodityMultipleExercise", path, "");
			})
			.collect(toList());
	}

}
