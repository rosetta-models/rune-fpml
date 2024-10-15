package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.MoneyBase;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MoneyBaseTypeFormatValidator implements Validator<MoneyBase> {

	private List<ComparisonResult> getComparisonResults(MoneyBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<MoneyBase> validate(RosettaPath path, MoneyBase o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("MoneyBase", ValidationType.TYPE_FORMAT, "MoneyBase", path, "", error);
		}
		return success("MoneyBase", ValidationType.TYPE_FORMAT, "MoneyBase", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MoneyBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MoneyBase", ValidationType.TYPE_FORMAT, "MoneyBase", path, "", res.getError());
				}
				return success("MoneyBase", ValidationType.TYPE_FORMAT, "MoneyBase", path, "");
			})
			.collect(toList());
	}

}
