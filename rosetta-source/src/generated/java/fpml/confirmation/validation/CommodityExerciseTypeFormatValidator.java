package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityExercise;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityExerciseTypeFormatValidator implements Validator<CommodityExercise> {

	private List<ComparisonResult> getComparisonResults(CommodityExercise o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityExercise> validate(RosettaPath path, CommodityExercise o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityExercise", ValidationType.TYPE_FORMAT, "CommodityExercise", path, "", error);
		}
		return success("CommodityExercise", ValidationType.TYPE_FORMAT, "CommodityExercise", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityExercise", ValidationType.TYPE_FORMAT, "CommodityExercise", path, "", res.getError());
				}
				return success("CommodityExercise", ValidationType.TYPE_FORMAT, "CommodityExercise", path, "");
			})
			.collect(toList());
	}

}
