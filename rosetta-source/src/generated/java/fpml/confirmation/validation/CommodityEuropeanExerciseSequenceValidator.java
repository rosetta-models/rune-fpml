package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.CommodityEuropeanExerciseSequence;
import fpml.confirmation.Frequency;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityEuropeanExerciseSequenceValidator implements Validator<CommodityEuropeanExerciseSequence> {

	private List<ComparisonResult> getComparisonResults(CommodityEuropeanExerciseSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("expirationDate", (List<? extends AdjustableOrRelativeDate>) o.getExpirationDate() == null ? 0 : ((List<? extends AdjustableOrRelativeDate>) o.getExpirationDate()).size(), 1, 0), 
				checkCardinality("exerciseFrequency", (Frequency) o.getExerciseFrequency() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityEuropeanExerciseSequence> validate(RosettaPath path, CommodityEuropeanExerciseSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityEuropeanExerciseSequence", ValidationType.CARDINALITY, "CommodityEuropeanExerciseSequence", path, "", error);
		}
		return success("CommodityEuropeanExerciseSequence", ValidationType.CARDINALITY, "CommodityEuropeanExerciseSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityEuropeanExerciseSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityEuropeanExerciseSequence", ValidationType.CARDINALITY, "CommodityEuropeanExerciseSequence", path, "", res.getError());
				}
				return success("CommodityEuropeanExerciseSequence", ValidationType.CARDINALITY, "CommodityEuropeanExerciseSequence", path, "");
			})
			.collect(toList());
	}

}
