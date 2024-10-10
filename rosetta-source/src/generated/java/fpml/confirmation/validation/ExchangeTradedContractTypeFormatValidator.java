package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ExchangeTradedContract;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkNumber;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ExchangeTradedContractTypeFormatValidator implements Validator<ExchangeTradedContract> {

	private List<ComparisonResult> getComparisonResults(ExchangeTradedContract o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("description", o.getDescription(), 0, of(255), empty()), 
				checkNumber("multiplier", o.getMultiplier(), empty(), empty(), of(new BigDecimal("0")), empty()), 
				checkString("contractReference", o.getContractReference(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<ExchangeTradedContract> validate(RosettaPath path, ExchangeTradedContract o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ExchangeTradedContract", ValidationType.TYPE_FORMAT, "ExchangeTradedContract", path, "", error);
		}
		return success("ExchangeTradedContract", ValidationType.TYPE_FORMAT, "ExchangeTradedContract", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExchangeTradedContract o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExchangeTradedContract", ValidationType.TYPE_FORMAT, "ExchangeTradedContract", path, "", res.getError());
				}
				return success("ExchangeTradedContract", ValidationType.TYPE_FORMAT, "ExchangeTradedContract", path, "");
			})
			.collect(toList());
	}

}
