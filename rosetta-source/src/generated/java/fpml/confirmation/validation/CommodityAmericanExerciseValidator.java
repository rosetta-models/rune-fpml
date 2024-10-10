package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.CommodityAmericanExercise;
import fpml.confirmation.CommodityAmericanExerciseSequence;
import fpml.confirmation.CommodityExercisePeriods;
import fpml.confirmation.CommodityMultipleExercise;
import fpml.confirmation.DeterminationMethod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityAmericanExerciseValidator implements Validator<CommodityAmericanExercise> {

	private List<ComparisonResult> getComparisonResults(CommodityAmericanExercise o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("exercisePeriod", (CommodityExercisePeriods) o.getExercisePeriod() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityAmericanExerciseSequence", (CommodityAmericanExerciseSequence) o.getCommodityAmericanExerciseSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("latestExerciseTime", (BusinessCenterTime) o.getLatestExerciseTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("latestExerciseTimeDetermination", (DeterminationMethod) o.getLatestExerciseTimeDetermination() != null ? 1 : 0, 0, 1), 
				checkCardinality("expirationTime", (BusinessCenterTime) o.getExpirationTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("multipleExercise", (CommodityMultipleExercise) o.getMultipleExercise() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityAmericanExercise> validate(RosettaPath path, CommodityAmericanExercise o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityAmericanExercise", ValidationType.CARDINALITY, "CommodityAmericanExercise", path, "", error);
		}
		return success("CommodityAmericanExercise", ValidationType.CARDINALITY, "CommodityAmericanExercise", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityAmericanExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityAmericanExercise", ValidationType.CARDINALITY, "CommodityAmericanExercise", path, "", res.getError());
				}
				return success("CommodityAmericanExercise", ValidationType.CARDINALITY, "CommodityAmericanExercise", path, "");
			})
			.collect(toList());
	}

}
