package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.StrikePriceBasketReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class StrikePriceBasketReferenceValidator implements Validator<StrikePriceBasketReference> {

	private List<ComparisonResult> getComparisonResults(StrikePriceBasketReference o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("href", (String) o.getHref() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<StrikePriceBasketReference> validate(RosettaPath path, StrikePriceBasketReference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("StrikePriceBasketReference", ValidationType.CARDINALITY, "StrikePriceBasketReference", path, "", error);
		}
		return success("StrikePriceBasketReference", ValidationType.CARDINALITY, "StrikePriceBasketReference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, StrikePriceBasketReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("StrikePriceBasketReference", ValidationType.CARDINALITY, "StrikePriceBasketReference", path, "", res.getError());
				}
				return success("StrikePriceBasketReference", ValidationType.CARDINALITY, "StrikePriceBasketReference", path, "");
			})
			.collect(toList());
	}

}
