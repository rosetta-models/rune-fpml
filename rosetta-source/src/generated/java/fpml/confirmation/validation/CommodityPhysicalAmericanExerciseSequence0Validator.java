package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDates;
import fpml.confirmation.CommodityPhysicalAmericanExerciseSequence0;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityPhysicalAmericanExerciseSequence0Validator implements Validator<CommodityPhysicalAmericanExerciseSequence0> {

	private List<ComparisonResult> getComparisonResults(CommodityPhysicalAmericanExerciseSequence0 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("commencementDates", (AdjustableOrRelativeDates) o.getCommencementDates() != null ? 1 : 0, 1, 1), 
				checkCardinality("expirationDates", (AdjustableOrRelativeDates) o.getExpirationDates() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CommodityPhysicalAmericanExerciseSequence0> validate(RosettaPath path, CommodityPhysicalAmericanExerciseSequence0 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityPhysicalAmericanExerciseSequence0", ValidationType.CARDINALITY, "CommodityPhysicalAmericanExerciseSequence0", path, "", error);
		}
		return success("CommodityPhysicalAmericanExerciseSequence0", ValidationType.CARDINALITY, "CommodityPhysicalAmericanExerciseSequence0", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPhysicalAmericanExerciseSequence0 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityPhysicalAmericanExerciseSequence0", ValidationType.CARDINALITY, "CommodityPhysicalAmericanExerciseSequence0", path, "", res.getError());
				}
				return success("CommodityPhysicalAmericanExerciseSequence0", ValidationType.CARDINALITY, "CommodityPhysicalAmericanExerciseSequence0", path, "");
			})
			.collect(toList());
	}

}
