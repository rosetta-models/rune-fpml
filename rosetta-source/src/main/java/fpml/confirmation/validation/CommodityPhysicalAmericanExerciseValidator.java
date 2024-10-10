package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityPhysicalAmericanExercise;
import fpml.confirmation.CommodityPhysicalAmericanExerciseSequence0;
import fpml.confirmation.CommodityPhysicalAmericanExerciseSequence1;
import fpml.confirmation.PrevailingTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityPhysicalAmericanExerciseValidator implements Validator<CommodityPhysicalAmericanExercise> {

	private List<ComparisonResult> getComparisonResults(CommodityPhysicalAmericanExercise o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityPhysicalAmericanExerciseSequence0", (CommodityPhysicalAmericanExerciseSequence0) o.getCommodityPhysicalAmericanExerciseSequence0() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityPhysicalAmericanExerciseSequence1", (CommodityPhysicalAmericanExerciseSequence1) o.getCommodityPhysicalAmericanExerciseSequence1() != null ? 1 : 0, 0, 1), 
				checkCardinality("latestExerciseTime", (PrevailingTime) o.getLatestExerciseTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("expirationTime", (PrevailingTime) o.getExpirationTime() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityPhysicalAmericanExercise> validate(RosettaPath path, CommodityPhysicalAmericanExercise o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityPhysicalAmericanExercise", ValidationType.CARDINALITY, "CommodityPhysicalAmericanExercise", path, "", error);
		}
		return success("CommodityPhysicalAmericanExercise", ValidationType.CARDINALITY, "CommodityPhysicalAmericanExercise", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPhysicalAmericanExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityPhysicalAmericanExercise", ValidationType.CARDINALITY, "CommodityPhysicalAmericanExercise", path, "", res.getError());
				}
				return success("CommodityPhysicalAmericanExercise", ValidationType.CARDINALITY, "CommodityPhysicalAmericanExercise", path, "");
			})
			.collect(toList());
	}

}
