package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityCalculationPeriodsModel;
import fpml.confirmation.CommodityFixedPriceModel;
import fpml.confirmation.CommodityFreightFlatRateModel;
import fpml.confirmation.CommodityNotionalQuantityModel;
import fpml.confirmation.CommodityPaymentDatesModel;
import fpml.confirmation.FixedPriceLeg;
import fpml.confirmation.PayerReceiverModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FixedPriceLegValidator implements Validator<FixedPriceLeg> {

	private List<ComparisonResult> getComparisonResults(FixedPriceLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerReceiverModel", (PayerReceiverModel) o.getPayerReceiverModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityCalculationPeriodsModel", (CommodityCalculationPeriodsModel) o.getCommodityCalculationPeriodsModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityFixedPriceModel", (CommodityFixedPriceModel) o.getCommodityFixedPriceModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityNotionalQuantityModel", (CommodityNotionalQuantityModel) o.getCommodityNotionalQuantityModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityPaymentDatesModel", (CommodityPaymentDatesModel) o.getCommodityPaymentDatesModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityFreightFlatRateModel", (CommodityFreightFlatRateModel) o.getCommodityFreightFlatRateModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FixedPriceLeg> validate(RosettaPath path, FixedPriceLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FixedPriceLeg", ValidationType.CARDINALITY, "FixedPriceLeg", path, "", error);
		}
		return success("FixedPriceLeg", ValidationType.CARDINALITY, "FixedPriceLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FixedPriceLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FixedPriceLeg", ValidationType.CARDINALITY, "FixedPriceLeg", path, "", res.getError());
				}
				return success("FixedPriceLeg", ValidationType.CARDINALITY, "FixedPriceLeg", path, "");
			})
			.collect(toList());
	}

}
