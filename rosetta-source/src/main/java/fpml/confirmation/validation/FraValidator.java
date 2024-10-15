package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableDate;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.FloatingRateIndex;
import fpml.confirmation.Fra;
import fpml.confirmation.FraDiscountingEnum;
import fpml.confirmation.IdentifiedRate;
import fpml.confirmation.Money;
import fpml.confirmation.Period;
import fpml.confirmation.ProductModel;
import fpml.confirmation.RelativeDateOffset;
import fpml.confirmation.RequiredIdentifierDate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FraValidator implements Validator<Fra> {

	private List<ComparisonResult> getComparisonResults(Fra o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerSellerModel", (BuyerSellerModel) o.getBuyerSellerModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("adjustedEffectiveDate", (RequiredIdentifierDate) o.getAdjustedEffectiveDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("adjustedTerminationDate", (Date) o.getAdjustedTerminationDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("paymentDate", (AdjustableDate) o.getPaymentDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("fixingDateOffset", (RelativeDateOffset) o.getFixingDateOffset() != null ? 1 : 0, 1, 1), 
				checkCardinality("dayCountFraction", (DayCountFraction) o.getDayCountFraction() != null ? 1 : 0, 1, 1), 
				checkCardinality("calculationPeriodNumberOfDays", (Integer) o.getCalculationPeriodNumberOfDays() != null ? 1 : 0, 1, 1), 
				checkCardinality("notional", (Money) o.getNotional() != null ? 1 : 0, 1, 1), 
				checkCardinality("fixedRate", (IdentifiedRate) o.getFixedRate() != null ? 1 : 0, 1, 1), 
				checkCardinality("floatingRateIndex", (FloatingRateIndex) o.getFloatingRateIndex() != null ? 1 : 0, 1, 1), 
				checkCardinality("indexTenor", (List<? extends Period>) o.getIndexTenor() == null ? 0 : ((List<? extends Period>) o.getIndexTenor()).size(), 1, 0), 
				checkCardinality("fraDiscounting", (FraDiscountingEnum) o.getFraDiscounting() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<Fra> validate(RosettaPath path, Fra o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Fra", ValidationType.CARDINALITY, "Fra", path, "", error);
		}
		return success("Fra", ValidationType.CARDINALITY, "Fra", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Fra o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Fra", ValidationType.CARDINALITY, "Fra", path, "", res.getError());
				}
				return success("Fra", ValidationType.CARDINALITY, "Fra", path, "");
			})
			.collect(toList());
	}

}
