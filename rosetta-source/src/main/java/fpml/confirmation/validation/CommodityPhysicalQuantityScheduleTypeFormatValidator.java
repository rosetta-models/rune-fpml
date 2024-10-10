package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityPhysicalQuantitySchedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityPhysicalQuantityScheduleTypeFormatValidator implements Validator<CommodityPhysicalQuantitySchedule> {

	private List<ComparisonResult> getComparisonResults(CommodityPhysicalQuantitySchedule o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityPhysicalQuantitySchedule> validate(RosettaPath path, CommodityPhysicalQuantitySchedule o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityPhysicalQuantitySchedule", ValidationType.TYPE_FORMAT, "CommodityPhysicalQuantitySchedule", path, "", error);
		}
		return success("CommodityPhysicalQuantitySchedule", ValidationType.TYPE_FORMAT, "CommodityPhysicalQuantitySchedule", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPhysicalQuantitySchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityPhysicalQuantitySchedule", ValidationType.TYPE_FORMAT, "CommodityPhysicalQuantitySchedule", path, "", res.getError());
				}
				return success("CommodityPhysicalQuantitySchedule", ValidationType.TYPE_FORMAT, "CommodityPhysicalQuantitySchedule", path, "");
			})
			.collect(toList());
	}

}
