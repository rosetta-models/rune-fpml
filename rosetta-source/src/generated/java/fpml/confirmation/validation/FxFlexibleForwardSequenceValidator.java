package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.FxFlexibleForwardSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxFlexibleForwardSequenceValidator implements Validator<FxFlexibleForwardSequence> {

	private List<ComparisonResult> getComparisonResults(FxFlexibleForwardSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("earliestExecutionTime", (BusinessCenterTime) o.getEarliestExecutionTime() != null ? 1 : 0, 1, 1), 
				checkCardinality("latestExecutionTime", (BusinessCenterTime) o.getLatestExecutionTime() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<FxFlexibleForwardSequence> validate(RosettaPath path, FxFlexibleForwardSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxFlexibleForwardSequence", ValidationType.CARDINALITY, "FxFlexibleForwardSequence", path, "", error);
		}
		return success("FxFlexibleForwardSequence", ValidationType.CARDINALITY, "FxFlexibleForwardSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxFlexibleForwardSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxFlexibleForwardSequence", ValidationType.CARDINALITY, "FxFlexibleForwardSequence", path, "", res.getError());
				}
				return success("FxFlexibleForwardSequence", ValidationType.CARDINALITY, "FxFlexibleForwardSequence", path, "");
			})
			.collect(toList());
	}

}
