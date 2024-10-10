package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.QuantityReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class QuantityReferenceTypeFormatValidator implements Validator<QuantityReference> {

	private List<ComparisonResult> getComparisonResults(QuantityReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<QuantityReference> validate(RosettaPath path, QuantityReference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("QuantityReference", ValidationType.TYPE_FORMAT, "QuantityReference", path, "", error);
		}
		return success("QuantityReference", ValidationType.TYPE_FORMAT, "QuantityReference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, QuantityReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("QuantityReference", ValidationType.TYPE_FORMAT, "QuantityReference", path, "", res.getError());
				}
				return success("QuantityReference", ValidationType.TYPE_FORMAT, "QuantityReference", path, "");
			})
			.collect(toList());
	}

}
