package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxTargetSettlementPeriod;
import fpml.confirmation.FxTargetSettlementPeriodSchedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxTargetSettlementPeriodScheduleValidator implements Validator<FxTargetSettlementPeriodSchedule> {

	private List<ComparisonResult> getComparisonResults(FxTargetSettlementPeriodSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("settlementPeriod", (List<? extends FxTargetSettlementPeriod>) o.getSettlementPeriod() == null ? 0 : ((List<? extends FxTargetSettlementPeriod>) o.getSettlementPeriod()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<FxTargetSettlementPeriodSchedule> validate(RosettaPath path, FxTargetSettlementPeriodSchedule o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxTargetSettlementPeriodSchedule", ValidationType.CARDINALITY, "FxTargetSettlementPeriodSchedule", path, "", error);
		}
		return success("FxTargetSettlementPeriodSchedule", ValidationType.CARDINALITY, "FxTargetSettlementPeriodSchedule", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetSettlementPeriodSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetSettlementPeriodSchedule", ValidationType.CARDINALITY, "FxTargetSettlementPeriodSchedule", path, "", res.getError());
				}
				return success("FxTargetSettlementPeriodSchedule", ValidationType.CARDINALITY, "FxTargetSettlementPeriodSchedule", path, "");
			})
			.collect(toList());
	}

}
