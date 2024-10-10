package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Bankruptcy;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BankruptcyTypeFormatValidator implements Validator<Bankruptcy> {

	private List<ComparisonResult> getComparisonResults(Bankruptcy o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<Bankruptcy> validate(RosettaPath path, Bankruptcy o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Bankruptcy", ValidationType.TYPE_FORMAT, "Bankruptcy", path, "", error);
		}
		return success("Bankruptcy", ValidationType.TYPE_FORMAT, "Bankruptcy", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Bankruptcy o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Bankruptcy", ValidationType.TYPE_FORMAT, "Bankruptcy", path, "", res.getError());
				}
				return success("Bankruptcy", ValidationType.TYPE_FORMAT, "Bankruptcy", path, "");
			})
			.collect(toList());
	}

}
