package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EnvironmentalTrackingSystem;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EnvironmentalTrackingSystemValidator implements Validator<EnvironmentalTrackingSystem> {

	private List<ComparisonResult> getComparisonResults(EnvironmentalTrackingSystem o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityEnvironmentalTrackingSystemScheme", (String) o.getCommodityEnvironmentalTrackingSystemScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<EnvironmentalTrackingSystem> validate(RosettaPath path, EnvironmentalTrackingSystem o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EnvironmentalTrackingSystem", ValidationType.CARDINALITY, "EnvironmentalTrackingSystem", path, "", error);
		}
		return success("EnvironmentalTrackingSystem", ValidationType.CARDINALITY, "EnvironmentalTrackingSystem", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EnvironmentalTrackingSystem o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EnvironmentalTrackingSystem", ValidationType.CARDINALITY, "EnvironmentalTrackingSystem", path, "", res.getError());
				}
				return success("EnvironmentalTrackingSystem", ValidationType.CARDINALITY, "EnvironmentalTrackingSystem", path, "");
			})
			.collect(toList());
	}

}
