package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Basket;
import fpml.confirmation.SingleUnderlyer;
import fpml.confirmation.Underlyer;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class UnderlyerValidator implements Validator<Underlyer> {

	private List<ComparisonResult> getComparisonResults(Underlyer o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("singleUnderlyer", (SingleUnderlyer) o.getSingleUnderlyer() != null ? 1 : 0, 0, 1), 
				checkCardinality("basket", (Basket) o.getBasket() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<Underlyer> validate(RosettaPath path, Underlyer o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Underlyer", ValidationType.CARDINALITY, "Underlyer", path, "", error);
		}
		return success("Underlyer", ValidationType.CARDINALITY, "Underlyer", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Underlyer o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Underlyer", ValidationType.CARDINALITY, "Underlyer", path, "", res.getError());
				}
				return success("Underlyer", ValidationType.CARDINALITY, "Underlyer", path, "");
			})
			.collect(toList());
	}

}
