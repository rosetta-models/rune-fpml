package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityBusinessCalendar;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityBusinessCalendarValidator implements Validator<CommodityBusinessCalendar> {

	private List<ComparisonResult> getComparisonResults(CommodityBusinessCalendar o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityBusinessCalendarScheme", (String) o.getCommodityBusinessCalendarScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityBusinessCalendar> validate(RosettaPath path, CommodityBusinessCalendar o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityBusinessCalendar", ValidationType.CARDINALITY, "CommodityBusinessCalendar", path, "", error);
		}
		return success("CommodityBusinessCalendar", ValidationType.CARDINALITY, "CommodityBusinessCalendar", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityBusinessCalendar o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityBusinessCalendar", ValidationType.CARDINALITY, "CommodityBusinessCalendar", path, "", res.getError());
				}
				return success("CommodityBusinessCalendar", ValidationType.CARDINALITY, "CommodityBusinessCalendar", path, "");
			})
			.collect(toList());
	}

}
