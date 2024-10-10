package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxSettlementPeriodBarrier;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxSettlementPeriodBarrierTypeFormatValidator implements Validator<FxSettlementPeriodBarrier> {

	private List<ComparisonResult> getComparisonResults(FxSettlementPeriodBarrier o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxSettlementPeriodBarrier> validate(RosettaPath path, FxSettlementPeriodBarrier o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxSettlementPeriodBarrier", ValidationType.TYPE_FORMAT, "FxSettlementPeriodBarrier", path, "", error);
		}
		return success("FxSettlementPeriodBarrier", ValidationType.TYPE_FORMAT, "FxSettlementPeriodBarrier", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxSettlementPeriodBarrier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxSettlementPeriodBarrier", ValidationType.TYPE_FORMAT, "FxSettlementPeriodBarrier", path, "", res.getError());
				}
				return success("FxSettlementPeriodBarrier", ValidationType.TYPE_FORMAT, "FxSettlementPeriodBarrier", path, "");
			})
			.collect(toList());
	}

}
