package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ActionOnExpiration;
import fpml.confirmation.ExerciseProcedureOption;
import fpml.confirmation.OptionExpiry;
import fpml.confirmation.Trade;
import java.time.LocalTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OptionExpiryValidator implements Validator<OptionExpiry> {

	private List<ComparisonResult> getComparisonResults(OptionExpiry o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("originalTrade", (Trade) o.getOriginalTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("date", (Date) o.getDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("time", (LocalTime) o.getTime() != null ? 1 : 0, 1, 1), 
				checkCardinality("exerciseProcedure", (ExerciseProcedureOption) o.getExerciseProcedure() != null ? 1 : 0, 0, 1), 
				checkCardinality("actionOnExpiration", (ActionOnExpiration) o.getActionOnExpiration() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<OptionExpiry> validate(RosettaPath path, OptionExpiry o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OptionExpiry", ValidationType.CARDINALITY, "OptionExpiry", path, "", error);
		}
		return success("OptionExpiry", ValidationType.CARDINALITY, "OptionExpiry", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionExpiry o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionExpiry", ValidationType.CARDINALITY, "OptionExpiry", path, "", res.getError());
				}
				return success("OptionExpiry", ValidationType.CARDINALITY, "OptionExpiry", path, "");
			})
			.collect(toList());
	}

}
