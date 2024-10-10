package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityMetalBrandManager;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityMetalBrandManagerValidator implements Validator<CommodityMetalBrandManager> {

	private List<ComparisonResult> getComparisonResults(CommodityMetalBrandManager o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityMetalBrandManagerScheme", (String) o.getCommodityMetalBrandManagerScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityMetalBrandManager> validate(RosettaPath path, CommodityMetalBrandManager o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityMetalBrandManager", ValidationType.CARDINALITY, "CommodityMetalBrandManager", path, "", error);
		}
		return success("CommodityMetalBrandManager", ValidationType.CARDINALITY, "CommodityMetalBrandManager", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityMetalBrandManager o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityMetalBrandManager", ValidationType.CARDINALITY, "CommodityMetalBrandManager", path, "", res.getError());
				}
				return success("CommodityMetalBrandManager", ValidationType.CARDINALITY, "CommodityMetalBrandManager", path, "");
			})
			.collect(toList());
	}

}
