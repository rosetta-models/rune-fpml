package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BasketName;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BasketNameValidator implements Validator<BasketName> {

	private List<ComparisonResult> getComparisonResults(BasketName o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("basketNameScheme", (String) o.getBasketNameScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<BasketName> validate(RosettaPath path, BasketName o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("BasketName", ValidationType.CARDINALITY, "BasketName", path, "", error);
		}
		return success("BasketName", ValidationType.CARDINALITY, "BasketName", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BasketName o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BasketName", ValidationType.CARDINALITY, "BasketName", path, "", res.getError());
				}
				return success("BasketName", ValidationType.CARDINALITY, "BasketName", path, "");
			})
			.collect(toList());
	}

}
