package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CreditOptionStrike;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CreditOptionStrikeTypeFormatValidator implements Validator<CreditOptionStrike> {

	private List<ComparisonResult> getComparisonResults(CreditOptionStrike o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CreditOptionStrike> validate(RosettaPath path, CreditOptionStrike o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CreditOptionStrike", ValidationType.TYPE_FORMAT, "CreditOptionStrike", path, "", error);
		}
		return success("CreditOptionStrike", ValidationType.TYPE_FORMAT, "CreditOptionStrike", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditOptionStrike o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditOptionStrike", ValidationType.TYPE_FORMAT, "CreditOptionStrike", path, "", res.getError());
				}
				return success("CreditOptionStrike", ValidationType.TYPE_FORMAT, "CreditOptionStrike", path, "");
			})
			.collect(toList());
	}

}
