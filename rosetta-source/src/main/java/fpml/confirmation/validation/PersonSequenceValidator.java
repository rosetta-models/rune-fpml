package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PersonSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PersonSequenceValidator implements Validator<PersonSequence> {

	private List<ComparisonResult> getComparisonResults(PersonSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("honorific", (String) o.getHonorific() != null ? 1 : 0, 0, 1), 
				checkCardinality("firstName", (String) o.getFirstName() != null ? 1 : 0, 1, 1), 
				checkCardinality("surname", (String) o.getSurname() != null ? 1 : 0, 1, 1), 
				checkCardinality("suffix", (String) o.getSuffix() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<PersonSequence> validate(RosettaPath path, PersonSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PersonSequence", ValidationType.CARDINALITY, "PersonSequence", path, "", error);
		}
		return success("PersonSequence", ValidationType.CARDINALITY, "PersonSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PersonSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PersonSequence", ValidationType.CARDINALITY, "PersonSequence", path, "", res.getError());
				}
				return success("PersonSequence", ValidationType.CARDINALITY, "PersonSequence", path, "");
			})
			.collect(toList());
	}

}
