package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.NonNegativePayment;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class NonNegativePaymentTypeFormatValidator implements Validator<NonNegativePayment> {

	private List<ComparisonResult> getComparisonResults(NonNegativePayment o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<NonNegativePayment> validate(RosettaPath path, NonNegativePayment o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NonNegativePayment", ValidationType.TYPE_FORMAT, "NonNegativePayment", path, "", error);
		}
		return success("NonNegativePayment", ValidationType.TYPE_FORMAT, "NonNegativePayment", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NonNegativePayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NonNegativePayment", ValidationType.TYPE_FORMAT, "NonNegativePayment", path, "", res.getError());
				}
				return success("NonNegativePayment", ValidationType.TYPE_FORMAT, "NonNegativePayment", path, "");
			})
			.collect(toList());
	}

}
