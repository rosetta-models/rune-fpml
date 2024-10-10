package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CollateralPartyAndAccountReferencesModel;
import fpml.confirmation.ProposedCollateralAllocation;
import fpml.confirmation.ProposedCollateralAllocationChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ProposedCollateralAllocationValidator implements Validator<ProposedCollateralAllocation> {

	private List<ComparisonResult> getComparisonResults(ProposedCollateralAllocation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("collateralPartyAndAccountReferencesModel", (CollateralPartyAndAccountReferencesModel) o.getCollateralPartyAndAccountReferencesModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("proposedCollateralAllocationChoice", (List<? extends ProposedCollateralAllocationChoice>) o.getProposedCollateralAllocationChoice() == null ? 0 : ((List<? extends ProposedCollateralAllocationChoice>) o.getProposedCollateralAllocationChoice()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<ProposedCollateralAllocation> validate(RosettaPath path, ProposedCollateralAllocation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ProposedCollateralAllocation", ValidationType.CARDINALITY, "ProposedCollateralAllocation", path, "", error);
		}
		return success("ProposedCollateralAllocation", ValidationType.CARDINALITY, "ProposedCollateralAllocation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ProposedCollateralAllocation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ProposedCollateralAllocation", ValidationType.CARDINALITY, "ProposedCollateralAllocation", path, "", res.getError());
				}
				return success("ProposedCollateralAllocation", ValidationType.CARDINALITY, "ProposedCollateralAllocation", path, "");
			})
			.collect(toList());
	}

}
