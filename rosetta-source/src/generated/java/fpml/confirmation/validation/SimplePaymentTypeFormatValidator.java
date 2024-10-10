package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SimplePayment;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SimplePaymentTypeFormatValidator implements Validator<SimplePayment> {

	private List<ComparisonResult> getComparisonResults(SimplePayment o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<SimplePayment> validate(RosettaPath path, SimplePayment o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SimplePayment", ValidationType.TYPE_FORMAT, "SimplePayment", path, "", error);
		}
		return success("SimplePayment", ValidationType.TYPE_FORMAT, "SimplePayment", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SimplePayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SimplePayment", ValidationType.TYPE_FORMAT, "SimplePayment", path, "", res.getError());
				}
				return success("SimplePayment", ValidationType.TYPE_FORMAT, "SimplePayment", path, "");
			})
			.collect(toList());
	}

}
