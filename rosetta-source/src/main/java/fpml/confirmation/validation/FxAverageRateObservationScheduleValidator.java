package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CalculationPeriodFrequency;
import fpml.confirmation.FxAverageRateObservationSchedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAverageRateObservationScheduleValidator implements Validator<FxAverageRateObservationSchedule> {

	private List<ComparisonResult> getComparisonResults(FxAverageRateObservationSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("startDate", (Date) o.getStartDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("endDate", (Date) o.getEndDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("calculationPeriodFrequency", (CalculationPeriodFrequency) o.getCalculationPeriodFrequency() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<FxAverageRateObservationSchedule> validate(RosettaPath path, FxAverageRateObservationSchedule o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAverageRateObservationSchedule", ValidationType.CARDINALITY, "FxAverageRateObservationSchedule", path, "", error);
		}
		return success("FxAverageRateObservationSchedule", ValidationType.CARDINALITY, "FxAverageRateObservationSchedule", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAverageRateObservationSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAverageRateObservationSchedule", ValidationType.CARDINALITY, "FxAverageRateObservationSchedule", path, "", res.getError());
				}
				return success("FxAverageRateObservationSchedule", ValidationType.CARDINALITY, "FxAverageRateObservationSchedule", path, "");
			})
			.collect(toList());
	}

}
