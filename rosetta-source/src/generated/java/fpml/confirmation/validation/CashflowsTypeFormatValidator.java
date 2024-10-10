package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Cashflows;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CashflowsTypeFormatValidator implements Validator<Cashflows> {

	private List<ComparisonResult> getComparisonResults(Cashflows o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<Cashflows> validate(RosettaPath path, Cashflows o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Cashflows", ValidationType.TYPE_FORMAT, "Cashflows", path, "", error);
		}
		return success("Cashflows", ValidationType.TYPE_FORMAT, "Cashflows", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Cashflows o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Cashflows", ValidationType.TYPE_FORMAT, "Cashflows", path, "", res.getError());
				}
				return success("Cashflows", ValidationType.TYPE_FORMAT, "Cashflows", path, "");
			})
			.collect(toList());
	}

}
