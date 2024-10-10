package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.AdjustableRelativeOrPeriodicDates2;
import fpml.confirmation.CommodityPhysicalEuropeanExercise;
import fpml.confirmation.CommodityRelativeExpirationDates;
import fpml.confirmation.PrevailingTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityPhysicalEuropeanExerciseValidator implements Validator<CommodityPhysicalEuropeanExercise> {

	private List<ComparisonResult> getComparisonResults(CommodityPhysicalEuropeanExercise o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("expirationDate", (AdjustableOrRelativeDate) o.getExpirationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("expirationDates", (AdjustableRelativeOrPeriodicDates2) o.getExpirationDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("relativeExpirationDates", (CommodityRelativeExpirationDates) o.getRelativeExpirationDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("expirationTime", (PrevailingTime) o.getExpirationTime() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityPhysicalEuropeanExercise> validate(RosettaPath path, CommodityPhysicalEuropeanExercise o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityPhysicalEuropeanExercise", ValidationType.CARDINALITY, "CommodityPhysicalEuropeanExercise", path, "", error);
		}
		return success("CommodityPhysicalEuropeanExercise", ValidationType.CARDINALITY, "CommodityPhysicalEuropeanExercise", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPhysicalEuropeanExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityPhysicalEuropeanExercise", ValidationType.CARDINALITY, "CommodityPhysicalEuropeanExercise", path, "", res.getError());
				}
				return success("CommodityPhysicalEuropeanExercise", ValidationType.CARDINALITY, "CommodityPhysicalEuropeanExercise", path, "");
			})
			.collect(toList());
	}

}
