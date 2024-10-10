package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanAllocationIdentifier;
import fpml.confirmation.LoanTradeAllocationDetailsModel;
import fpml.confirmation.LoanTradeSummary;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanTradeAllocationDetailsModelValidator implements Validator<LoanTradeAllocationDetailsModel> {

	private List<ComparisonResult> getComparisonResults(LoanTradeAllocationDetailsModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("allocationId", (List<? extends LoanAllocationIdentifier>) o.getAllocationId() == null ? 0 : ((List<? extends LoanAllocationIdentifier>) o.getAllocationId()).size(), 1, 0), 
				checkCardinality("tradeSummary", (LoanTradeSummary) o.getTradeSummary() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<LoanTradeAllocationDetailsModel> validate(RosettaPath path, LoanTradeAllocationDetailsModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanTradeAllocationDetailsModel", ValidationType.CARDINALITY, "LoanTradeAllocationDetailsModel", path, "", error);
		}
		return success("LoanTradeAllocationDetailsModel", ValidationType.CARDINALITY, "LoanTradeAllocationDetailsModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradeAllocationDetailsModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradeAllocationDetailsModel", ValidationType.CARDINALITY, "LoanTradeAllocationDetailsModel", path, "", res.getError());
				}
				return success("LoanTradeAllocationDetailsModel", ValidationType.CARDINALITY, "LoanTradeAllocationDetailsModel", path, "");
			})
			.collect(toList());
	}

}
