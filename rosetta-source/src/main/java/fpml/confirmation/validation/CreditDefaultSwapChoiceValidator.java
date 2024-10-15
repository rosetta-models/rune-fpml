package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CashSettlementTerms;
import fpml.confirmation.CreditDefaultSwapChoice;
import fpml.confirmation.PhysicalSettlementTerms;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CreditDefaultSwapChoiceValidator implements Validator<CreditDefaultSwapChoice> {

	private List<ComparisonResult> getComparisonResults(CreditDefaultSwapChoice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("cashSettlementTerms", (CashSettlementTerms) o.getCashSettlementTerms() != null ? 1 : 0, 0, 1), 
				checkCardinality("physicalSettlementTerms", (PhysicalSettlementTerms) o.getPhysicalSettlementTerms() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CreditDefaultSwapChoice> validate(RosettaPath path, CreditDefaultSwapChoice o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CreditDefaultSwapChoice", ValidationType.CARDINALITY, "CreditDefaultSwapChoice", path, "", error);
		}
		return success("CreditDefaultSwapChoice", ValidationType.CARDINALITY, "CreditDefaultSwapChoice", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditDefaultSwapChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditDefaultSwapChoice", ValidationType.CARDINALITY, "CreditDefaultSwapChoice", path, "", res.getError());
				}
				return success("CreditDefaultSwapChoice", ValidationType.CARDINALITY, "CreditDefaultSwapChoice", path, "");
			})
			.collect(toList());
	}

}
