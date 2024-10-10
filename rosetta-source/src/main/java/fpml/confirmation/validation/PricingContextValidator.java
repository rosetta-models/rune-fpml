package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PricingContext;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PricingContextValidator implements Validator<PricingContext> {

	private List<ComparisonResult> getComparisonResults(PricingContext o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("pricingContextScheme", (String) o.getPricingContextScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<PricingContext> validate(RosettaPath path, PricingContext o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PricingContext", ValidationType.CARDINALITY, "PricingContext", path, "", error);
		}
		return success("PricingContext", ValidationType.CARDINALITY, "PricingContext", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PricingContext o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PricingContext", ValidationType.CARDINALITY, "PricingContext", path, "", res.getError());
				}
				return success("PricingContext", ValidationType.CARDINALITY, "PricingContext", path, "");
			})
			.collect(toList());
	}

}
