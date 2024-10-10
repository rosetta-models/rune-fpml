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
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PersonSequenceTypeFormatValidator implements Validator<PersonSequence> {

	private List<ComparisonResult> getComparisonResults(PersonSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("initial", o.getInitial(), 1, of(1), empty())
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
			return failure("PersonSequence", ValidationType.TYPE_FORMAT, "PersonSequence", path, "", error);
		}
		return success("PersonSequence", ValidationType.TYPE_FORMAT, "PersonSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PersonSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PersonSequence", ValidationType.TYPE_FORMAT, "PersonSequence", path, "", res.getError());
				}
				return success("PersonSequence", ValidationType.TYPE_FORMAT, "PersonSequence", path, "");
			})
			.collect(toList());
	}

}
