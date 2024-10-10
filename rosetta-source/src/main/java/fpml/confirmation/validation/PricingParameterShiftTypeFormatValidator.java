package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PricingParameterShift;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PricingParameterShiftTypeFormatValidator implements Validator<PricingParameterShift> {

	private List<ComparisonResult> getComparisonResults(PricingParameterShift o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PricingParameterShift> validate(RosettaPath path, PricingParameterShift o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PricingParameterShift", ValidationType.TYPE_FORMAT, "PricingParameterShift", path, "", error);
		}
		return success("PricingParameterShift", ValidationType.TYPE_FORMAT, "PricingParameterShift", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PricingParameterShift o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PricingParameterShift", ValidationType.TYPE_FORMAT, "PricingParameterShift", path, "", res.getError());
				}
				return success("PricingParameterShift", ValidationType.TYPE_FORMAT, "PricingParameterShift", path, "");
			})
			.collect(toList());
	}

}
