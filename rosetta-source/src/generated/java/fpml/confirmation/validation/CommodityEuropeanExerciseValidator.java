package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.CommodityEuropeanExercise;
import fpml.confirmation.CommodityEuropeanExerciseSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityEuropeanExerciseValidator implements Validator<CommodityEuropeanExercise> {

	private List<ComparisonResult> getComparisonResults(CommodityEuropeanExercise o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("expirationDate", (AdjustableOrRelativeDate) o.getExpirationDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityEuropeanExerciseSequence", (CommodityEuropeanExerciseSequence) o.getCommodityEuropeanExerciseSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("expirationTime", (BusinessCenterTime) o.getExpirationTime() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityEuropeanExercise> validate(RosettaPath path, CommodityEuropeanExercise o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityEuropeanExercise", ValidationType.CARDINALITY, "CommodityEuropeanExercise", path, "", error);
		}
		return success("CommodityEuropeanExercise", ValidationType.CARDINALITY, "CommodityEuropeanExercise", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityEuropeanExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityEuropeanExercise", ValidationType.CARDINALITY, "CommodityEuropeanExercise", path, "", res.getError());
				}
				return success("CommodityEuropeanExercise", ValidationType.CARDINALITY, "CommodityEuropeanExercise", path, "");
			})
			.collect(toList());
	}

}
