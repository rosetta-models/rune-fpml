package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityPhysicalEuropeanExercise;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityPhysicalEuropeanExerciseTypeFormatValidator implements Validator<CommodityPhysicalEuropeanExercise> {

	private List<ComparisonResult> getComparisonResults(CommodityPhysicalEuropeanExercise o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityPhysicalEuropeanExercise> validate(RosettaPath path, CommodityPhysicalEuropeanExercise o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityPhysicalEuropeanExercise", ValidationType.TYPE_FORMAT, "CommodityPhysicalEuropeanExercise", path, "", error);
		}
		return success("CommodityPhysicalEuropeanExercise", ValidationType.TYPE_FORMAT, "CommodityPhysicalEuropeanExercise", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPhysicalEuropeanExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityPhysicalEuropeanExercise", ValidationType.TYPE_FORMAT, "CommodityPhysicalEuropeanExercise", path, "", res.getError());
				}
				return success("CommodityPhysicalEuropeanExercise", ValidationType.TYPE_FORMAT, "CommodityPhysicalEuropeanExercise", path, "");
			})
			.collect(toList());
	}

}
