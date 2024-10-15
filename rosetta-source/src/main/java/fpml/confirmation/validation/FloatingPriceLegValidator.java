package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Commodity;
import fpml.confirmation.CommodityCalculationPeriodsModel;
import fpml.confirmation.CommodityFreightFlatRateModel;
import fpml.confirmation.CommodityNotionalQuantityModel;
import fpml.confirmation.CommodityPaymentDatesModel;
import fpml.confirmation.FloatingLegCalculation;
import fpml.confirmation.FloatingPriceLeg;
import fpml.confirmation.PayerReceiverModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FloatingPriceLegValidator implements Validator<FloatingPriceLeg> {

	private List<ComparisonResult> getComparisonResults(FloatingPriceLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerReceiverModel", (PayerReceiverModel) o.getPayerReceiverModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityCalculationPeriodsModel", (CommodityCalculationPeriodsModel) o.getCommodityCalculationPeriodsModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodity", (Commodity) o.getCommodity() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityNotionalQuantityModel", (CommodityNotionalQuantityModel) o.getCommodityNotionalQuantityModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("calculation", (FloatingLegCalculation) o.getCalculation() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityPaymentDatesModel", (CommodityPaymentDatesModel) o.getCommodityPaymentDatesModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityFreightFlatRateModel", (CommodityFreightFlatRateModel) o.getCommodityFreightFlatRateModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FloatingPriceLeg> validate(RosettaPath path, FloatingPriceLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FloatingPriceLeg", ValidationType.CARDINALITY, "FloatingPriceLeg", path, "", error);
		}
		return success("FloatingPriceLeg", ValidationType.CARDINALITY, "FloatingPriceLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingPriceLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingPriceLeg", ValidationType.CARDINALITY, "FloatingPriceLeg", path, "", res.getError());
				}
				return success("FloatingPriceLeg", ValidationType.CARDINALITY, "FloatingPriceLeg", path, "");
			})
			.collect(toList());
	}

}
