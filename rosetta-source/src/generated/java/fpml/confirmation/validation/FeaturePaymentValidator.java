package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.Currency;
import fpml.confirmation.FeaturePayment;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.TimeTypeEnum;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FeaturePaymentValidator implements Validator<FeaturePayment> {

	private List<ComparisonResult> getComparisonResults(FeaturePayment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerReceiverModel", (PayerReceiverModel) o.getPayerReceiverModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("levelPercentage", (BigDecimal) o.getLevelPercentage() != null ? 1 : 0, 0, 1), 
				checkCardinality("amount", (BigDecimal) o.getAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("time", (TimeTypeEnum) o.getTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("currency", (Currency) o.getCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("featurePaymentDate", (AdjustableOrRelativeDate) o.getFeaturePaymentDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FeaturePayment> validate(RosettaPath path, FeaturePayment o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FeaturePayment", ValidationType.CARDINALITY, "FeaturePayment", path, "", error);
		}
		return success("FeaturePayment", ValidationType.CARDINALITY, "FeaturePayment", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FeaturePayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FeaturePayment", ValidationType.CARDINALITY, "FeaturePayment", path, "", res.getError());
				}
				return success("FeaturePayment", ValidationType.CARDINALITY, "FeaturePayment", path, "");
			})
			.collect(toList());
	}

}
