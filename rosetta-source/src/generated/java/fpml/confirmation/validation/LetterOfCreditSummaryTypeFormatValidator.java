package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LetterOfCreditSummary;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LetterOfCreditSummaryTypeFormatValidator implements Validator<LetterOfCreditSummary> {

	private List<ComparisonResult> getComparisonResults(LetterOfCreditSummary o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<LetterOfCreditSummary> validate(RosettaPath path, LetterOfCreditSummary o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LetterOfCreditSummary", ValidationType.TYPE_FORMAT, "LetterOfCreditSummary", path, "", error);
		}
		return success("LetterOfCreditSummary", ValidationType.TYPE_FORMAT, "LetterOfCreditSummary", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LetterOfCreditSummary o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LetterOfCreditSummary", ValidationType.TYPE_FORMAT, "LetterOfCreditSummary", path, "", res.getError());
				}
				return success("LetterOfCreditSummary", ValidationType.TYPE_FORMAT, "LetterOfCreditSummary", path, "");
			})
			.collect(toList());
	}

}
