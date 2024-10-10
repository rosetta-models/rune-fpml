package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BrokerConfirmationType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BrokerConfirmationTypeValidator implements Validator<BrokerConfirmationType> {

	private List<ComparisonResult> getComparisonResults(BrokerConfirmationType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("brokerConfirmationTypeScheme", (String) o.getBrokerConfirmationTypeScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<BrokerConfirmationType> validate(RosettaPath path, BrokerConfirmationType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("BrokerConfirmationType", ValidationType.CARDINALITY, "BrokerConfirmationType", path, "", error);
		}
		return success("BrokerConfirmationType", ValidationType.CARDINALITY, "BrokerConfirmationType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BrokerConfirmationType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BrokerConfirmationType", ValidationType.CARDINALITY, "BrokerConfirmationType", path, "", res.getError());
				}
				return success("BrokerConfirmationType", ValidationType.CARDINALITY, "BrokerConfirmationType", path, "");
			})
			.collect(toList());
	}

}
