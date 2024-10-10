package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AnyAssetReference;
import fpml.confirmation.PricingMethod;
import fpml.confirmation.PricingStructureReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PricingMethodValidator implements Validator<PricingMethod> {

	private List<ComparisonResult> getComparisonResults(PricingMethod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("assetReference", (AnyAssetReference) o.getAssetReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("pricingInputReference", (PricingStructureReference) o.getPricingInputReference() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<PricingMethod> validate(RosettaPath path, PricingMethod o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PricingMethod", ValidationType.CARDINALITY, "PricingMethod", path, "", error);
		}
		return success("PricingMethod", ValidationType.CARDINALITY, "PricingMethod", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PricingMethod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PricingMethod", ValidationType.CARDINALITY, "PricingMethod", path, "", res.getError());
				}
				return success("PricingMethod", ValidationType.CARDINALITY, "PricingMethod", path, "");
			})
			.collect(toList());
	}

}
