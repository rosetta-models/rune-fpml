package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityCoalReducingAtmosphereModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityCoalReducingAtmosphereModelTypeFormatValidator implements Validator<CommodityCoalReducingAtmosphereModel> {

	private List<ComparisonResult> getComparisonResults(CommodityCoalReducingAtmosphereModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityCoalReducingAtmosphereModel> validate(RosettaPath path, CommodityCoalReducingAtmosphereModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityCoalReducingAtmosphereModel", ValidationType.TYPE_FORMAT, "CommodityCoalReducingAtmosphereModel", path, "", error);
		}
		return success("CommodityCoalReducingAtmosphereModel", ValidationType.TYPE_FORMAT, "CommodityCoalReducingAtmosphereModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityCoalReducingAtmosphereModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityCoalReducingAtmosphereModel", ValidationType.TYPE_FORMAT, "CommodityCoalReducingAtmosphereModel", path, "", res.getError());
				}
				return success("CommodityCoalReducingAtmosphereModel", ValidationType.TYPE_FORMAT, "CommodityCoalReducingAtmosphereModel", path, "");
			})
			.collect(toList());
	}

}
