package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxForwardStrikePrice;
import fpml.confirmation.QuoteBasisEnum;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxForwardStrikePriceValidator implements Validator<FxForwardStrikePrice> {

	private List<ComparisonResult> getComparisonResults(FxForwardStrikePrice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("initialValue", (BigDecimal) o.getInitialValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("quoteBasis", (QuoteBasisEnum) o.getQuoteBasis() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<FxForwardStrikePrice> validate(RosettaPath path, FxForwardStrikePrice o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxForwardStrikePrice", ValidationType.CARDINALITY, "FxForwardStrikePrice", path, "", error);
		}
		return success("FxForwardStrikePrice", ValidationType.CARDINALITY, "FxForwardStrikePrice", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxForwardStrikePrice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxForwardStrikePrice", ValidationType.CARDINALITY, "FxForwardStrikePrice", path, "", res.getError());
				}
				return success("FxForwardStrikePrice", ValidationType.CARDINALITY, "FxForwardStrikePrice", path, "");
			})
			.collect(toList());
	}

}
