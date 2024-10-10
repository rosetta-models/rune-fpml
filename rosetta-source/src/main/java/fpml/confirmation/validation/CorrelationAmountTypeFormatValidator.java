package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CorrelationAmount;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CorrelationAmountTypeFormatValidator implements Validator<CorrelationAmount> {

	private List<ComparisonResult> getComparisonResults(CorrelationAmount o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CorrelationAmount> validate(RosettaPath path, CorrelationAmount o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CorrelationAmount", ValidationType.TYPE_FORMAT, "CorrelationAmount", path, "", error);
		}
		return success("CorrelationAmount", ValidationType.TYPE_FORMAT, "CorrelationAmount", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CorrelationAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CorrelationAmount", ValidationType.TYPE_FORMAT, "CorrelationAmount", path, "", res.getError());
				}
				return success("CorrelationAmount", ValidationType.TYPE_FORMAT, "CorrelationAmount", path, "");
			})
			.collect(toList());
	}

}
