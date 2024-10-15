package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanTradingDelayedCompensation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanTradingDelayedCompensationTypeFormatValidator implements Validator<LoanTradingDelayedCompensation> {

	private List<ComparisonResult> getComparisonResults(LoanTradingDelayedCompensation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<LoanTradingDelayedCompensation> validate(RosettaPath path, LoanTradingDelayedCompensation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanTradingDelayedCompensation", ValidationType.TYPE_FORMAT, "LoanTradingDelayedCompensation", path, "", error);
		}
		return success("LoanTradingDelayedCompensation", ValidationType.TYPE_FORMAT, "LoanTradingDelayedCompensation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradingDelayedCompensation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradingDelayedCompensation", ValidationType.TYPE_FORMAT, "LoanTradingDelayedCompensation", path, "", res.getError());
				}
				return success("LoanTradingDelayedCompensation", ValidationType.TYPE_FORMAT, "LoanTradingDelayedCompensation", path, "");
			})
			.collect(toList());
	}

}
