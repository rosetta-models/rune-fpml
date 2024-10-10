package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AbstractLoanAllocationSummary;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AbstractLoanAllocationSummaryTypeFormatValidator implements Validator<AbstractLoanAllocationSummary> {

	private List<ComparisonResult> getComparisonResults(AbstractLoanAllocationSummary o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("comment", o.getComment(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<AbstractLoanAllocationSummary> validate(RosettaPath path, AbstractLoanAllocationSummary o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AbstractLoanAllocationSummary", ValidationType.TYPE_FORMAT, "AbstractLoanAllocationSummary", path, "", error);
		}
		return success("AbstractLoanAllocationSummary", ValidationType.TYPE_FORMAT, "AbstractLoanAllocationSummary", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AbstractLoanAllocationSummary o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AbstractLoanAllocationSummary", ValidationType.TYPE_FORMAT, "AbstractLoanAllocationSummary", path, "", res.getError());
				}
				return success("AbstractLoanAllocationSummary", ValidationType.TYPE_FORMAT, "AbstractLoanAllocationSummary", path, "");
			})
			.collect(toList());
	}

}
