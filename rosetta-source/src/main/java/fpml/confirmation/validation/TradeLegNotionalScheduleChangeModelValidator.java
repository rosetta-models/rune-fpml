package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.NonNegativeAmountSchedule;
import fpml.confirmation.NotionalReference;
import fpml.confirmation.TradeLegNotionalScheduleChangeModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeLegNotionalScheduleChangeModelValidator implements Validator<TradeLegNotionalScheduleChangeModel> {

	private List<ComparisonResult> getComparisonResults(TradeLegNotionalScheduleChangeModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("notionalScheduleReference", (NotionalReference) o.getNotionalScheduleReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("changeInNotionalSchedule", (NonNegativeAmountSchedule) o.getChangeInNotionalSchedule() != null ? 1 : 0, 1, 1), 
				checkCardinality("outstandingNotionalSchedule", (NonNegativeAmountSchedule) o.getOutstandingNotionalSchedule() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<TradeLegNotionalScheduleChangeModel> validate(RosettaPath path, TradeLegNotionalScheduleChangeModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeLegNotionalScheduleChangeModel", ValidationType.CARDINALITY, "TradeLegNotionalScheduleChangeModel", path, "", error);
		}
		return success("TradeLegNotionalScheduleChangeModel", ValidationType.CARDINALITY, "TradeLegNotionalScheduleChangeModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeLegNotionalScheduleChangeModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeLegNotionalScheduleChangeModel", ValidationType.CARDINALITY, "TradeLegNotionalScheduleChangeModel", path, "", res.getError());
				}
				return success("TradeLegNotionalScheduleChangeModel", ValidationType.CARDINALITY, "TradeLegNotionalScheduleChangeModel", path, "");
			})
			.collect(toList());
	}

}
