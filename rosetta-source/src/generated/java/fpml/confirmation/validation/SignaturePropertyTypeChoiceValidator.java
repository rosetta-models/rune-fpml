package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SignaturePropertyTypeChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SignaturePropertyTypeChoiceValidator implements Validator<SignaturePropertyTypeChoice> {

	private List<ComparisonResult> getComparisonResults(SignaturePropertyTypeChoice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<SignaturePropertyTypeChoice> validate(RosettaPath path, SignaturePropertyTypeChoice o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SignaturePropertyTypeChoice", ValidationType.CARDINALITY, "SignaturePropertyTypeChoice", path, "", error);
		}
		return success("SignaturePropertyTypeChoice", ValidationType.CARDINALITY, "SignaturePropertyTypeChoice", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SignaturePropertyTypeChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SignaturePropertyTypeChoice", ValidationType.CARDINALITY, "SignaturePropertyTypeChoice", path, "", res.getError());
				}
				return success("SignaturePropertyTypeChoice", ValidationType.CARDINALITY, "SignaturePropertyTypeChoice", path, "");
			})
			.collect(toList());
	}

}
