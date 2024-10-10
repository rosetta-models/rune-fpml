package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CreditDefaultSwapChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CreditDefaultSwapChoiceTypeFormatValidator implements Validator<CreditDefaultSwapChoice> {

	private List<ComparisonResult> getComparisonResults(CreditDefaultSwapChoice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CreditDefaultSwapChoice> validate(RosettaPath path, CreditDefaultSwapChoice o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CreditDefaultSwapChoice", ValidationType.TYPE_FORMAT, "CreditDefaultSwapChoice", path, "", error);
		}
		return success("CreditDefaultSwapChoice", ValidationType.TYPE_FORMAT, "CreditDefaultSwapChoice", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditDefaultSwapChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditDefaultSwapChoice", ValidationType.TYPE_FORMAT, "CreditDefaultSwapChoice", path, "", res.getError());
				}
				return success("CreditDefaultSwapChoice", ValidationType.TYPE_FORMAT, "CreditDefaultSwapChoice", path, "");
			})
			.collect(toList());
	}

}
