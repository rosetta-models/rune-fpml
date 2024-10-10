package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.RepudiationMoratorium;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RepudiationMoratoriumTypeFormatValidator implements Validator<RepudiationMoratorium> {

	private List<ComparisonResult> getComparisonResults(RepudiationMoratorium o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<RepudiationMoratorium> validate(RosettaPath path, RepudiationMoratorium o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RepudiationMoratorium", ValidationType.TYPE_FORMAT, "RepudiationMoratorium", path, "", error);
		}
		return success("RepudiationMoratorium", ValidationType.TYPE_FORMAT, "RepudiationMoratorium", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RepudiationMoratorium o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RepudiationMoratorium", ValidationType.TYPE_FORMAT, "RepudiationMoratorium", path, "", res.getError());
				}
				return success("RepudiationMoratorium", ValidationType.TYPE_FORMAT, "RepudiationMoratorium", path, "");
			})
			.collect(toList());
	}

}
