package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ActionOnExpiration;
import fpml.confirmation.OptionExerciseAmountModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ActionOnExpirationValidator implements Validator<ActionOnExpiration> {

	private List<ComparisonResult> getComparisonResults(ActionOnExpiration o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("optionExerciseAmountModel", (OptionExerciseAmountModel) o.getOptionExerciseAmountModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<ActionOnExpiration> validate(RosettaPath path, ActionOnExpiration o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ActionOnExpiration", ValidationType.CARDINALITY, "ActionOnExpiration", path, "", error);
		}
		return success("ActionOnExpiration", ValidationType.CARDINALITY, "ActionOnExpiration", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ActionOnExpiration o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ActionOnExpiration", ValidationType.CARDINALITY, "ActionOnExpiration", path, "", res.getError());
				}
				return success("ActionOnExpiration", ValidationType.CARDINALITY, "ActionOnExpiration", path, "");
			})
			.collect(toList());
	}

}
