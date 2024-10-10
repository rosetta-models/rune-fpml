package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityMetalBrandName;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityMetalBrandNameValidator implements Validator<CommodityMetalBrandName> {

	private List<ComparisonResult> getComparisonResults(CommodityMetalBrandName o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityMetalBrandNameScheme", (String) o.getCommodityMetalBrandNameScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityMetalBrandName> validate(RosettaPath path, CommodityMetalBrandName o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityMetalBrandName", ValidationType.CARDINALITY, "CommodityMetalBrandName", path, "", error);
		}
		return success("CommodityMetalBrandName", ValidationType.CARDINALITY, "CommodityMetalBrandName", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityMetalBrandName o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityMetalBrandName", ValidationType.CARDINALITY, "CommodityMetalBrandName", path, "", res.getError());
				}
				return success("CommodityMetalBrandName", ValidationType.CARDINALITY, "CommodityMetalBrandName", path, "");
			})
			.collect(toList());
	}

}
