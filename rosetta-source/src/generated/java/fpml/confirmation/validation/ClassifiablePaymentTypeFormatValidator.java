package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ClassifiablePayment;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ClassifiablePaymentTypeFormatValidator implements Validator<ClassifiablePayment> {

	private List<ComparisonResult> getComparisonResults(ClassifiablePayment o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ClassifiablePayment> validate(RosettaPath path, ClassifiablePayment o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ClassifiablePayment", ValidationType.TYPE_FORMAT, "ClassifiablePayment", path, "", error);
		}
		return success("ClassifiablePayment", ValidationType.TYPE_FORMAT, "ClassifiablePayment", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ClassifiablePayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ClassifiablePayment", ValidationType.TYPE_FORMAT, "ClassifiablePayment", path, "", res.getError());
				}
				return success("ClassifiablePayment", ValidationType.TYPE_FORMAT, "ClassifiablePayment", path, "");
			})
			.collect(toList());
	}

}
