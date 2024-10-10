package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CorrelationLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CorrelationLegTypeFormatValidator implements Validator<CorrelationLeg> {

	private List<ComparisonResult> getComparisonResults(CorrelationLeg o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CorrelationLeg> validate(RosettaPath path, CorrelationLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CorrelationLeg", ValidationType.TYPE_FORMAT, "CorrelationLeg", path, "", error);
		}
		return success("CorrelationLeg", ValidationType.TYPE_FORMAT, "CorrelationLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CorrelationLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CorrelationLeg", ValidationType.TYPE_FORMAT, "CorrelationLeg", path, "", res.getError());
				}
				return success("CorrelationLeg", ValidationType.TYPE_FORMAT, "CorrelationLeg", path, "");
			})
			.collect(toList());
	}

}
