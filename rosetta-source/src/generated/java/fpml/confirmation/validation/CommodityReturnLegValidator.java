package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityCalculationPeriodsModel;
import fpml.confirmation.CommodityNotionalAmount;
import fpml.confirmation.CommodityNotionalAmountReference;
import fpml.confirmation.CommodityPaymentDatesModel;
import fpml.confirmation.CommodityReturnCalculation;
import fpml.confirmation.CommodityReturnLeg;
import fpml.confirmation.CommodityUnderlyerChoiceModel;
import fpml.confirmation.PayerReceiverModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityReturnLegValidator implements Validator<CommodityReturnLeg> {

	private List<ComparisonResult> getComparisonResults(CommodityReturnLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerReceiverModel", (PayerReceiverModel) o.getPayerReceiverModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityCalculationPeriodsModel", (CommodityCalculationPeriodsModel) o.getCommodityCalculationPeriodsModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityPaymentDatesModel", (CommodityPaymentDatesModel) o.getCommodityPaymentDatesModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityUnderlyerChoiceModel", (CommodityUnderlyerChoiceModel) o.getCommodityUnderlyerChoiceModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("notionalAmount", (CommodityNotionalAmount) o.getNotionalAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalAmountReference", (CommodityNotionalAmountReference) o.getNotionalAmountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityReturnCalculation", (CommodityReturnCalculation) o.getCommodityReturnCalculation() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CommodityReturnLeg> validate(RosettaPath path, CommodityReturnLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityReturnLeg", ValidationType.CARDINALITY, "CommodityReturnLeg", path, "", error);
		}
		return success("CommodityReturnLeg", ValidationType.CARDINALITY, "CommodityReturnLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityReturnLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityReturnLeg", ValidationType.CARDINALITY, "CommodityReturnLeg", path, "", res.getError());
				}
				return success("CommodityReturnLeg", ValidationType.CARDINALITY, "CommodityReturnLeg", path, "");
			})
			.collect(toList());
	}

}
