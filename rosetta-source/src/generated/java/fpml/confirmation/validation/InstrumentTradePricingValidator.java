package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BasicQuotation;
import fpml.confirmation.InstrumentTradePricing;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class InstrumentTradePricingValidator implements Validator<InstrumentTradePricing> {

	private List<ComparisonResult> getComparisonResults(InstrumentTradePricing o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("quote", (List<? extends BasicQuotation>) o.getQuote() == null ? 0 : ((List<? extends BasicQuotation>) o.getQuote()).size(), 1, 0), 
				checkCardinality("couponStartDate", (Date) o.getCouponStartDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("exDividendDate", (Date) o.getExDividendDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradedFlatOfAccrued", (Boolean) o.getTradedFlatOfAccrued() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<InstrumentTradePricing> validate(RosettaPath path, InstrumentTradePricing o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("InstrumentTradePricing", ValidationType.CARDINALITY, "InstrumentTradePricing", path, "", error);
		}
		return success("InstrumentTradePricing", ValidationType.CARDINALITY, "InstrumentTradePricing", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InstrumentTradePricing o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InstrumentTradePricing", ValidationType.CARDINALITY, "InstrumentTradePricing", path, "", res.getError());
				}
				return success("InstrumentTradePricing", ValidationType.CARDINALITY, "InstrumentTradePricing", path, "");
			})
			.collect(toList());
	}

}
