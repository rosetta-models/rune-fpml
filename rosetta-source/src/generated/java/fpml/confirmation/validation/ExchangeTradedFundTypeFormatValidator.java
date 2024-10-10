package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ExchangeTradedFund;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ExchangeTradedFundTypeFormatValidator implements Validator<ExchangeTradedFund> {

	private List<ComparisonResult> getComparisonResults(ExchangeTradedFund o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("description", o.getDescription(), 0, of(255), empty()), 
				checkString("fundManager", o.getFundManager(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<ExchangeTradedFund> validate(RosettaPath path, ExchangeTradedFund o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ExchangeTradedFund", ValidationType.TYPE_FORMAT, "ExchangeTradedFund", path, "", error);
		}
		return success("ExchangeTradedFund", ValidationType.TYPE_FORMAT, "ExchangeTradedFund", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExchangeTradedFund o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExchangeTradedFund", ValidationType.TYPE_FORMAT, "ExchangeTradedFund", path, "", res.getError());
				}
				return success("ExchangeTradedFund", ValidationType.TYPE_FORMAT, "ExchangeTradedFund", path, "");
			})
			.collect(toList());
	}

}
