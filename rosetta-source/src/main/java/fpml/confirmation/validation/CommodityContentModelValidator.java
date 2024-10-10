package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityBullionSettlementDisruptionEnum;
import fpml.confirmation.CommodityContentModel;
import fpml.confirmation.CommodityMarketDisruption;
import fpml.confirmation.Rounding;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityContentModelValidator implements Validator<CommodityContentModel> {

	private List<ComparisonResult> getComparisonResults(CommodityContentModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("commonPricing", (Boolean) o.getCommonPricing() != null ? 1 : 0, 0, 1), 
				checkCardinality("marketDisruption", (CommodityMarketDisruption) o.getMarketDisruption() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementDisruption", (CommodityBullionSettlementDisruptionEnum) o.getSettlementDisruption() != null ? 1 : 0, 0, 1), 
				checkCardinality("rounding", (Rounding) o.getRounding() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityContentModel> validate(RosettaPath path, CommodityContentModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityContentModel", ValidationType.CARDINALITY, "CommodityContentModel", path, "", error);
		}
		return success("CommodityContentModel", ValidationType.CARDINALITY, "CommodityContentModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityContentModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityContentModel", ValidationType.CARDINALITY, "CommodityContentModel", path, "", res.getError());
				}
				return success("CommodityContentModel", ValidationType.CARDINALITY, "CommodityContentModel", path, "");
			})
			.collect(toList());
	}

}
