package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CollateralizationType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CollateralizationTypeValidator implements Validator<CollateralizationType> {

	private List<ComparisonResult> getComparisonResults(CollateralizationType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("collateralTypeScheme", (String) o.getCollateralTypeScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CollateralizationType> validate(RosettaPath path, CollateralizationType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CollateralizationType", ValidationType.CARDINALITY, "CollateralizationType", path, "", error);
		}
		return success("CollateralizationType", ValidationType.CARDINALITY, "CollateralizationType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralizationType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CollateralizationType", ValidationType.CARDINALITY, "CollateralizationType", path, "", res.getError());
				}
				return success("CollateralizationType", ValidationType.CARDINALITY, "CollateralizationType", path, "");
			})
			.collect(toList());
	}

}
