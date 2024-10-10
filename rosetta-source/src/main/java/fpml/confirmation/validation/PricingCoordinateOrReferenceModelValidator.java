package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PricingCoordinateOrReferenceModel;
import fpml.confirmation.PricingDataPointCoordinate;
import fpml.confirmation.PricingDataPointCoordinateReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PricingCoordinateOrReferenceModelValidator implements Validator<PricingCoordinateOrReferenceModel> {

	private List<ComparisonResult> getComparisonResults(PricingCoordinateOrReferenceModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("coordinate", (PricingDataPointCoordinate) o.getCoordinate() != null ? 1 : 0, 0, 1), 
				checkCardinality("coordinateReference", (PricingDataPointCoordinateReference) o.getCoordinateReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<PricingCoordinateOrReferenceModel> validate(RosettaPath path, PricingCoordinateOrReferenceModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PricingCoordinateOrReferenceModel", ValidationType.CARDINALITY, "PricingCoordinateOrReferenceModel", path, "", error);
		}
		return success("PricingCoordinateOrReferenceModel", ValidationType.CARDINALITY, "PricingCoordinateOrReferenceModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PricingCoordinateOrReferenceModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PricingCoordinateOrReferenceModel", ValidationType.CARDINALITY, "PricingCoordinateOrReferenceModel", path, "", res.getError());
				}
				return success("PricingCoordinateOrReferenceModel", ValidationType.CARDINALITY, "PricingCoordinateOrReferenceModel", path, "");
			})
			.collect(toList());
	}

}
