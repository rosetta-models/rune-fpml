package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AbstractLoanTradeSummary;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AbstractLoanTradeSummaryTypeFormatValidator implements Validator<AbstractLoanTradeSummary> {

	private List<ComparisonResult> getComparisonResults(AbstractLoanTradeSummary o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("comment", o.getComment(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<AbstractLoanTradeSummary> validate(RosettaPath path, AbstractLoanTradeSummary o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AbstractLoanTradeSummary", ValidationType.TYPE_FORMAT, "AbstractLoanTradeSummary", path, "", error);
		}
		return success("AbstractLoanTradeSummary", ValidationType.TYPE_FORMAT, "AbstractLoanTradeSummary", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AbstractLoanTradeSummary o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AbstractLoanTradeSummary", ValidationType.TYPE_FORMAT, "AbstractLoanTradeSummary", path, "", res.getError());
				}
				return success("AbstractLoanTradeSummary", ValidationType.TYPE_FORMAT, "AbstractLoanTradeSummary", path, "");
			})
			.collect(toList());
	}

}
