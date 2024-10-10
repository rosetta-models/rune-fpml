package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CoalAttributeDecimal;
import fpml.confirmation.CommodityCoalPropertiesModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityCoalPropertiesModelValidator implements Validator<CommodityCoalPropertiesModel> {

	private List<ComparisonResult> getComparisonResults(CommodityCoalPropertiesModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("btUperLB", (CoalAttributeDecimal) o.getBtUperLB() != null ? 1 : 0, 0, 1), 
				checkCardinality("topSize", (CoalAttributeDecimal) o.getTopSize() != null ? 1 : 0, 0, 1), 
				checkCardinality("finesPassingScreen", (CoalAttributeDecimal) o.getFinesPassingScreen() != null ? 1 : 0, 0, 1), 
				checkCardinality("grindability", (CoalAttributeDecimal) o.getGrindability() != null ? 1 : 0, 0, 1), 
				checkCardinality("ashFusionTemperature", (CoalAttributeDecimal) o.getAshFusionTemperature() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityCoalPropertiesModel> validate(RosettaPath path, CommodityCoalPropertiesModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityCoalPropertiesModel", ValidationType.CARDINALITY, "CommodityCoalPropertiesModel", path, "", error);
		}
		return success("CommodityCoalPropertiesModel", ValidationType.CARDINALITY, "CommodityCoalPropertiesModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityCoalPropertiesModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityCoalPropertiesModel", ValidationType.CARDINALITY, "CommodityCoalPropertiesModel", path, "", res.getError());
				}
				return success("CommodityCoalPropertiesModel", ValidationType.CARDINALITY, "CommodityCoalPropertiesModel", path, "");
			})
			.collect(toList());
	}

}
