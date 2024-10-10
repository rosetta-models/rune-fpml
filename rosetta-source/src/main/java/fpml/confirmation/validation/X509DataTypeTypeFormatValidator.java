package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.X509DataType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class X509DataTypeTypeFormatValidator implements Validator<X509DataType> {

	private List<ComparisonResult> getComparisonResults(X509DataType o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<X509DataType> validate(RosettaPath path, X509DataType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("X509DataType", ValidationType.TYPE_FORMAT, "X509DataType", path, "", error);
		}
		return success("X509DataType", ValidationType.TYPE_FORMAT, "X509DataType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, X509DataType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("X509DataType", ValidationType.TYPE_FORMAT, "X509DataType", path, "", res.getError());
				}
				return success("X509DataType", ValidationType.TYPE_FORMAT, "X509DataType", path, "");
			})
			.collect(toList());
	}

}
