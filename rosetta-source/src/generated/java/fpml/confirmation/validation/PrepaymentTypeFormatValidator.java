package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Prepayment;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PrepaymentTypeFormatValidator implements Validator<Prepayment> {

	private List<ComparisonResult> getComparisonResults(Prepayment o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<Prepayment> validate(RosettaPath path, Prepayment o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PrePayment", ValidationType.TYPE_FORMAT, "PrePayment", path, "", error);
		}
		return success("PrePayment", ValidationType.TYPE_FORMAT, "PrePayment", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Prepayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PrePayment", ValidationType.TYPE_FORMAT, "PrePayment", path, "", res.getError());
				}
				return success("PrePayment", ValidationType.TYPE_FORMAT, "PrePayment", path, "");
			})
			.collect(toList());
	}

}
