package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.X509DataTypeSequence;
import fpml.confirmation.X509IssuerSerialType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class X509DataTypeSequenceValidator implements Validator<X509DataTypeSequence> {

	private List<ComparisonResult> getComparisonResults(X509DataTypeSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("x509IssuerSerial", (X509IssuerSerialType) o.getX509IssuerSerial() != null ? 1 : 0, 0, 1), 
				checkCardinality("x509SKI", (String) o.getX509SKI() != null ? 1 : 0, 0, 1), 
				checkCardinality("x509SubjectName", (String) o.getX509SubjectName() != null ? 1 : 0, 0, 1), 
				checkCardinality("x509Certificate", (String) o.getX509Certificate() != null ? 1 : 0, 0, 1), 
				checkCardinality("x509CRL", (String) o.getX509CRL() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<X509DataTypeSequence> validate(RosettaPath path, X509DataTypeSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("X509DataTypeSequence", ValidationType.CARDINALITY, "X509DataTypeSequence", path, "", error);
		}
		return success("X509DataTypeSequence", ValidationType.CARDINALITY, "X509DataTypeSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, X509DataTypeSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("X509DataTypeSequence", ValidationType.CARDINALITY, "X509DataTypeSequence", path, "", res.getError());
				}
				return success("X509DataTypeSequence", ValidationType.CARDINALITY, "X509DataTypeSequence", path, "");
			})
			.collect(toList());
	}

}
