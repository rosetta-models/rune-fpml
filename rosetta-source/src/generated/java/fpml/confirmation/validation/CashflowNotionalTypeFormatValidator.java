package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CashflowNotional;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CashflowNotionalTypeFormatValidator implements Validator<CashflowNotional> {

	private List<ComparisonResult> getComparisonResults(CashflowNotional o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CashflowNotional> validate(RosettaPath path, CashflowNotional o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CashflowNotional", ValidationType.TYPE_FORMAT, "CashflowNotional", path, "", error);
		}
		return success("CashflowNotional", ValidationType.TYPE_FORMAT, "CashflowNotional", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CashflowNotional o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CashflowNotional", ValidationType.TYPE_FORMAT, "CashflowNotional", path, "", res.getError());
				}
				return success("CashflowNotional", ValidationType.TYPE_FORMAT, "CashflowNotional", path, "");
			})
			.collect(toList());
	}

}
