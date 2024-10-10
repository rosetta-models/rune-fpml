package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PricingStructurePoint;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PricingStructurePointTypeFormatValidator implements Validator<PricingStructurePoint> {

	private List<ComparisonResult> getComparisonResults(PricingStructurePoint o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PricingStructurePoint> validate(RosettaPath path, PricingStructurePoint o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PricingStructurePoint", ValidationType.TYPE_FORMAT, "PricingStructurePoint", path, "", error);
		}
		return success("PricingStructurePoint", ValidationType.TYPE_FORMAT, "PricingStructurePoint", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PricingStructurePoint o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PricingStructurePoint", ValidationType.TYPE_FORMAT, "PricingStructurePoint", path, "", res.getError());
				}
				return success("PricingStructurePoint", ValidationType.TYPE_FORMAT, "PricingStructurePoint", path, "");
			})
			.collect(toList());
	}

}
