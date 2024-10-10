package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityMarketDisruption;
import fpml.confirmation.CommodityMarketDisruptionSequence;
import fpml.confirmation.DisruptionFallbacksEnum;
import fpml.confirmation.Underlyer;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityMarketDisruptionValidator implements Validator<CommodityMarketDisruption> {

	private List<ComparisonResult> getComparisonResults(CommodityMarketDisruption o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("commodityMarketDisruptionSequence", (CommodityMarketDisruptionSequence) o.getCommodityMarketDisruptionSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("disruptionFallbacks", (DisruptionFallbacksEnum) o.getDisruptionFallbacks() != null ? 1 : 0, 0, 1), 
				checkCardinality("fallbackReferencePrice", (Underlyer) o.getFallbackReferencePrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("maximumNumberOfDaysOfDisruption", (Integer) o.getMaximumNumberOfDaysOfDisruption() != null ? 1 : 0, 0, 1), 
				checkCardinality("priceMaterialityPercentage", (BigDecimal) o.getPriceMaterialityPercentage() != null ? 1 : 0, 0, 1), 
				checkCardinality("minimumFuturesContracts", (Integer) o.getMinimumFuturesContracts() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityMarketDisruption> validate(RosettaPath path, CommodityMarketDisruption o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityMarketDisruption", ValidationType.CARDINALITY, "CommodityMarketDisruption", path, "", error);
		}
		return success("CommodityMarketDisruption", ValidationType.CARDINALITY, "CommodityMarketDisruption", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityMarketDisruption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityMarketDisruption", ValidationType.CARDINALITY, "CommodityMarketDisruption", path, "", res.getError());
				}
				return success("CommodityMarketDisruption", ValidationType.CARDINALITY, "CommodityMarketDisruption", path, "");
			})
			.collect(toList());
	}

}
