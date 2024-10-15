package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Person;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PersonTypeFormatValidator implements Validator<Person> {

	private List<ComparisonResult> getComparisonResults(Person o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<Person> validate(RosettaPath path, Person o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Person", ValidationType.TYPE_FORMAT, "Person", path, "", error);
		}
		return success("Person", ValidationType.TYPE_FORMAT, "Person", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Person o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Person", ValidationType.TYPE_FORMAT, "Person", path, "", res.getError());
				}
				return success("Person", ValidationType.TYPE_FORMAT, "Person", path, "");
			})
			.collect(toList());
	}

}
