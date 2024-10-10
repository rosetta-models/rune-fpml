package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.GasQuality;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class GasQualityValidator implements Validator<GasQuality> {

	private List<ComparisonResult> getComparisonResults(GasQuality o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("gasQualityScheme", (String) o.getGasQualityScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<GasQuality> validate(RosettaPath path, GasQuality o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("GasQuality", ValidationType.CARDINALITY, "GasQuality", path, "", error);
		}
		return success("GasQuality", ValidationType.CARDINALITY, "GasQuality", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GasQuality o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GasQuality", ValidationType.CARDINALITY, "GasQuality", path, "", res.getError());
				}
				return success("GasQuality", ValidationType.CARDINALITY, "GasQuality", path, "");
			})
			.collect(toList());
	}

}
