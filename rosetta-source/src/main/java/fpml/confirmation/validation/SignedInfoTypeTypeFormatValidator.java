package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SignedInfoType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SignedInfoTypeTypeFormatValidator implements Validator<SignedInfoType> {

	private List<ComparisonResult> getComparisonResults(SignedInfoType o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<SignedInfoType> validate(RosettaPath path, SignedInfoType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SignedInfoType", ValidationType.TYPE_FORMAT, "SignedInfoType", path, "", error);
		}
		return success("SignedInfoType", ValidationType.TYPE_FORMAT, "SignedInfoType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SignedInfoType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SignedInfoType", ValidationType.TYPE_FORMAT, "SignedInfoType", path, "", res.getError());
				}
				return success("SignedInfoType", ValidationType.TYPE_FORMAT, "SignedInfoType", path, "");
			})
			.collect(toList());
	}

}
