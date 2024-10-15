package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ActualPrice;
import fpml.confirmation.EquityPriceModel;
import fpml.confirmation.FxConversion;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EquityPriceModelValidator implements Validator<EquityPriceModel> {

	private List<ComparisonResult> getComparisonResults(EquityPriceModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("grossPrice", (ActualPrice) o.getGrossPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("netPrice", (ActualPrice) o.getNetPrice() != null ? 1 : 0, 1, 1), 
				checkCardinality("accruedInterestPrice", (BigDecimal) o.getAccruedInterestPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxConversion", (FxConversion) o.getFxConversion() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<EquityPriceModel> validate(RosettaPath path, EquityPriceModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EquityPriceModel", ValidationType.CARDINALITY, "EquityPriceModel", path, "", error);
		}
		return success("EquityPriceModel", ValidationType.CARDINALITY, "EquityPriceModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityPriceModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquityPriceModel", ValidationType.CARDINALITY, "EquityPriceModel", path, "", res.getError());
				}
				return success("EquityPriceModel", ValidationType.CARDINALITY, "EquityPriceModel", path, "");
			})
			.collect(toList());
	}

}
