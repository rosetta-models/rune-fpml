package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Signature;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SignatureTypeFormatValidator implements Validator<Signature> {

	private List<ComparisonResult> getComparisonResults(Signature o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<Signature> validate(RosettaPath path, Signature o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Signature", ValidationType.TYPE_FORMAT, "Signature", path, "", error);
		}
		return success("Signature", ValidationType.TYPE_FORMAT, "Signature", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Signature o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Signature", ValidationType.TYPE_FORMAT, "Signature", path, "", res.getError());
				}
				return success("Signature", ValidationType.TYPE_FORMAT, "Signature", path, "");
			})
			.collect(toList());
	}

}
