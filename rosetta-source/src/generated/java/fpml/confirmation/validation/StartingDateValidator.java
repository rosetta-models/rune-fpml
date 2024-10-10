package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableDate;
import fpml.confirmation.DateReference;
import fpml.confirmation.StartingDate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class StartingDateValidator implements Validator<StartingDate> {

	private List<ComparisonResult> getComparisonResults(StartingDate o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dateRelativeTo", (DateReference) o.getDateRelativeTo() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustableDate", (AdjustableDate) o.getAdjustableDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<StartingDate> validate(RosettaPath path, StartingDate o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("StartingDate", ValidationType.CARDINALITY, "StartingDate", path, "", error);
		}
		return success("StartingDate", ValidationType.CARDINALITY, "StartingDate", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, StartingDate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("StartingDate", ValidationType.CARDINALITY, "StartingDate", path, "", res.getError());
				}
				return success("StartingDate", ValidationType.CARDINALITY, "StartingDate", path, "");
			})
			.collect(toList());
	}

}
