package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FailureToPayType;
import fpml.confirmation.GracePeriodExtension;
import fpml.confirmation.Money;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FailureToPayTypeValidator implements Validator<FailureToPayType> {

	private List<ComparisonResult> getComparisonResults(FailureToPayType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("applicable", (Boolean) o.getApplicable() != null ? 1 : 0, 1, 1), 
				checkCardinality("gracePeriodExtension", (GracePeriodExtension) o.getGracePeriodExtension() != null ? 1 : 0, 0, 1), 
				checkCardinality("paymentRequirement", (Money) o.getPaymentRequirement() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FailureToPayType> validate(RosettaPath path, FailureToPayType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FailureToPayType", ValidationType.CARDINALITY, "FailureToPayType", path, "", error);
		}
		return success("FailureToPayType", ValidationType.CARDINALITY, "FailureToPayType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FailureToPayType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FailureToPayType", ValidationType.CARDINALITY, "FailureToPayType", path, "", res.getError());
				}
				return success("FailureToPayType", ValidationType.CARDINALITY, "FailureToPayType", path, "");
			})
			.collect(toList());
	}

}
