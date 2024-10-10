package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.GenericDimension;
import fpml.confirmation.PricingStructureIndexModel;
import fpml.confirmation.TimeDimension;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PricingStructureIndexModelValidator implements Validator<PricingStructureIndexModel> {

	private List<ComparisonResult> getComparisonResults(PricingStructureIndexModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("term", (TimeDimension) o.getTerm() != null ? 1 : 0, 0, 1), 
				checkCardinality("expiration", (TimeDimension) o.getExpiration() != null ? 1 : 0, 0, 1), 
				checkCardinality("strike", (BigDecimal) o.getStrike() != null ? 1 : 0, 0, 1), 
				checkCardinality("generic", (GenericDimension) o.getGeneric() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<PricingStructureIndexModel> validate(RosettaPath path, PricingStructureIndexModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PricingStructureIndexModel", ValidationType.CARDINALITY, "PricingStructureIndexModel", path, "", error);
		}
		return success("PricingStructureIndexModel", ValidationType.CARDINALITY, "PricingStructureIndexModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PricingStructureIndexModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PricingStructureIndexModel", ValidationType.CARDINALITY, "PricingStructureIndexModel", path, "", res.getError());
				}
				return success("PricingStructureIndexModel", ValidationType.CARDINALITY, "PricingStructureIndexModel", path, "");
			})
			.collect(toList());
	}

}
