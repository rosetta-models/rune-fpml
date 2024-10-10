package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.FxExpirySchedule;
import fpml.confirmation.FxScheduleSequence0;
import fpml.confirmation.FxScheduleSequence1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxExpiryScheduleValidator implements Validator<FxExpirySchedule> {

	private List<ComparisonResult> getComparisonResults(FxExpirySchedule o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fxScheduleSequence0", (FxScheduleSequence0) o.getFxScheduleSequence0() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxScheduleSequence1", (FxScheduleSequence1) o.getFxScheduleSequence1() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("finalExpiryDate", (Date) o.getFinalExpiryDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("expiryTime", (BusinessCenterTime) o.getExpiryTime() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxExpirySchedule> validate(RosettaPath path, FxExpirySchedule o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxExpirySchedule", ValidationType.CARDINALITY, "FxExpirySchedule", path, "", error);
		}
		return success("FxExpirySchedule", ValidationType.CARDINALITY, "FxExpirySchedule", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxExpirySchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxExpirySchedule", ValidationType.CARDINALITY, "FxExpirySchedule", path, "", res.getError());
				}
				return success("FxExpirySchedule", ValidationType.CARDINALITY, "FxExpirySchedule", path, "");
			})
			.collect(toList());
	}

}
