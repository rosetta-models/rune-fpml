package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxTargetPhysicalSettlement;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxTargetPhysicalSettlementTypeFormatValidator implements Validator<FxTargetPhysicalSettlement> {

	private List<ComparisonResult> getComparisonResults(FxTargetPhysicalSettlement o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxTargetPhysicalSettlement> validate(RosettaPath path, FxTargetPhysicalSettlement o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxTargetPhysicalSettlement", ValidationType.TYPE_FORMAT, "FxTargetPhysicalSettlement", path, "", error);
		}
		return success("FxTargetPhysicalSettlement", ValidationType.TYPE_FORMAT, "FxTargetPhysicalSettlement", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetPhysicalSettlement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetPhysicalSettlement", ValidationType.TYPE_FORMAT, "FxTargetPhysicalSettlement", path, "", res.getError());
				}
				return success("FxTargetPhysicalSettlement", ValidationType.TYPE_FORMAT, "FxTargetPhysicalSettlement", path, "");
			})
			.collect(toList());
	}

}
