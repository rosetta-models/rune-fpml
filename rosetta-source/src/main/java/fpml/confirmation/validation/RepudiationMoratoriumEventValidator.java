package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.RepudiationMoratoriumEvent;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RepudiationMoratoriumEventValidator implements Validator<RepudiationMoratoriumEvent> {

	private List<ComparisonResult> getComparisonResults(RepudiationMoratoriumEvent o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<RepudiationMoratoriumEvent> validate(RosettaPath path, RepudiationMoratoriumEvent o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RepudiationMoratoriumEvent", ValidationType.CARDINALITY, "RepudiationMoratoriumEvent", path, "", error);
		}
		return success("RepudiationMoratoriumEvent", ValidationType.CARDINALITY, "RepudiationMoratoriumEvent", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RepudiationMoratoriumEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RepudiationMoratoriumEvent", ValidationType.CARDINALITY, "RepudiationMoratoriumEvent", path, "", res.getError());
				}
				return success("RepudiationMoratoriumEvent", ValidationType.CARDINALITY, "RepudiationMoratoriumEvent", path, "");
			})
			.collect(toList());
	}

}
