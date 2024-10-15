package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.X509Data;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class X509DataTypeFormatValidator implements Validator<X509Data> {

	private List<ComparisonResult> getComparisonResults(X509Data o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<X509Data> validate(RosettaPath path, X509Data o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("X509Data", ValidationType.TYPE_FORMAT, "X509Data", path, "", error);
		}
		return success("X509Data", ValidationType.TYPE_FORMAT, "X509Data", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, X509Data o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("X509Data", ValidationType.TYPE_FORMAT, "X509Data", path, "", res.getError());
				}
				return success("X509Data", ValidationType.TYPE_FORMAT, "X509Data", path, "");
			})
			.collect(toList());
	}

}
