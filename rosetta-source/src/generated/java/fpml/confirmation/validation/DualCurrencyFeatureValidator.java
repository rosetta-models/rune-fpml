package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.Currency;
import fpml.confirmation.DualCurrencyFeature;
import fpml.confirmation.DualCurrencyStrikePrice;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DualCurrencyFeatureValidator implements Validator<DualCurrencyFeature> {

	private List<ComparisonResult> getComparisonResults(DualCurrencyFeature o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("currency", (Currency) o.getCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("fixingDate", (Date) o.getFixingDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("fixingTime", (BusinessCenterTime) o.getFixingTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("strike", (DualCurrencyStrikePrice) o.getStrike() != null ? 1 : 0, 1, 1), 
				checkCardinality("spotRate", (BigDecimal) o.getSpotRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("interestAtRisk", (Boolean) o.getInterestAtRisk() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<DualCurrencyFeature> validate(RosettaPath path, DualCurrencyFeature o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DualCurrencyFeature", ValidationType.CARDINALITY, "DualCurrencyFeature", path, "", error);
		}
		return success("DualCurrencyFeature", ValidationType.CARDINALITY, "DualCurrencyFeature", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DualCurrencyFeature o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DualCurrencyFeature", ValidationType.CARDINALITY, "DualCurrencyFeature", path, "", res.getError());
				}
				return success("DualCurrencyFeature", ValidationType.CARDINALITY, "DualCurrencyFeature", path, "");
			})
			.collect(toList());
	}

}
