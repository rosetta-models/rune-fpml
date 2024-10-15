package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.InterestCalculation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class InterestCalculationTypeFormatValidator implements Validator<InterestCalculation> {

	private List<ComparisonResult> getComparisonResults(InterestCalculation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<InterestCalculation> validate(RosettaPath path, InterestCalculation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("InterestCalculation", ValidationType.TYPE_FORMAT, "InterestCalculation", path, "", error);
		}
		return success("InterestCalculation", ValidationType.TYPE_FORMAT, "InterestCalculation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestCalculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InterestCalculation", ValidationType.TYPE_FORMAT, "InterestCalculation", path, "", res.getError());
				}
				return success("InterestCalculation", ValidationType.TYPE_FORMAT, "InterestCalculation", path, "");
			})
			.collect(toList());
	}

}
