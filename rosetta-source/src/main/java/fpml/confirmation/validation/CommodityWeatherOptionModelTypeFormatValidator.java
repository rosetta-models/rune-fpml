package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityWeatherOptionModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityWeatherOptionModelTypeFormatValidator implements Validator<CommodityWeatherOptionModel> {

	private List<ComparisonResult> getComparisonResults(CommodityWeatherOptionModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityWeatherOptionModel> validate(RosettaPath path, CommodityWeatherOptionModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityWeatherOptionModel", ValidationType.TYPE_FORMAT, "CommodityWeatherOptionModel", path, "", error);
		}
		return success("CommodityWeatherOptionModel", ValidationType.TYPE_FORMAT, "CommodityWeatherOptionModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityWeatherOptionModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityWeatherOptionModel", ValidationType.TYPE_FORMAT, "CommodityWeatherOptionModel", path, "", res.getError());
				}
				return success("CommodityWeatherOptionModel", ValidationType.TYPE_FORMAT, "CommodityWeatherOptionModel", path, "");
			})
			.collect(toList());
	}

}
