package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableDate;
import fpml.confirmation.AveragePriceLeg;
import fpml.confirmation.Commodity;
import fpml.confirmation.CommodityCalculationPeriodsModel;
import fpml.confirmation.CommodityPaymentDatesModel;
import fpml.confirmation.FloatingLegCalculation;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.QuantityReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AveragePriceLegValidator implements Validator<AveragePriceLeg> {

	private List<ComparisonResult> getComparisonResults(AveragePriceLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerReceiverModel", (PayerReceiverModel) o.getPayerReceiverModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityCalculationPeriodsModel", (CommodityCalculationPeriodsModel) o.getCommodityCalculationPeriodsModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodity", (Commodity) o.getCommodity() != null ? 1 : 0, 1, 1), 
				checkCardinality("quantityReference", (QuantityReference) o.getQuantityReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("pricingStartDate", (AdjustableDate) o.getPricingStartDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("calculation", (FloatingLegCalculation) o.getCalculation() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityPaymentDatesModel", (CommodityPaymentDatesModel) o.getCommodityPaymentDatesModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<AveragePriceLeg> validate(RosettaPath path, AveragePriceLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AveragePriceLeg", ValidationType.CARDINALITY, "AveragePriceLeg", path, "", error);
		}
		return success("AveragePriceLeg", ValidationType.CARDINALITY, "AveragePriceLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AveragePriceLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AveragePriceLeg", ValidationType.CARDINALITY, "AveragePriceLeg", path, "", res.getError());
				}
				return success("AveragePriceLeg", ValidationType.CARDINALITY, "AveragePriceLeg", path, "");
			})
			.collect(toList());
	}

}
