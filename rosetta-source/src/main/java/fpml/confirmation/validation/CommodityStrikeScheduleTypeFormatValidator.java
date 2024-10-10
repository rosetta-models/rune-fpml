package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityStrikeSchedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityStrikeScheduleTypeFormatValidator implements Validator<CommodityStrikeSchedule> {

	private List<ComparisonResult> getComparisonResults(CommodityStrikeSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityStrikeSchedule> validate(RosettaPath path, CommodityStrikeSchedule o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityStrikeSchedule", ValidationType.TYPE_FORMAT, "CommodityStrikeSchedule", path, "", error);
		}
		return success("CommodityStrikeSchedule", ValidationType.TYPE_FORMAT, "CommodityStrikeSchedule", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityStrikeSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityStrikeSchedule", ValidationType.TYPE_FORMAT, "CommodityStrikeSchedule", path, "", res.getError());
				}
				return success("CommodityStrikeSchedule", ValidationType.TYPE_FORMAT, "CommodityStrikeSchedule", path, "");
			})
			.collect(toList());
	}

}
