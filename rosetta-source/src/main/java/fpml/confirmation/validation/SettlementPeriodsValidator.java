package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityBusinessCalendar;
import fpml.confirmation.DayOfWeekExtEnum;
import fpml.confirmation.OffsetPrevailingTime;
import fpml.confirmation.SettlementPeriodDurationEnum;
import fpml.confirmation.SettlementPeriods;
import java.time.LocalTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SettlementPeriodsValidator implements Validator<SettlementPeriods> {

	private List<ComparisonResult> getComparisonResults(SettlementPeriods o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("duration", (SettlementPeriodDurationEnum) o.getDuration() != null ? 1 : 0, 1, 1), 
				checkCardinality("applicableDay", (List<DayOfWeekExtEnum>) o.getApplicableDay() == null ? 0 : ((List<DayOfWeekExtEnum>) o.getApplicableDay()).size(), 0, 7), 
				checkCardinality("startTime", (OffsetPrevailingTime) o.getStartTime() != null ? 1 : 0, 1, 1), 
				checkCardinality("endTime", (OffsetPrevailingTime) o.getEndTime() != null ? 1 : 0, 1, 1), 
				checkCardinality("timeDuration", (LocalTime) o.getTimeDuration() != null ? 1 : 0, 0, 1), 
				checkCardinality("excludeHolidays", (CommodityBusinessCalendar) o.getExcludeHolidays() != null ? 1 : 0, 0, 1), 
				checkCardinality("includeHolidays", (CommodityBusinessCalendar) o.getIncludeHolidays() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<SettlementPeriods> validate(RosettaPath path, SettlementPeriods o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SettlementPeriods", ValidationType.CARDINALITY, "SettlementPeriods", path, "", error);
		}
		return success("SettlementPeriods", ValidationType.CARDINALITY, "SettlementPeriods", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementPeriods o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SettlementPeriods", ValidationType.CARDINALITY, "SettlementPeriods", path, "", res.getError());
				}
				return success("SettlementPeriods", ValidationType.CARDINALITY, "SettlementPeriods", path, "");
			})
			.collect(toList());
	}

}
