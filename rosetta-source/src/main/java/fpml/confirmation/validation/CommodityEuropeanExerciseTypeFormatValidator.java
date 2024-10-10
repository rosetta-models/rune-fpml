package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityEuropeanExercise;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityEuropeanExerciseTypeFormatValidator implements Validator<CommodityEuropeanExercise> {

	private List<ComparisonResult> getComparisonResults(CommodityEuropeanExercise o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityEuropeanExercise> validate(RosettaPath path, CommodityEuropeanExercise o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityEuropeanExercise", ValidationType.TYPE_FORMAT, "CommodityEuropeanExercise", path, "", error);
		}
		return success("CommodityEuropeanExercise", ValidationType.TYPE_FORMAT, "CommodityEuropeanExercise", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityEuropeanExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityEuropeanExercise", ValidationType.TYPE_FORMAT, "CommodityEuropeanExercise", path, "", res.getError());
				}
				return success("CommodityEuropeanExercise", ValidationType.TYPE_FORMAT, "CommodityEuropeanExercise", path, "");
			})
			.collect(toList());
	}

}
