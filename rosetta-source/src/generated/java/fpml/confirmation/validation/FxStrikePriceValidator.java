package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxStrikePrice;
import fpml.confirmation.StrikeQuoteBasisEnum;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxStrikePriceValidator implements Validator<FxStrikePrice> {

	private List<ComparisonResult> getComparisonResults(FxStrikePrice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("rate", (BigDecimal) o.getRate() != null ? 1 : 0, 1, 1), 
				checkCardinality("strikeQuoteBasis", (StrikeQuoteBasisEnum) o.getStrikeQuoteBasis() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<FxStrikePrice> validate(RosettaPath path, FxStrikePrice o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxStrikePrice", ValidationType.CARDINALITY, "FxStrikePrice", path, "", error);
		}
		return success("FxStrikePrice", ValidationType.CARDINALITY, "FxStrikePrice", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxStrikePrice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxStrikePrice", ValidationType.CARDINALITY, "FxStrikePrice", path, "", res.getError());
				}
				return success("FxStrikePrice", ValidationType.CARDINALITY, "FxStrikePrice", path, "");
			})
			.collect(toList());
	}

}
