package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityAmericanExerciseSequence;
import fpml.confirmation.CommodityExercisePeriods;
import fpml.confirmation.Frequency;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityAmericanExerciseSequenceValidator implements Validator<CommodityAmericanExerciseSequence> {

	private List<ComparisonResult> getComparisonResults(CommodityAmericanExerciseSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("exercisePeriod", (List<? extends CommodityExercisePeriods>) o.getExercisePeriod() == null ? 0 : ((List<? extends CommodityExercisePeriods>) o.getExercisePeriod()).size(), 1, 0), 
				checkCardinality("exerciseFrequency", (Frequency) o.getExerciseFrequency() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityAmericanExerciseSequence> validate(RosettaPath path, CommodityAmericanExerciseSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityAmericanExerciseSequence", ValidationType.CARDINALITY, "CommodityAmericanExerciseSequence", path, "", error);
		}
		return success("CommodityAmericanExerciseSequence", ValidationType.CARDINALITY, "CommodityAmericanExerciseSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityAmericanExerciseSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityAmericanExerciseSequence", ValidationType.CARDINALITY, "CommodityAmericanExerciseSequence", path, "", res.getError());
				}
				return success("CommodityAmericanExerciseSequence", ValidationType.CARDINALITY, "CommodityAmericanExerciseSequence", path, "");
			})
			.collect(toList());
	}

}
