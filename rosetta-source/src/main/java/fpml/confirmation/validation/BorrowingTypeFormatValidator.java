package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Borrowing;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BorrowingTypeFormatValidator implements Validator<Borrowing> {

	private List<ComparisonResult> getComparisonResults(Borrowing o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("comment", o.getComment(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<Borrowing> validate(RosettaPath path, Borrowing o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Borrowing", ValidationType.TYPE_FORMAT, "Borrowing", path, "", error);
		}
		return success("Borrowing", ValidationType.TYPE_FORMAT, "Borrowing", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Borrowing o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Borrowing", ValidationType.TYPE_FORMAT, "Borrowing", path, "", res.getError());
				}
				return success("Borrowing", ValidationType.TYPE_FORMAT, "Borrowing", path, "");
			})
			.collect(toList());
	}

}
