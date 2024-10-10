package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FixedPaymentLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FixedPaymentLegTypeFormatValidator implements Validator<FixedPaymentLeg> {

	private List<ComparisonResult> getComparisonResults(FixedPaymentLeg o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FixedPaymentLeg> validate(RosettaPath path, FixedPaymentLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FixedPaymentLeg", ValidationType.TYPE_FORMAT, "FixedPaymentLeg", path, "", error);
		}
		return success("FixedPaymentLeg", ValidationType.TYPE_FORMAT, "FixedPaymentLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FixedPaymentLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FixedPaymentLeg", ValidationType.TYPE_FORMAT, "FixedPaymentLeg", path, "", res.getError());
				}
				return success("FixedPaymentLeg", ValidationType.TYPE_FORMAT, "FixedPaymentLeg", path, "");
			})
			.collect(toList());
	}

}
