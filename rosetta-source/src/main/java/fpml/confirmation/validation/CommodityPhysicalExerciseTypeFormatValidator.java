package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityPhysicalExercise;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityPhysicalExerciseTypeFormatValidator implements Validator<CommodityPhysicalExercise> {

	private List<ComparisonResult> getComparisonResults(CommodityPhysicalExercise o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityPhysicalExercise> validate(RosettaPath path, CommodityPhysicalExercise o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityPhysicalExercise", ValidationType.TYPE_FORMAT, "CommodityPhysicalExercise", path, "", error);
		}
		return success("CommodityPhysicalExercise", ValidationType.TYPE_FORMAT, "CommodityPhysicalExercise", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPhysicalExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityPhysicalExercise", ValidationType.TYPE_FORMAT, "CommodityPhysicalExercise", path, "", res.getError());
				}
				return success("CommodityPhysicalExercise", ValidationType.TYPE_FORMAT, "CommodityPhysicalExercise", path, "");
			})
			.collect(toList());
	}

}
