package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Money;
import fpml.confirmation.Routing;
import fpml.confirmation.SplitSettlement;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SplitSettlementValidator implements Validator<SplitSettlement> {

	private List<ComparisonResult> getComparisonResults(SplitSettlement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("splitSettlementAmount", (Money) o.getSplitSettlementAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("beneficiaryBank", (Routing) o.getBeneficiaryBank() != null ? 1 : 0, 0, 1), 
				checkCardinality("beneficiary", (Routing) o.getBeneficiary() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<SplitSettlement> validate(RosettaPath path, SplitSettlement o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SplitSettlement", ValidationType.CARDINALITY, "SplitSettlement", path, "", error);
		}
		return success("SplitSettlement", ValidationType.CARDINALITY, "SplitSettlement", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SplitSettlement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SplitSettlement", ValidationType.CARDINALITY, "SplitSettlement", path, "", res.getError());
				}
				return success("SplitSettlement", ValidationType.CARDINALITY, "SplitSettlement", path, "");
			})
			.collect(toList());
	}

}
