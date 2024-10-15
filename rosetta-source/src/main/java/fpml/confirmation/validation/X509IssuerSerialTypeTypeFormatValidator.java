package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.X509IssuerSerialType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class X509IssuerSerialTypeTypeFormatValidator implements Validator<X509IssuerSerialType> {

	private List<ComparisonResult> getComparisonResults(X509IssuerSerialType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("x509SerialNumber", o.getX509SerialNumber(), empty(), of(0), empty(), empty())
			);
	}

	@Override
	public ValidationResult<X509IssuerSerialType> validate(RosettaPath path, X509IssuerSerialType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("X509IssuerSerialType", ValidationType.TYPE_FORMAT, "X509IssuerSerialType", path, "", error);
		}
		return success("X509IssuerSerialType", ValidationType.TYPE_FORMAT, "X509IssuerSerialType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, X509IssuerSerialType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("X509IssuerSerialType", ValidationType.TYPE_FORMAT, "X509IssuerSerialType", path, "", res.getError());
				}
				return success("X509IssuerSerialType", ValidationType.TYPE_FORMAT, "X509IssuerSerialType", path, "");
			})
			.collect(toList());
	}

}
