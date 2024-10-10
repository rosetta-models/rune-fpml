package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AccruingPikPayment;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AccruingPikPaymentTypeFormatValidator implements Validator<AccruingPikPayment> {

	private List<ComparisonResult> getComparisonResults(AccruingPikPayment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("comment", o.getComment(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<AccruingPikPayment> validate(RosettaPath path, AccruingPikPayment o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AccruingPikPayment", ValidationType.TYPE_FORMAT, "AccruingPikPayment", path, "", error);
		}
		return success("AccruingPikPayment", ValidationType.TYPE_FORMAT, "AccruingPikPayment", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AccruingPikPayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AccruingPikPayment", ValidationType.TYPE_FORMAT, "AccruingPikPayment", path, "", res.getError());
				}
				return success("AccruingPikPayment", ValidationType.TYPE_FORMAT, "AccruingPikPayment", path, "");
			})
			.collect(toList());
	}

}
