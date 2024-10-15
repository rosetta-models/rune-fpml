package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CreditDefaultSwap;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CreditDefaultSwapTypeFormatValidator implements Validator<CreditDefaultSwap> {

	private List<ComparisonResult> getComparisonResults(CreditDefaultSwap o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CreditDefaultSwap> validate(RosettaPath path, CreditDefaultSwap o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CreditDefaultSwap", ValidationType.TYPE_FORMAT, "CreditDefaultSwap", path, "", error);
		}
		return success("CreditDefaultSwap", ValidationType.TYPE_FORMAT, "CreditDefaultSwap", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditDefaultSwap o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditDefaultSwap", ValidationType.TYPE_FORMAT, "CreditDefaultSwap", path, "", res.getError());
				}
				return success("CreditDefaultSwap", ValidationType.TYPE_FORMAT, "CreditDefaultSwap", path, "");
			})
			.collect(toList());
	}

}
