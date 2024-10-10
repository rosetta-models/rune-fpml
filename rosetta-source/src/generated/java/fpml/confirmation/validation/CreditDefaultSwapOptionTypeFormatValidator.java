package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CreditDefaultSwapOption;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CreditDefaultSwapOptionTypeFormatValidator implements Validator<CreditDefaultSwapOption> {

	private List<ComparisonResult> getComparisonResults(CreditDefaultSwapOption o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CreditDefaultSwapOption> validate(RosettaPath path, CreditDefaultSwapOption o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CreditDefaultSwapOption", ValidationType.TYPE_FORMAT, "CreditDefaultSwapOption", path, "", error);
		}
		return success("CreditDefaultSwapOption", ValidationType.TYPE_FORMAT, "CreditDefaultSwapOption", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditDefaultSwapOption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditDefaultSwapOption", ValidationType.TYPE_FORMAT, "CreditDefaultSwapOption", path, "", res.getError());
				}
				return success("CreditDefaultSwapOption", ValidationType.TYPE_FORMAT, "CreditDefaultSwapOption", path, "");
			})
			.collect(toList());
	}

}
