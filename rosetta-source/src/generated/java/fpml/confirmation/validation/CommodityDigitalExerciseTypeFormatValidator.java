package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityDigitalExercise;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityDigitalExerciseTypeFormatValidator implements Validator<CommodityDigitalExercise> {

	private List<ComparisonResult> getComparisonResults(CommodityDigitalExercise o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityDigitalExercise> validate(RosettaPath path, CommodityDigitalExercise o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityDigitalExercise", ValidationType.TYPE_FORMAT, "CommodityDigitalExercise", path, "", error);
		}
		return success("CommodityDigitalExercise", ValidationType.TYPE_FORMAT, "CommodityDigitalExercise", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityDigitalExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityDigitalExercise", ValidationType.TYPE_FORMAT, "CommodityDigitalExercise", path, "", res.getError());
				}
				return success("CommodityDigitalExercise", ValidationType.TYPE_FORMAT, "CommodityDigitalExercise", path, "");
			})
			.collect(toList());
	}

}
