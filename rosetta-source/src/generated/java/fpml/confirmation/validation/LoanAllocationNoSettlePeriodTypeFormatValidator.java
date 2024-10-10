package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanAllocationNoSettlePeriod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanAllocationNoSettlePeriodTypeFormatValidator implements Validator<LoanAllocationNoSettlePeriod> {

	private List<ComparisonResult> getComparisonResults(LoanAllocationNoSettlePeriod o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<LoanAllocationNoSettlePeriod> validate(RosettaPath path, LoanAllocationNoSettlePeriod o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanAllocationNoSettlePeriod", ValidationType.TYPE_FORMAT, "LoanAllocationNoSettlePeriod", path, "", error);
		}
		return success("LoanAllocationNoSettlePeriod", ValidationType.TYPE_FORMAT, "LoanAllocationNoSettlePeriod", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationNoSettlePeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanAllocationNoSettlePeriod", ValidationType.TYPE_FORMAT, "LoanAllocationNoSettlePeriod", path, "", res.getError());
				}
				return success("LoanAllocationNoSettlePeriod", ValidationType.TYPE_FORMAT, "LoanAllocationNoSettlePeriod", path, "");
			})
			.collect(toList());
	}

}
