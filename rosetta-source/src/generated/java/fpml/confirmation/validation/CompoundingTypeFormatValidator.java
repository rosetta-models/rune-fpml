package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Compounding;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CompoundingTypeFormatValidator implements Validator<Compounding> {

	private List<ComparisonResult> getComparisonResults(Compounding o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<Compounding> validate(RosettaPath path, Compounding o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Compounding", ValidationType.TYPE_FORMAT, "Compounding", path, "", error);
		}
		return success("Compounding", ValidationType.TYPE_FORMAT, "Compounding", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Compounding o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Compounding", ValidationType.TYPE_FORMAT, "Compounding", path, "", res.getError());
				}
				return success("Compounding", ValidationType.TYPE_FORMAT, "Compounding", path, "");
			})
			.collect(toList());
	}

}
