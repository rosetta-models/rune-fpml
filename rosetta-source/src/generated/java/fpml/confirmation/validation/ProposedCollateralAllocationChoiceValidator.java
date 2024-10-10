package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CollateralValueAllocation;
import fpml.confirmation.ProposedCollateralAllocationChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ProposedCollateralAllocationChoiceValidator implements Validator<ProposedCollateralAllocationChoice> {

	private List<ComparisonResult> getComparisonResults(ProposedCollateralAllocationChoice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("collateralValueAllocation", (CollateralValueAllocation) o.getCollateralValueAllocation() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<ProposedCollateralAllocationChoice> validate(RosettaPath path, ProposedCollateralAllocationChoice o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ProposedCollateralAllocationChoice", ValidationType.CARDINALITY, "ProposedCollateralAllocationChoice", path, "", error);
		}
		return success("ProposedCollateralAllocationChoice", ValidationType.CARDINALITY, "ProposedCollateralAllocationChoice", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ProposedCollateralAllocationChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ProposedCollateralAllocationChoice", ValidationType.CARDINALITY, "ProposedCollateralAllocationChoice", path, "", res.getError());
				}
				return success("ProposedCollateralAllocationChoice", ValidationType.CARDINALITY, "ProposedCollateralAllocationChoice", path, "");
			})
			.collect(toList());
	}

}
