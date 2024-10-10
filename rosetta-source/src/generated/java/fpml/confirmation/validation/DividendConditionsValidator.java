package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CurrencyAndDeterminationMethodModel;
import fpml.confirmation.DeclaredCashAndCashEquivalentDividendPercentageModel;
import fpml.confirmation.DividendAmountTypeEnum;
import fpml.confirmation.DividendCompositionEnum;
import fpml.confirmation.DividendConditions;
import fpml.confirmation.DividendConditionsSequence;
import fpml.confirmation.DividendEntitlementEnum;
import fpml.confirmation.DividendPaymentDate;
import fpml.confirmation.DividendPeriodEnum;
import fpml.confirmation.InterestAccrualsCompoundingMethod;
import fpml.confirmation.NonCashDividendTreatmentEnum;
import fpml.confirmation.PartyReference;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DividendConditionsValidator implements Validator<DividendConditions> {

	private List<ComparisonResult> getComparisonResults(DividendConditions o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dividendReinvestment", (Boolean) o.getDividendReinvestment() != null ? 1 : 0, 0, 1), 
				checkCardinality("dividendEntitlement", (DividendEntitlementEnum) o.getDividendEntitlement() != null ? 1 : 0, 0, 1), 
				checkCardinality("dividendAmount", (DividendAmountTypeEnum) o.getDividendAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("dividendPaymentDate", (DividendPaymentDate) o.getDividendPaymentDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("dividendConditionsSequence", (DividendConditionsSequence) o.getDividendConditionsSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("dividendPeriod", (DividendPeriodEnum) o.getDividendPeriod() != null ? 1 : 0, 0, 1), 
				checkCardinality("extraOrdinaryDividends", (PartyReference) o.getExtraOrdinaryDividends() != null ? 1 : 0, 0, 1), 
				checkCardinality("excessDividendAmount", (DividendAmountTypeEnum) o.getExcessDividendAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("currencyAndDeterminationMethodModel", (CurrencyAndDeterminationMethodModel) o.getCurrencyAndDeterminationMethodModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("dividendFxTriggerDate", (DividendPaymentDate) o.getDividendFxTriggerDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("interestAccrualsMethod", (InterestAccrualsCompoundingMethod) o.getInterestAccrualsMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("numberOfIndexUnits", (BigDecimal) o.getNumberOfIndexUnits() != null ? 1 : 0, 0, 1), 
				checkCardinality("declaredCashAndCashEquivalentDividendPercentageModel", (DeclaredCashAndCashEquivalentDividendPercentageModel) o.getDeclaredCashAndCashEquivalentDividendPercentageModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("nonCashDividendTreatment", (NonCashDividendTreatmentEnum) o.getNonCashDividendTreatment() != null ? 1 : 0, 0, 1), 
				checkCardinality("dividendComposition", (DividendCompositionEnum) o.getDividendComposition() != null ? 1 : 0, 0, 1), 
				checkCardinality("specialDividends", (Boolean) o.getSpecialDividends() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<DividendConditions> validate(RosettaPath path, DividendConditions o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DividendConditions", ValidationType.CARDINALITY, "DividendConditions", path, "", error);
		}
		return success("DividendConditions", ValidationType.CARDINALITY, "DividendConditions", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendConditions o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DividendConditions", ValidationType.CARDINALITY, "DividendConditions", path, "", res.getError());
				}
				return success("DividendConditions", ValidationType.CARDINALITY, "DividendConditions", path, "");
			})
			.collect(toList());
	}

}
