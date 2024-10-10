package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ProposedCollateralAllocation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ProposedCollateralAllocationTypeFormatValidator implements Validator<ProposedCollateralAllocation> {

	private List<ComparisonResult> getComparisonResults(ProposedCollateralAllocation o) {
		return Lists.<ComparisonResult>newArrayList(
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
			return failure("ProposedCollateralAllocation", ValidationType.TYPE_FORMAT, "ProposedCollateralAllocation", path, "", error);
		}
		return success("ProposedCollateralAllocation", ValidationType.TYPE_FORMAT, "ProposedCollateralAllocation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ProposedCollateralAllocation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ProposedCollateralAllocation", ValidationType.TYPE_FORMAT, "ProposedCollateralAllocation", path, "", res.getError());
				}
				return success("ProposedCollateralAllocation", ValidationType.TYPE_FORMAT, "ProposedCollateralAllocation", path, "");
			})
			.collect(toList());
	}

}
