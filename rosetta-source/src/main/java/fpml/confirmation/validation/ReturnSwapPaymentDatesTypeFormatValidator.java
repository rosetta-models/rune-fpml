package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ReturnSwapPaymentDates;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReturnSwapPaymentDatesTypeFormatValidator implements Validator<ReturnSwapPaymentDates> {

	private List<ComparisonResult> getComparisonResults(ReturnSwapPaymentDates o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ReturnSwapPaymentDates> validate(RosettaPath path, ReturnSwapPaymentDates o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReturnSwapPaymentDates", ValidationType.TYPE_FORMAT, "ReturnSwapPaymentDates", path, "", error);
		}
		return success("ReturnSwapPaymentDates", ValidationType.TYPE_FORMAT, "ReturnSwapPaymentDates", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnSwapPaymentDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReturnSwapPaymentDates", ValidationType.TYPE_FORMAT, "ReturnSwapPaymentDates", path, "", res.getError());
				}
				return success("ReturnSwapPaymentDates", ValidationType.TYPE_FORMAT, "ReturnSwapPaymentDates", path, "");
			})
			.collect(toList());
	}

}
