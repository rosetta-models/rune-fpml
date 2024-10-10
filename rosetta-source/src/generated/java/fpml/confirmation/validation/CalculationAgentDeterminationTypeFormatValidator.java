package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CalculationAgentDetermination;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CalculationAgentDeterminationTypeFormatValidator implements Validator<CalculationAgentDetermination> {

	private List<ComparisonResult> getComparisonResults(CalculationAgentDetermination o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CalculationAgentDetermination> validate(RosettaPath path, CalculationAgentDetermination o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CalculationAgentDetermination", ValidationType.TYPE_FORMAT, "CalculationAgentDetermination", path, "", error);
		}
		return success("CalculationAgentDetermination", ValidationType.TYPE_FORMAT, "CalculationAgentDetermination", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationAgentDetermination o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CalculationAgentDetermination", ValidationType.TYPE_FORMAT, "CalculationAgentDetermination", path, "", res.getError());
				}
				return success("CalculationAgentDetermination", ValidationType.TYPE_FORMAT, "CalculationAgentDetermination", path, "");
			})
			.collect(toList());
	}

}
