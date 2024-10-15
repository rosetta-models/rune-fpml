package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxOptionFeatures;
import fpml.confirmation.FxOptionFeaturesSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxOptionFeaturesValidator implements Validator<FxOptionFeatures> {

	private List<ComparisonResult> getComparisonResults(FxOptionFeatures o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fxOptionFeaturesSequence", (FxOptionFeaturesSequence) o.getFxOptionFeaturesSequence() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxOptionFeatures> validate(RosettaPath path, FxOptionFeatures o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxOptionFeatures", ValidationType.CARDINALITY, "FxOptionFeatures", path, "", error);
		}
		return success("FxOptionFeatures", ValidationType.CARDINALITY, "FxOptionFeatures", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxOptionFeatures o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxOptionFeatures", ValidationType.CARDINALITY, "FxOptionFeatures", path, "", res.getError());
				}
				return success("FxOptionFeatures", ValidationType.CARDINALITY, "FxOptionFeatures", path, "");
			})
			.collect(toList());
	}

}
