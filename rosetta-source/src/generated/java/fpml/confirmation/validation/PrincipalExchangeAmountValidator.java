package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AmountReference;
import fpml.confirmation.DeterminationMethod;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.PrincipalExchangeAmount;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PrincipalExchangeAmountValidator implements Validator<PrincipalExchangeAmount> {

	private List<ComparisonResult> getComparisonResults(PrincipalExchangeAmount o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("amountRelativeTo", (AmountReference) o.getAmountRelativeTo() != null ? 1 : 0, 0, 1), 
				checkCardinality("determinationMethod", (DeterminationMethod) o.getDeterminationMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("principalAmount", (NonNegativeMoney) o.getPrincipalAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<PrincipalExchangeAmount> validate(RosettaPath path, PrincipalExchangeAmount o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PrincipalExchangeAmount", ValidationType.CARDINALITY, "PrincipalExchangeAmount", path, "", error);
		}
		return success("PrincipalExchangeAmount", ValidationType.CARDINALITY, "PrincipalExchangeAmount", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PrincipalExchangeAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PrincipalExchangeAmount", ValidationType.CARDINALITY, "PrincipalExchangeAmount", path, "", res.getError());
				}
				return success("PrincipalExchangeAmount", ValidationType.CARDINALITY, "PrincipalExchangeAmount", path, "");
			})
			.collect(toList());
	}

}
