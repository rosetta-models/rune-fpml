package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PersonReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PersonReferenceTypeFormatValidator implements Validator<PersonReference> {

	private List<ComparisonResult> getComparisonResults(PersonReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PersonReference> validate(RosettaPath path, PersonReference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PersonReference", ValidationType.TYPE_FORMAT, "PersonReference", path, "", error);
		}
		return success("PersonReference", ValidationType.TYPE_FORMAT, "PersonReference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PersonReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PersonReference", ValidationType.TYPE_FORMAT, "PersonReference", path, "", res.getError());
				}
				return success("PersonReference", ValidationType.TYPE_FORMAT, "PersonReference", path, "");
			})
			.collect(toList());
	}

}
