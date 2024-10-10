package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PricingDataPointCoordinateReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PricingDataPointCoordinateReferenceValidator implements Validator<PricingDataPointCoordinateReference> {

	private List<ComparisonResult> getComparisonResults(PricingDataPointCoordinateReference o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("href", (String) o.getHref() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<PricingDataPointCoordinateReference> validate(RosettaPath path, PricingDataPointCoordinateReference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PricingDataPointCoordinateReference", ValidationType.CARDINALITY, "PricingDataPointCoordinateReference", path, "", error);
		}
		return success("PricingDataPointCoordinateReference", ValidationType.CARDINALITY, "PricingDataPointCoordinateReference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PricingDataPointCoordinateReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PricingDataPointCoordinateReference", ValidationType.CARDINALITY, "PricingDataPointCoordinateReference", path, "", res.getError());
				}
				return success("PricingDataPointCoordinateReference", ValidationType.CARDINALITY, "PricingDataPointCoordinateReference", path, "");
			})
			.collect(toList());
	}

}
