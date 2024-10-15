package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.AssetReference;
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.DividendPeriodPayment;
import fpml.confirmation.IdentifiedDate;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DividendPeriodPaymentValidator implements Validator<DividendPeriodPayment> {

	private List<ComparisonResult> getComparisonResults(DividendPeriodPayment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("unadjustedStartDate", (IdentifiedDate) o.getUnadjustedStartDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("unadjustedEndDate", (IdentifiedDate) o.getUnadjustedEndDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("dateAdjustments", (BusinessDayAdjustments) o.getDateAdjustments() != null ? 1 : 0, 1, 1), 
				checkCardinality("underlyerReference", (AssetReference) o.getUnderlyerReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedStrike", (BigDecimal) o.getFixedStrike() != null ? 1 : 0, 1, 1), 
				checkCardinality("paymentDate", (AdjustableOrRelativeDate) o.getPaymentDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("valuationDate", (AdjustableOrRelativeDate) o.getValuationDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<DividendPeriodPayment> validate(RosettaPath path, DividendPeriodPayment o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DividendPeriodPayment", ValidationType.CARDINALITY, "DividendPeriodPayment", path, "", error);
		}
		return success("DividendPeriodPayment", ValidationType.CARDINALITY, "DividendPeriodPayment", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendPeriodPayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DividendPeriodPayment", ValidationType.CARDINALITY, "DividendPeriodPayment", path, "", res.getError());
				}
				return success("DividendPeriodPayment", ValidationType.CARDINALITY, "DividendPeriodPayment", path, "");
			})
			.collect(toList());
	}

}
