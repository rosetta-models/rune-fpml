package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.RelatedPerson;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RelatedPersonTypeFormatValidator implements Validator<RelatedPerson> {

	private List<ComparisonResult> getComparisonResults(RelatedPerson o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<RelatedPerson> validate(RosettaPath path, RelatedPerson o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RelatedPerson", ValidationType.TYPE_FORMAT, "RelatedPerson", path, "", error);
		}
		return success("RelatedPerson", ValidationType.TYPE_FORMAT, "RelatedPerson", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RelatedPerson o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RelatedPerson", ValidationType.TYPE_FORMAT, "RelatedPerson", path, "", res.getError());
				}
				return success("RelatedPerson", ValidationType.TYPE_FORMAT, "RelatedPerson", path, "");
			})
			.collect(toList());
	}

}
