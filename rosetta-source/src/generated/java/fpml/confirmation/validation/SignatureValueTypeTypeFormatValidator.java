package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SignatureValueType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SignatureValueTypeTypeFormatValidator implements Validator<SignatureValueType> {

	private List<ComparisonResult> getComparisonResults(SignatureValueType o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<SignatureValueType> validate(RosettaPath path, SignatureValueType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SignatureValueType", ValidationType.TYPE_FORMAT, "SignatureValueType", path, "", error);
		}
		return success("SignatureValueType", ValidationType.TYPE_FORMAT, "SignatureValueType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SignatureValueType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SignatureValueType", ValidationType.TYPE_FORMAT, "SignatureValueType", path, "", res.getError());
				}
				return success("SignatureValueType", ValidationType.TYPE_FORMAT, "SignatureValueType", path, "");
			})
			.collect(toList());
	}

}
