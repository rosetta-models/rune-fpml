package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CollateralProfile;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CollateralProfileValidator implements Validator<CollateralProfile> {

	private List<ComparisonResult> getComparisonResults(CollateralProfile o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("collateralProfileScheme", (String) o.getCollateralProfileScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CollateralProfile> validate(RosettaPath path, CollateralProfile o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CollateralProfile", ValidationType.CARDINALITY, "CollateralProfile", path, "", error);
		}
		return success("CollateralProfile", ValidationType.CARDINALITY, "CollateralProfile", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralProfile o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CollateralProfile", ValidationType.CARDINALITY, "CollateralProfile", path, "", res.getError());
				}
				return success("CollateralProfile", ValidationType.CARDINALITY, "CollateralProfile", path, "");
			})
			.collect(toList());
	}

}
