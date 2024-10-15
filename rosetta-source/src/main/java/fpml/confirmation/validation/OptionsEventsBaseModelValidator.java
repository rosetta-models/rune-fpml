package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.OptionEvent;
import fpml.confirmation.OptionExercise;
import fpml.confirmation.OptionsEventsBaseModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OptionsEventsBaseModelValidator implements Validator<OptionsEventsBaseModel> {

	private List<ComparisonResult> getComparisonResults(OptionsEventsBaseModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("optionExercise", (OptionExercise) o.getOptionExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionEvent", (OptionEvent) o.getOptionEvent() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<OptionsEventsBaseModel> validate(RosettaPath path, OptionsEventsBaseModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OptionsEventsBaseModel", ValidationType.CARDINALITY, "OptionsEventsBaseModel", path, "", error);
		}
		return success("OptionsEventsBaseModel", ValidationType.CARDINALITY, "OptionsEventsBaseModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionsEventsBaseModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionsEventsBaseModel", ValidationType.CARDINALITY, "OptionsEventsBaseModel", path, "", res.getError());
				}
				return success("OptionsEventsBaseModel", ValidationType.CARDINALITY, "OptionsEventsBaseModel", path, "");
			})
			.collect(toList());
	}

}
