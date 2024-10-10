package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanTradingPartyRole;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanTradingPartyRoleValidator implements Validator<LoanTradingPartyRole> {

	private List<ComparisonResult> getComparisonResults(LoanTradingPartyRole o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("tradingPartyRoleScheme", (String) o.getTradingPartyRoleScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<LoanTradingPartyRole> validate(RosettaPath path, LoanTradingPartyRole o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanTradingPartyRole", ValidationType.CARDINALITY, "LoanTradingPartyRole", path, "", error);
		}
		return success("LoanTradingPartyRole", ValidationType.CARDINALITY, "LoanTradingPartyRole", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradingPartyRole o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradingPartyRole", ValidationType.CARDINALITY, "LoanTradingPartyRole", path, "", res.getError());
				}
				return success("LoanTradingPartyRole", ValidationType.CARDINALITY, "LoanTradingPartyRole", path, "");
			})
			.collect(toList());
	}

}
