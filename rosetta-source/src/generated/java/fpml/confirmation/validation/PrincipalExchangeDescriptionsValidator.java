package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PrincipalExchangeAmount;
import fpml.confirmation.PrincipalExchangeDescriptions;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PrincipalExchangeDescriptionsValidator implements Validator<PrincipalExchangeDescriptions> {

	private List<ComparisonResult> getComparisonResults(PrincipalExchangeDescriptions o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("payerReceiverModel", (PayerReceiverModel) o.getPayerReceiverModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("principalExchangeAmount", (PrincipalExchangeAmount) o.getPrincipalExchangeAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("principalExchangeDate", (AdjustableOrRelativeDate) o.getPrincipalExchangeDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<PrincipalExchangeDescriptions> validate(RosettaPath path, PrincipalExchangeDescriptions o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PrincipalExchangeDescriptions", ValidationType.CARDINALITY, "PrincipalExchangeDescriptions", path, "", error);
		}
		return success("PrincipalExchangeDescriptions", ValidationType.CARDINALITY, "PrincipalExchangeDescriptions", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PrincipalExchangeDescriptions o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PrincipalExchangeDescriptions", ValidationType.CARDINALITY, "PrincipalExchangeDescriptions", path, "", res.getError());
				}
				return success("PrincipalExchangeDescriptions", ValidationType.CARDINALITY, "PrincipalExchangeDescriptions", path, "");
			})
			.collect(toList());
	}

}
