package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FeaturePayment;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FeaturePaymentTypeFormatValidator implements Validator<FeaturePayment> {

	private List<ComparisonResult> getComparisonResults(FeaturePayment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("amount", o.getAmount(), empty(), empty(), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public ValidationResult<FeaturePayment> validate(RosettaPath path, FeaturePayment o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FeaturePayment", ValidationType.TYPE_FORMAT, "FeaturePayment", path, "", error);
		}
		return success("FeaturePayment", ValidationType.TYPE_FORMAT, "FeaturePayment", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FeaturePayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FeaturePayment", ValidationType.TYPE_FORMAT, "FeaturePayment", path, "", res.getError());
				}
				return success("FeaturePayment", ValidationType.TYPE_FORMAT, "FeaturePayment", path, "");
			})
			.collect(toList());
	}

}
