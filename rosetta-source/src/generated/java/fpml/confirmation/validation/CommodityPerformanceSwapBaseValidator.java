package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.CommodityContentModel;
import fpml.confirmation.CommodityPerformanceSwapBase;
import fpml.confirmation.CommodityPerformanceSwapLeg;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.ProductModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityPerformanceSwapBaseValidator implements Validator<CommodityPerformanceSwapBase> {

	private List<ComparisonResult> getComparisonResults(CommodityPerformanceSwapBase o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("effectiveDate", (AdjustableOrRelativeDate) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("terminationDate", (AdjustableOrRelativeDate) o.getTerminationDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementCurrency", (IdentifiedCurrency) o.getSettlementCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityPerformanceSwapLeg", (List<? extends CommodityPerformanceSwapLeg>) o.getCommodityPerformanceSwapLeg() == null ? 0 : ((List<? extends CommodityPerformanceSwapLeg>) o.getCommodityPerformanceSwapLeg()).size(), 1, 2), 
				checkCardinality("commodityContentModel", (CommodityContentModel) o.getCommodityContentModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityPerformanceSwapBase> validate(RosettaPath path, CommodityPerformanceSwapBase o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityPerformanceSwapBase", ValidationType.CARDINALITY, "CommodityPerformanceSwapBase", path, "", error);
		}
		return success("CommodityPerformanceSwapBase", ValidationType.CARDINALITY, "CommodityPerformanceSwapBase", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPerformanceSwapBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityPerformanceSwapBase", ValidationType.CARDINALITY, "CommodityPerformanceSwapBase", path, "", res.getError());
				}
				return success("CommodityPerformanceSwapBase", ValidationType.CARDINALITY, "CommodityPerformanceSwapBase", path, "");
			})
			.collect(toList());
	}

}
