package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CashPayable;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CashPayableTypeFormatValidator implements Validator<CashPayable> {

	private List<ComparisonResult> getComparisonResults(CashPayable o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CashPayable> validate(RosettaPath path, CashPayable o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CashPayable", ValidationType.TYPE_FORMAT, "CashPayable", path, "", error);
		}
		return success("CashPayable", ValidationType.TYPE_FORMAT, "CashPayable", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CashPayable o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CashPayable", ValidationType.TYPE_FORMAT, "CashPayable", path, "", res.getError());
				}
				return success("CashPayable", ValidationType.TYPE_FORMAT, "CashPayable", path, "");
			})
			.collect(toList());
	}

}
