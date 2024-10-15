package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxAccrualSettlementPeriodPayoff;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAccrualSettlementPeriodPayoffTypeFormatValidator implements Validator<FxAccrualSettlementPeriodPayoff> {

	private List<ComparisonResult> getComparisonResults(FxAccrualSettlementPeriodPayoff o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxAccrualSettlementPeriodPayoff> validate(RosettaPath path, FxAccrualSettlementPeriodPayoff o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAccrualSettlementPeriodPayoff", ValidationType.TYPE_FORMAT, "FxAccrualSettlementPeriodPayoff", path, "", error);
		}
		return success("FxAccrualSettlementPeriodPayoff", ValidationType.TYPE_FORMAT, "FxAccrualSettlementPeriodPayoff", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualSettlementPeriodPayoff o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualSettlementPeriodPayoff", ValidationType.TYPE_FORMAT, "FxAccrualSettlementPeriodPayoff", path, "", res.getError());
				}
				return success("FxAccrualSettlementPeriodPayoff", ValidationType.TYPE_FORMAT, "FxAccrualSettlementPeriodPayoff", path, "");
			})
			.collect(toList());
	}

}
