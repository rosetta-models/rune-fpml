package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AnyAssetReference;
import fpml.confirmation.Currency;
import fpml.confirmation.VolatilityRepresentation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class VolatilityRepresentationValidator implements Validator<VolatilityRepresentation> {

	private List<ComparisonResult> getComparisonResults(VolatilityRepresentation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("name", (String) o.getName() != null ? 1 : 0, 0, 1), 
				checkCardinality("currency", (Currency) o.getCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("asset", (AnyAssetReference) o.getAsset() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<VolatilityRepresentation> validate(RosettaPath path, VolatilityRepresentation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("VolatilityRepresentation", ValidationType.CARDINALITY, "VolatilityRepresentation", path, "", error);
		}
		return success("VolatilityRepresentation", ValidationType.CARDINALITY, "VolatilityRepresentation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VolatilityRepresentation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VolatilityRepresentation", ValidationType.CARDINALITY, "VolatilityRepresentation", path, "", res.getError());
				}
				return success("VolatilityRepresentation", ValidationType.CARDINALITY, "VolatilityRepresentation", path, "");
			})
			.collect(toList());
	}

}
