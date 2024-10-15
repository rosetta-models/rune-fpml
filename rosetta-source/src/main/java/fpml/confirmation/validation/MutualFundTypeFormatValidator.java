package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.MutualFund;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MutualFundTypeFormatValidator implements Validator<MutualFund> {

	private List<ComparisonResult> getComparisonResults(MutualFund o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("description", o.getDescription(), 0, of(255), empty()), 
				checkString("fundManager", o.getFundManager(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<MutualFund> validate(RosettaPath path, MutualFund o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("MutualFund", ValidationType.TYPE_FORMAT, "MutualFund", path, "", error);
		}
		return success("MutualFund", ValidationType.TYPE_FORMAT, "MutualFund", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MutualFund o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MutualFund", ValidationType.TYPE_FORMAT, "MutualFund", path, "", res.getError());
				}
				return success("MutualFund", ValidationType.TYPE_FORMAT, "MutualFund", path, "");
			})
			.collect(toList());
	}

}
