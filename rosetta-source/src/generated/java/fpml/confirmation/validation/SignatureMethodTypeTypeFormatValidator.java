package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SignatureMethodType;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkNumber;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SignatureMethodTypeTypeFormatValidator implements Validator<SignatureMethodType> {

	private List<ComparisonResult> getComparisonResults(SignatureMethodType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("hmacOutputLength", o.getHmacOutputLength(), empty(), of(0), empty(), empty()), 
				checkString("algorithm", o.getAlgorithm(), 0, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+")))
			);
	}

	@Override
	public ValidationResult<SignatureMethodType> validate(RosettaPath path, SignatureMethodType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SignatureMethodType", ValidationType.TYPE_FORMAT, "SignatureMethodType", path, "", error);
		}
		return success("SignatureMethodType", ValidationType.TYPE_FORMAT, "SignatureMethodType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SignatureMethodType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SignatureMethodType", ValidationType.TYPE_FORMAT, "SignatureMethodType", path, "", res.getError());
				}
				return success("SignatureMethodType", ValidationType.TYPE_FORMAT, "SignatureMethodType", path, "");
			})
			.collect(toList());
	}

}
