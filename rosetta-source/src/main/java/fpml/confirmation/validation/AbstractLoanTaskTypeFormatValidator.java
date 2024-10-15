package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AbstractLoanTask;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AbstractLoanTaskTypeFormatValidator implements Validator<AbstractLoanTask> {

	private List<ComparisonResult> getComparisonResults(AbstractLoanTask o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("comment", o.getComment(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<AbstractLoanTask> validate(RosettaPath path, AbstractLoanTask o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AbstractLoanTask", ValidationType.TYPE_FORMAT, "AbstractLoanTask", path, "", error);
		}
		return success("AbstractLoanTask", ValidationType.TYPE_FORMAT, "AbstractLoanTask", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AbstractLoanTask o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AbstractLoanTask", ValidationType.TYPE_FORMAT, "AbstractLoanTask", path, "", res.getError());
				}
				return success("AbstractLoanTask", ValidationType.TYPE_FORMAT, "AbstractLoanTask", path, "");
			})
			.collect(toList());
	}

}
