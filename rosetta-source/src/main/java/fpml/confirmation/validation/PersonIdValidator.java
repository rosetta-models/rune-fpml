package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PersonId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PersonIdValidator implements Validator<PersonId> {

	private List<ComparisonResult> getComparisonResults(PersonId o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("personIdScheme", (String) o.getPersonIdScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<PersonId> validate(RosettaPath path, PersonId o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PersonId", ValidationType.CARDINALITY, "PersonId", path, "", error);
		}
		return success("PersonId", ValidationType.CARDINALITY, "PersonId", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PersonId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PersonId", ValidationType.CARDINALITY, "PersonId", path, "", res.getError());
				}
				return success("PersonId", ValidationType.CARDINALITY, "PersonId", path, "");
			})
			.collect(toList());
	}

}
