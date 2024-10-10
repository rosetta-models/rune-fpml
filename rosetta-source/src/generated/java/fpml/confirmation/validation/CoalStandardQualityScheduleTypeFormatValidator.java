package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CoalStandardQualitySchedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CoalStandardQualityScheduleTypeFormatValidator implements Validator<CoalStandardQualitySchedule> {

	private List<ComparisonResult> getComparisonResults(CoalStandardQualitySchedule o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CoalStandardQualitySchedule> validate(RosettaPath path, CoalStandardQualitySchedule o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CoalStandardQualitySchedule", ValidationType.TYPE_FORMAT, "CoalStandardQualitySchedule", path, "", error);
		}
		return success("CoalStandardQualitySchedule", ValidationType.TYPE_FORMAT, "CoalStandardQualitySchedule", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CoalStandardQualitySchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CoalStandardQualitySchedule", ValidationType.TYPE_FORMAT, "CoalStandardQualitySchedule", path, "", res.getError());
				}
				return success("CoalStandardQualitySchedule", ValidationType.TYPE_FORMAT, "CoalStandardQualitySchedule", path, "");
			})
			.collect(toList());
	}

}
