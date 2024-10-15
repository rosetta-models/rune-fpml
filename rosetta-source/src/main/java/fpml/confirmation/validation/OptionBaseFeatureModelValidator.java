package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxFeature;
import fpml.confirmation.OptionBaseFeatureModel;
import fpml.confirmation.StrategyFeature;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OptionBaseFeatureModelValidator implements Validator<OptionBaseFeatureModel> {

	private List<ComparisonResult> getComparisonResults(OptionBaseFeatureModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fxFeature", (FxFeature) o.getFxFeature() != null ? 1 : 0, 0, 1), 
				checkCardinality("strategyFeature", (StrategyFeature) o.getStrategyFeature() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<OptionBaseFeatureModel> validate(RosettaPath path, OptionBaseFeatureModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OptionBaseFeatureModel", ValidationType.CARDINALITY, "OptionBaseFeatureModel", path, "", error);
		}
		return success("OptionBaseFeatureModel", ValidationType.CARDINALITY, "OptionBaseFeatureModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionBaseFeatureModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionBaseFeatureModel", ValidationType.CARDINALITY, "OptionBaseFeatureModel", path, "", res.getError());
				}
				return success("OptionBaseFeatureModel", ValidationType.CARDINALITY, "OptionBaseFeatureModel", path, "");
			})
			.collect(toList());
	}

}
