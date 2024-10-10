package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.WaiverFeePayment;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class WaiverFeePaymentTypeFormatValidator implements Validator<WaiverFeePayment> {

	private List<ComparisonResult> getComparisonResults(WaiverFeePayment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("comment", o.getComment(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<WaiverFeePayment> validate(RosettaPath path, WaiverFeePayment o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("WaiverFeePayment", ValidationType.TYPE_FORMAT, "WaiverFeePayment", path, "", error);
		}
		return success("WaiverFeePayment", ValidationType.TYPE_FORMAT, "WaiverFeePayment", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, WaiverFeePayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("WaiverFeePayment", ValidationType.TYPE_FORMAT, "WaiverFeePayment", path, "", res.getError());
				}
				return success("WaiverFeePayment", ValidationType.TYPE_FORMAT, "WaiverFeePayment", path, "");
			})
			.collect(toList());
	}

}
