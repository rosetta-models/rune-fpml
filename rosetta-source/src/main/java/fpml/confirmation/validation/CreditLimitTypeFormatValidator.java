package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CreditLimit;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CreditLimitTypeFormatValidator implements Validator<CreditLimit> {

	private List<ComparisonResult> getComparisonResults(CreditLimit o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CreditLimit> validate(RosettaPath path, CreditLimit o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CreditLimit", ValidationType.TYPE_FORMAT, "CreditLimit", path, "", error);
		}
		return success("CreditLimit", ValidationType.TYPE_FORMAT, "CreditLimit", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditLimit o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditLimit", ValidationType.TYPE_FORMAT, "CreditLimit", path, "", res.getError());
				}
				return success("CreditLimit", ValidationType.TYPE_FORMAT, "CreditLimit", path, "");
			})
			.collect(toList());
	}

}
