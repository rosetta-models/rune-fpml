package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DualCurrencyStrikePrice;
import fpml.confirmation.DualCurrencyStrikeQuoteBasisEnum;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DualCurrencyStrikePriceValidator implements Validator<DualCurrencyStrikePrice> {

	private List<ComparisonResult> getComparisonResults(DualCurrencyStrikePrice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("rate", (BigDecimal) o.getRate() != null ? 1 : 0, 1, 1), 
				checkCardinality("strikeQuoteBasis", (DualCurrencyStrikeQuoteBasisEnum) o.getStrikeQuoteBasis() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<DualCurrencyStrikePrice> validate(RosettaPath path, DualCurrencyStrikePrice o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DualCurrencyStrikePrice", ValidationType.CARDINALITY, "DualCurrencyStrikePrice", path, "", error);
		}
		return success("DualCurrencyStrikePrice", ValidationType.CARDINALITY, "DualCurrencyStrikePrice", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DualCurrencyStrikePrice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DualCurrencyStrikePrice", ValidationType.CARDINALITY, "DualCurrencyStrikePrice", path, "", res.getError());
				}
				return success("DualCurrencyStrikePrice", ValidationType.CARDINALITY, "DualCurrencyStrikePrice", path, "");
			})
			.collect(toList());
	}

}
