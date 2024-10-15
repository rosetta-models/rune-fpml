package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BrokerConfirmation;
import fpml.confirmation.BrokerConfirmationType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BrokerConfirmationValidator implements Validator<BrokerConfirmation> {

	private List<ComparisonResult> getComparisonResults(BrokerConfirmation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("brokerConfirmationType", (BrokerConfirmationType) o.getBrokerConfirmationType() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<BrokerConfirmation> validate(RosettaPath path, BrokerConfirmation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("BrokerConfirmation", ValidationType.CARDINALITY, "BrokerConfirmation", path, "", error);
		}
		return success("BrokerConfirmation", ValidationType.CARDINALITY, "BrokerConfirmation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BrokerConfirmation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BrokerConfirmation", ValidationType.CARDINALITY, "BrokerConfirmation", path, "", res.getError());
				}
				return success("BrokerConfirmation", ValidationType.CARDINALITY, "BrokerConfirmation", path, "");
			})
			.collect(toList());
	}

}
