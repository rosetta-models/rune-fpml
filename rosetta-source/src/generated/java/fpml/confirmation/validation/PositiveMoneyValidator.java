package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Currency;
import fpml.confirmation.PositiveMoney;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PositiveMoneyValidator implements Validator<PositiveMoney> {

	private List<ComparisonResult> getComparisonResults(PositiveMoney o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("currency", (Currency) o.getCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("amount", (BigDecimal) o.getAmount() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<PositiveMoney> validate(RosettaPath path, PositiveMoney o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PositiveMoney", ValidationType.CARDINALITY, "PositiveMoney", path, "", error);
		}
		return success("PositiveMoney", ValidationType.CARDINALITY, "PositiveMoney", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PositiveMoney o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PositiveMoney", ValidationType.CARDINALITY, "PositiveMoney", path, "", res.getError());
				}
				return success("PositiveMoney", ValidationType.CARDINALITY, "PositiveMoney", path, "");
			})
			.collect(toList());
	}

}
