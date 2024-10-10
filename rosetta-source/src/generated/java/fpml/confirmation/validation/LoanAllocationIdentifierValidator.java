package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.IssuerTradeIdModel;
import fpml.confirmation.LoanAllocationIdentifier;
import fpml.confirmation.LoanTradeReference;
import fpml.confirmation.TradeIdentifierSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanAllocationIdentifierValidator implements Validator<LoanAllocationIdentifier> {

	private List<ComparisonResult> getComparisonResults(LoanAllocationIdentifier o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("issuerTradeIdModel", (IssuerTradeIdModel) o.getIssuerTradeIdModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeIdentifierSequence", (TradeIdentifierSequence) o.getTradeIdentifierSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("loanTradeReference", (LoanTradeReference) o.getLoanTradeReference() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<LoanAllocationIdentifier> validate(RosettaPath path, LoanAllocationIdentifier o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanAllocationIdentifier", ValidationType.CARDINALITY, "LoanAllocationIdentifier", path, "", error);
		}
		return success("LoanAllocationIdentifier", ValidationType.CARDINALITY, "LoanAllocationIdentifier", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationIdentifier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanAllocationIdentifier", ValidationType.CARDINALITY, "LoanAllocationIdentifier", path, "", res.getError());
				}
				return success("LoanAllocationIdentifier", ValidationType.CARDINALITY, "LoanAllocationIdentifier", path, "");
			})
			.collect(toList());
	}

}
