package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DealtCurrencyEnum;
import fpml.confirmation.ExchangeRate;
import fpml.confirmation.FxCashSettlement;
import fpml.confirmation.FxCoreDetailsModel;
import fpml.confirmation.FxCoreDetailsModelSequence;
import fpml.confirmation.FxTenorModel;
import fpml.confirmation.Payment;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxCoreDetailsModelValidator implements Validator<FxCoreDetailsModel> {

	private List<ComparisonResult> getComparisonResults(FxCoreDetailsModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("exchangedCurrency1", (Payment) o.getExchangedCurrency1() != null ? 1 : 0, 1, 1), 
				checkCardinality("exchangedCurrency2", (Payment) o.getExchangedCurrency2() != null ? 1 : 0, 1, 1), 
				checkCardinality("dealtCurrency", (DealtCurrencyEnum) o.getDealtCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxTenorModel", (FxTenorModel) o.getFxTenorModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("valueDate", (Date) o.getValueDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxCoreDetailsModelSequence", (FxCoreDetailsModelSequence) o.getFxCoreDetailsModelSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("exchangeRate", (ExchangeRate) o.getExchangeRate() != null ? 1 : 0, 1, 1), 
				checkCardinality("nonDeliverableSettlement", (FxCashSettlement) o.getNonDeliverableSettlement() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxCoreDetailsModel> validate(RosettaPath path, FxCoreDetailsModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxCoreDetailsModel", ValidationType.CARDINALITY, "FxCoreDetailsModel", path, "", error);
		}
		return success("FxCoreDetailsModel", ValidationType.CARDINALITY, "FxCoreDetailsModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxCoreDetailsModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxCoreDetailsModel", ValidationType.CARDINALITY, "FxCoreDetailsModel", path, "", res.getError());
				}
				return success("FxCoreDetailsModel", ValidationType.CARDINALITY, "FxCoreDetailsModel", path, "");
			})
			.collect(toList());
	}

}
