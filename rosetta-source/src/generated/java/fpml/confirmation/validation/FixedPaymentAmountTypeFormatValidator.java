package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FixedPaymentAmount;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FixedPaymentAmountTypeFormatValidator implements Validator<FixedPaymentAmount> {

	private List<ComparisonResult> getComparisonResults(FixedPaymentAmount o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FixedPaymentAmount> validate(RosettaPath path, FixedPaymentAmount o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FixedPaymentAmount", ValidationType.TYPE_FORMAT, "FixedPaymentAmount", path, "", error);
		}
		return success("FixedPaymentAmount", ValidationType.TYPE_FORMAT, "FixedPaymentAmount", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FixedPaymentAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FixedPaymentAmount", ValidationType.TYPE_FORMAT, "FixedPaymentAmount", path, "", res.getError());
				}
				return success("FixedPaymentAmount", ValidationType.TYPE_FORMAT, "FixedPaymentAmount", path, "");
			})
			.collect(toList());
	}

}
