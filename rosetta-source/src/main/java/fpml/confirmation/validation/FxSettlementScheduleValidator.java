package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxScheduleSequence0;
import fpml.confirmation.FxScheduleSequence1;
import fpml.confirmation.FxSettlementSchedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxSettlementScheduleValidator implements Validator<FxSettlementSchedule> {

	private List<ComparisonResult> getComparisonResults(FxSettlementSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fxScheduleSequence0", (FxScheduleSequence0) o.getFxScheduleSequence0() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxScheduleSequence1", (FxScheduleSequence1) o.getFxScheduleSequence1() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("finalSettlementDate", (Date) o.getFinalSettlementDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxSettlementSchedule> validate(RosettaPath path, FxSettlementSchedule o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxSettlementSchedule", ValidationType.CARDINALITY, "FxSettlementSchedule", path, "", error);
		}
		return success("FxSettlementSchedule", ValidationType.CARDINALITY, "FxSettlementSchedule", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxSettlementSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxSettlementSchedule", ValidationType.CARDINALITY, "FxSettlementSchedule", path, "", res.getError());
				}
				return success("FxSettlementSchedule", ValidationType.CARDINALITY, "FxSettlementSchedule", path, "");
			})
			.collect(toList());
	}

}
