package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.CommodityExercisePeriods;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityExercisePeriodsValidator implements Validator<CommodityExercisePeriods> {

	private List<ComparisonResult> getComparisonResults(CommodityExercisePeriods o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("commencementDate", (AdjustableOrRelativeDate) o.getCommencementDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("expirationDate", (AdjustableOrRelativeDate) o.getExpirationDate() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CommodityExercisePeriods> validate(RosettaPath path, CommodityExercisePeriods o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityExercisePeriods", ValidationType.CARDINALITY, "CommodityExercisePeriods", path, "", error);
		}
		return success("CommodityExercisePeriods", ValidationType.CARDINALITY, "CommodityExercisePeriods", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityExercisePeriods o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityExercisePeriods", ValidationType.CARDINALITY, "CommodityExercisePeriods", path, "", res.getError());
				}
				return success("CommodityExercisePeriods", ValidationType.CARDINALITY, "CommodityExercisePeriods", path, "");
			})
			.collect(toList());
	}

}
