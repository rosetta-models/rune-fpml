package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PricingDataPointCoordinate;
import fpml.confirmation.PricingStructureIndexModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PricingDataPointCoordinateValidator implements Validator<PricingDataPointCoordinate> {

	private List<ComparisonResult> getComparisonResults(PricingDataPointCoordinate o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("pricingStructureIndexModel", (List<? extends PricingStructureIndexModel>) o.getPricingStructureIndexModel() == null ? 0 : ((List<? extends PricingStructureIndexModel>) o.getPricingStructureIndexModel()).size(), 1, 0), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<PricingDataPointCoordinate> validate(RosettaPath path, PricingDataPointCoordinate o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PricingDataPointCoordinate", ValidationType.CARDINALITY, "PricingDataPointCoordinate", path, "", error);
		}
		return success("PricingDataPointCoordinate", ValidationType.CARDINALITY, "PricingDataPointCoordinate", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PricingDataPointCoordinate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PricingDataPointCoordinate", ValidationType.CARDINALITY, "PricingDataPointCoordinate", path, "", res.getError());
				}
				return success("PricingDataPointCoordinate", ValidationType.CARDINALITY, "PricingDataPointCoordinate", path, "");
			})
			.collect(toList());
	}

}
