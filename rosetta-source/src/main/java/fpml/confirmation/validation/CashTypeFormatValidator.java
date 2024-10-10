package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Cash;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CashTypeFormatValidator implements Validator<Cash> {

	private List<ComparisonResult> getComparisonResults(Cash o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("description", o.getDescription(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<Cash> validate(RosettaPath path, Cash o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Cash", ValidationType.TYPE_FORMAT, "Cash", path, "", error);
		}
		return success("Cash", ValidationType.TYPE_FORMAT, "Cash", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Cash o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Cash", ValidationType.TYPE_FORMAT, "Cash", path, "", res.getError());
				}
				return success("Cash", ValidationType.TYPE_FORMAT, "Cash", path, "");
			})
			.collect(toList());
	}

}
