package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.CutName;
import fpml.confirmation.FxDigitalAmericanExercise;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxDigitalAmericanExerciseValidator implements Validator<FxDigitalAmericanExercise> {

	private List<ComparisonResult> getComparisonResults(FxDigitalAmericanExercise o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("commencementDate", (AdjustableOrRelativeDate) o.getCommencementDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("expiryDate", (Date) o.getExpiryDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("expiryTime", (BusinessCenterTime) o.getExpiryTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("cutName", (CutName) o.getCutName() != null ? 1 : 0, 0, 1), 
				checkCardinality("latestValueDate", (Date) o.getLatestValueDate() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<FxDigitalAmericanExercise> validate(RosettaPath path, FxDigitalAmericanExercise o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxDigitalAmericanExercise", ValidationType.CARDINALITY, "FxDigitalAmericanExercise", path, "", error);
		}
		return success("FxDigitalAmericanExercise", ValidationType.CARDINALITY, "FxDigitalAmericanExercise", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxDigitalAmericanExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxDigitalAmericanExercise", ValidationType.CARDINALITY, "FxDigitalAmericanExercise", path, "", res.getError());
				}
				return success("FxDigitalAmericanExercise", ValidationType.CARDINALITY, "FxDigitalAmericanExercise", path, "");
			})
			.collect(toList());
	}

}
