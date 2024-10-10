package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FeeLeg;
import fpml.confirmation.FeeLegChoice;
import fpml.confirmation.PeriodicPayment;
import fpml.confirmation.QuotationStyleEnum;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FeeLegValidator implements Validator<FeeLeg> {

	private List<ComparisonResult> getComparisonResults(FeeLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("feeLegChoice", (FeeLegChoice) o.getFeeLegChoice() != null ? 1 : 0, 0, 1), 
				checkCardinality("periodicPayment", (PeriodicPayment) o.getPeriodicPayment() != null ? 1 : 0, 0, 1), 
				checkCardinality("marketFixedRate", (BigDecimal) o.getMarketFixedRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("paymentDelay", (Boolean) o.getPaymentDelay() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialPoints", (BigDecimal) o.getInitialPoints() != null ? 1 : 0, 0, 1), 
				checkCardinality("marketPrice", (BigDecimal) o.getMarketPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("quotationStyle", (QuotationStyleEnum) o.getQuotationStyle() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FeeLeg> validate(RosettaPath path, FeeLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FeeLeg", ValidationType.CARDINALITY, "FeeLeg", path, "", error);
		}
		return success("FeeLeg", ValidationType.CARDINALITY, "FeeLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FeeLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FeeLeg", ValidationType.CARDINALITY, "FeeLeg", path, "", res.getError());
				}
				return success("FeeLeg", ValidationType.CARDINALITY, "FeeLeg", path, "");
			})
			.collect(toList());
	}

}
