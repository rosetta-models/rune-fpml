package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.DateList;
import fpml.confirmation.DeterminationMethod;
import fpml.confirmation.EquityBermudaExercise;
import fpml.confirmation.EquityExpirationModel;
import fpml.confirmation.EquityMultipleExercise;
import fpml.confirmation.TimeTypeEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EquityBermudaExerciseValidator implements Validator<EquityBermudaExercise> {

	private List<ComparisonResult> getComparisonResults(EquityBermudaExercise o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("commencementDate", (AdjustableOrRelativeDate) o.getCommencementDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("expirationDate", (AdjustableOrRelativeDate) o.getExpirationDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("latestExerciseTime", (BusinessCenterTime) o.getLatestExerciseTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("latestExerciseTimeDetermination", (DeterminationMethod) o.getLatestExerciseTimeDetermination() != null ? 1 : 0, 0, 1), 
				checkCardinality("bermudaExerciseDates", (DateList) o.getBermudaExerciseDates() != null ? 1 : 0, 1, 1), 
				checkCardinality("latestExerciseTimeType", (TimeTypeEnum) o.getLatestExerciseTimeType() != null ? 1 : 0, 0, 1), 
				checkCardinality("equityExpirationModel", (EquityExpirationModel) o.getEquityExpirationModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("equityMultipleExercise", (EquityMultipleExercise) o.getEquityMultipleExercise() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<EquityBermudaExercise> validate(RosettaPath path, EquityBermudaExercise o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EquityBermudaExercise", ValidationType.CARDINALITY, "EquityBermudaExercise", path, "", error);
		}
		return success("EquityBermudaExercise", ValidationType.CARDINALITY, "EquityBermudaExercise", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityBermudaExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquityBermudaExercise", ValidationType.CARDINALITY, "EquityBermudaExercise", path, "", res.getError());
				}
				return success("EquityBermudaExercise", ValidationType.CARDINALITY, "EquityBermudaExercise", path, "");
			})
			.collect(toList());
	}

}
