package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BankruptcyEvent;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BankruptcyEventValidator implements Validator<BankruptcyEvent> {

	private List<ComparisonResult> getComparisonResults(BankruptcyEvent o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<BankruptcyEvent> validate(RosettaPath path, BankruptcyEvent o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("BankruptcyEvent", ValidationType.CARDINALITY, "BankruptcyEvent", path, "", error);
		}
		return success("BankruptcyEvent", ValidationType.CARDINALITY, "BankruptcyEvent", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BankruptcyEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BankruptcyEvent", ValidationType.CARDINALITY, "BankruptcyEvent", path, "", res.getError());
				}
				return success("BankruptcyEvent", ValidationType.CARDINALITY, "BankruptcyEvent", path, "");
			})
			.collect(toList());
	}

}
