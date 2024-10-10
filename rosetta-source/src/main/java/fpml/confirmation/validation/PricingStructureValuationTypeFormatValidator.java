package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PricingStructureValuation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PricingStructureValuationTypeFormatValidator implements Validator<PricingStructureValuation> {

	private List<ComparisonResult> getComparisonResults(PricingStructureValuation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PricingStructureValuation> validate(RosettaPath path, PricingStructureValuation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PricingStructureValuation", ValidationType.TYPE_FORMAT, "PricingStructureValuation", path, "", error);
		}
		return success("PricingStructureValuation", ValidationType.TYPE_FORMAT, "PricingStructureValuation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PricingStructureValuation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PricingStructureValuation", ValidationType.TYPE_FORMAT, "PricingStructureValuation", path, "", res.getError());
				}
				return success("PricingStructureValuation", ValidationType.TYPE_FORMAT, "PricingStructureValuation", path, "");
			})
			.collect(toList());
	}

}
