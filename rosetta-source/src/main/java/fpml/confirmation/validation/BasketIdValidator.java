package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BasketId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BasketIdValidator implements Validator<BasketId> {

	private List<ComparisonResult> getComparisonResults(BasketId o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("basketIdScheme", (String) o.getBasketIdScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<BasketId> validate(RosettaPath path, BasketId o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("BasketId", ValidationType.CARDINALITY, "BasketId", path, "", error);
		}
		return success("BasketId", ValidationType.CARDINALITY, "BasketId", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BasketId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BasketId", ValidationType.CARDINALITY, "BasketId", path, "", res.getError());
				}
				return success("BasketId", ValidationType.CARDINALITY, "BasketId", path, "");
			})
			.collect(toList());
	}

}
