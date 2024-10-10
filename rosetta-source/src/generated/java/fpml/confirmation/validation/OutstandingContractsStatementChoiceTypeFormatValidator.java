package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.OutstandingContractsStatementChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OutstandingContractsStatementChoiceTypeFormatValidator implements Validator<OutstandingContractsStatementChoice> {

	private List<ComparisonResult> getComparisonResults(OutstandingContractsStatementChoice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<OutstandingContractsStatementChoice> validate(RosettaPath path, OutstandingContractsStatementChoice o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OutstandingContractsStatementChoice", ValidationType.TYPE_FORMAT, "OutstandingContractsStatementChoice", path, "", error);
		}
		return success("OutstandingContractsStatementChoice", ValidationType.TYPE_FORMAT, "OutstandingContractsStatementChoice", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OutstandingContractsStatementChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OutstandingContractsStatementChoice", ValidationType.TYPE_FORMAT, "OutstandingContractsStatementChoice", path, "", res.getError());
				}
				return success("OutstandingContractsStatementChoice", ValidationType.TYPE_FORMAT, "OutstandingContractsStatementChoice", path, "");
			})
			.collect(toList());
	}

}
