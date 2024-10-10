package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LetterOfCredit;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LetterOfCreditTypeFormatValidator implements Validator<LetterOfCredit> {

	private List<ComparisonResult> getComparisonResults(LetterOfCredit o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<LetterOfCredit> validate(RosettaPath path, LetterOfCredit o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LetterOfCredit", ValidationType.TYPE_FORMAT, "LetterOfCredit", path, "", error);
		}
		return success("LetterOfCredit", ValidationType.TYPE_FORMAT, "LetterOfCredit", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LetterOfCredit o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LetterOfCredit", ValidationType.TYPE_FORMAT, "LetterOfCredit", path, "", res.getError());
				}
				return success("LetterOfCredit", ValidationType.TYPE_FORMAT, "LetterOfCredit", path, "");
			})
			.collect(toList());
	}

}
