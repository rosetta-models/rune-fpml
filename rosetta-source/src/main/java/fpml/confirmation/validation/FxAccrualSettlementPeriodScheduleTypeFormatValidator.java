package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxAccrualSettlementPeriodSchedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAccrualSettlementPeriodScheduleTypeFormatValidator implements Validator<FxAccrualSettlementPeriodSchedule> {

	private List<ComparisonResult> getComparisonResults(FxAccrualSettlementPeriodSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxAccrualSettlementPeriodSchedule> validate(RosettaPath path, FxAccrualSettlementPeriodSchedule o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAccrualSettlementPeriodSchedule", ValidationType.TYPE_FORMAT, "FxAccrualSettlementPeriodSchedule", path, "", error);
		}
		return success("FxAccrualSettlementPeriodSchedule", ValidationType.TYPE_FORMAT, "FxAccrualSettlementPeriodSchedule", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualSettlementPeriodSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualSettlementPeriodSchedule", ValidationType.TYPE_FORMAT, "FxAccrualSettlementPeriodSchedule", path, "", res.getError());
				}
				return success("FxAccrualSettlementPeriodSchedule", ValidationType.TYPE_FORMAT, "FxAccrualSettlementPeriodSchedule", path, "");
			})
			.collect(toList());
	}

}
