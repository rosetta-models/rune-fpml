package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CoalAttributePercentage;
import fpml.confirmation.CommodityCoalCompositionModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityCoalCompositionModelValidator implements Validator<CommodityCoalCompositionModel> {

	private List<ComparisonResult> getComparisonResults(CommodityCoalCompositionModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("moisture", (CoalAttributePercentage) o.getMoisture() != null ? 1 : 0, 0, 1), 
				checkCardinality("ash", (CoalAttributePercentage) o.getAsh() != null ? 1 : 0, 0, 1), 
				checkCardinality("sulfur", (CoalAttributePercentage) o.getSulfur() != null ? 1 : 0, 0, 1), 
				checkCardinality("sO2", (CoalAttributePercentage) o.getSO2() != null ? 1 : 0, 0, 1), 
				checkCardinality("volatile", (CoalAttributePercentage) o.getVolatile() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityCoalCompositionModel> validate(RosettaPath path, CommodityCoalCompositionModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityCoalCompositionModel", ValidationType.CARDINALITY, "CommodityCoalCompositionModel", path, "", error);
		}
		return success("CommodityCoalCompositionModel", ValidationType.CARDINALITY, "CommodityCoalCompositionModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityCoalCompositionModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityCoalCompositionModel", ValidationType.CARDINALITY, "CommodityCoalCompositionModel", path, "", res.getError());
				}
				return success("CommodityCoalCompositionModel", ValidationType.CARDINALITY, "CommodityCoalCompositionModel", path, "");
			})
			.collect(toList());
	}

}
