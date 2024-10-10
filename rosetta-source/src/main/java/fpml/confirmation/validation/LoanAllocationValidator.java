package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.LoanAllocation;
import fpml.confirmation.LoanAllocationIdentifier;
import fpml.confirmation.LoanAllocationPartiesModel;
import fpml.confirmation.Money;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanAllocationValidator implements Validator<LoanAllocation> {

	private List<ComparisonResult> getComparisonResults(LoanAllocation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("allocationIdentifier", (LoanAllocationIdentifier) o.getAllocationIdentifier() != null ? 1 : 0, 1, 1), 
				checkCardinality("amount", (Money) o.getAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("comment", (String) o.getComment() != null ? 1 : 0, 0, 1), 
				checkCardinality("loanAllocationPartiesModel", (LoanAllocationPartiesModel) o.getLoanAllocationPartiesModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("buyerSellerModel", (BuyerSellerModel) o.getBuyerSellerModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<LoanAllocation> validate(RosettaPath path, LoanAllocation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanAllocation", ValidationType.CARDINALITY, "LoanAllocation", path, "", error);
		}
		return success("LoanAllocation", ValidationType.CARDINALITY, "LoanAllocation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanAllocation", ValidationType.CARDINALITY, "LoanAllocation", path, "", res.getError());
				}
				return success("LoanAllocation", ValidationType.CARDINALITY, "LoanAllocation", path, "");
			})
			.collect(toList());
	}

}
