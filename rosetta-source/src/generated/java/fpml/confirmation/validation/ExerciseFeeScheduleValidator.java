package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AmountSchedule;
import fpml.confirmation.ExerciseFeeSchedule;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.RelativeDateOffset;
import fpml.confirmation.Schedule;
import fpml.confirmation.ScheduleReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ExerciseFeeScheduleValidator implements Validator<ExerciseFeeSchedule> {

	private List<ComparisonResult> getComparisonResults(ExerciseFeeSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("payerReceiverModel", (PayerReceiverModel) o.getPayerReceiverModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("notionalReference", (ScheduleReference) o.getNotionalReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("feeAmountSchedule", (AmountSchedule) o.getFeeAmountSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("feeRateSchedule", (Schedule) o.getFeeRateSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("feePaymentDate", (RelativeDateOffset) o.getFeePaymentDate() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<ExerciseFeeSchedule> validate(RosettaPath path, ExerciseFeeSchedule o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ExerciseFeeSchedule", ValidationType.CARDINALITY, "ExerciseFeeSchedule", path, "", error);
		}
		return success("ExerciseFeeSchedule", ValidationType.CARDINALITY, "ExerciseFeeSchedule", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExerciseFeeSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExerciseFeeSchedule", ValidationType.CARDINALITY, "ExerciseFeeSchedule", path, "", res.getError());
				}
				return success("ExerciseFeeSchedule", ValidationType.CARDINALITY, "ExerciseFeeSchedule", path, "");
			})
			.collect(toList());
	}

}
