package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityFixedPhysicalQuantityModel;
import fpml.confirmation.CommodityPhysicalQuantity;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityPhysicalQuantityValidator implements Validator<CommodityPhysicalQuantity> {

	private List<ComparisonResult> getComparisonResults(CommodityPhysicalQuantity o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityFixedPhysicalQuantityModel", (CommodityFixedPhysicalQuantityModel) o.getCommodityFixedPhysicalQuantityModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CommodityPhysicalQuantity> validate(RosettaPath path, CommodityPhysicalQuantity o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityPhysicalQuantity", ValidationType.CARDINALITY, "CommodityPhysicalQuantity", path, "", error);
		}
		return success("CommodityPhysicalQuantity", ValidationType.CARDINALITY, "CommodityPhysicalQuantity", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPhysicalQuantity o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityPhysicalQuantity", ValidationType.CARDINALITY, "CommodityPhysicalQuantity", path, "", res.getError());
				}
				return success("CommodityPhysicalQuantity", ValidationType.CARDINALITY, "CommodityPhysicalQuantity", path, "");
			})
			.collect(toList());
	}

}
