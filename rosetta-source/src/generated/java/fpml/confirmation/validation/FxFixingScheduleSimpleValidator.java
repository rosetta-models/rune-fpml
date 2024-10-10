package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessCentersOrReferenceModel;
import fpml.confirmation.DayTypeEnum;
import fpml.confirmation.FxFixingScheduleSimple;
import fpml.confirmation.FxFixingScheduleSimpleSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxFixingScheduleSimpleValidator implements Validator<FxFixingScheduleSimple> {

	private List<ComparisonResult> getComparisonResults(FxFixingScheduleSimple o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fxFixingScheduleSimpleSequence", (FxFixingScheduleSimpleSequence) o.getFxFixingScheduleSimpleSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("endDate", (Date) o.getEndDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("dayType", (DayTypeEnum) o.getDayType() != null ? 1 : 0, 0, 1), 
				checkCardinality("businessCentersOrReferenceModel", (BusinessCentersOrReferenceModel) o.getBusinessCentersOrReferenceModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxFixingScheduleSimple> validate(RosettaPath path, FxFixingScheduleSimple o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxFixingScheduleSimple", ValidationType.CARDINALITY, "FxFixingScheduleSimple", path, "", error);
		}
		return success("FxFixingScheduleSimple", ValidationType.CARDINALITY, "FxFixingScheduleSimple", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxFixingScheduleSimple o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxFixingScheduleSimple", ValidationType.CARDINALITY, "FxFixingScheduleSimple", path, "", res.getError());
				}
				return success("FxFixingScheduleSimple", ValidationType.CARDINALITY, "FxFixingScheduleSimple", path, "");
			})
			.collect(toList());
	}

}
