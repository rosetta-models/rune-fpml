package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CoalStandardQuality;
import fpml.confirmation.CommodityCoalCompositionModel;
import fpml.confirmation.CommodityCoalPropertiesModel;
import fpml.confirmation.CommodityCoalReducingAtmosphereModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CoalStandardQualityValidator implements Validator<CoalStandardQuality> {

	private List<ComparisonResult> getComparisonResults(CoalStandardQuality o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("commodityCoalCompositionModel", (CommodityCoalCompositionModel) o.getCommodityCoalCompositionModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityCoalPropertiesModel", (CommodityCoalPropertiesModel) o.getCommodityCoalPropertiesModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityCoalReducingAtmosphereModel", (CommodityCoalReducingAtmosphereModel) o.getCommodityCoalReducingAtmosphereModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CoalStandardQuality> validate(RosettaPath path, CoalStandardQuality o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CoalStandardQuality", ValidationType.CARDINALITY, "CoalStandardQuality", path, "", error);
		}
		return success("CoalStandardQuality", ValidationType.CARDINALITY, "CoalStandardQuality", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CoalStandardQuality o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CoalStandardQuality", ValidationType.CARDINALITY, "CoalStandardQuality", path, "", res.getError());
				}
				return success("CoalStandardQuality", ValidationType.CARDINALITY, "CoalStandardQuality", path, "");
			})
			.collect(toList());
	}

}
