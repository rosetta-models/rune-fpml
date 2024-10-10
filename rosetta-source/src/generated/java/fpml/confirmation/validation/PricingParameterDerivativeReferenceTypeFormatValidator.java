package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PricingParameterDerivativeReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PricingParameterDerivativeReferenceTypeFormatValidator implements Validator<PricingParameterDerivativeReference> {

	private List<ComparisonResult> getComparisonResults(PricingParameterDerivativeReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PricingParameterDerivativeReference> validate(RosettaPath path, PricingParameterDerivativeReference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PricingParameterDerivativeReference", ValidationType.TYPE_FORMAT, "PricingParameterDerivativeReference", path, "", error);
		}
		return success("PricingParameterDerivativeReference", ValidationType.TYPE_FORMAT, "PricingParameterDerivativeReference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PricingParameterDerivativeReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PricingParameterDerivativeReference", ValidationType.TYPE_FORMAT, "PricingParameterDerivativeReference", path, "", res.getError());
				}
				return success("PricingParameterDerivativeReference", ValidationType.TYPE_FORMAT, "PricingParameterDerivativeReference", path, "");
			})
			.collect(toList());
	}

}
