package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SinglePayment;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SinglePaymentTypeFormatValidator implements Validator<SinglePayment> {

	private List<ComparisonResult> getComparisonResults(SinglePayment o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<SinglePayment> validate(RosettaPath path, SinglePayment o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SinglePayment", ValidationType.TYPE_FORMAT, "SinglePayment", path, "", error);
		}
		return success("SinglePayment", ValidationType.TYPE_FORMAT, "SinglePayment", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SinglePayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SinglePayment", ValidationType.TYPE_FORMAT, "SinglePayment", path, "", res.getError());
				}
				return success("SinglePayment", ValidationType.TYPE_FORMAT, "SinglePayment", path, "");
			})
			.collect(toList());
	}

}
