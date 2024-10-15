package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CompoundingRate;
import fpml.confirmation.FloatingRateCalculationReference;
import fpml.confirmation.InterestAccrualsMethod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CompoundingRateValidator implements Validator<CompoundingRate> {

	private List<ComparisonResult> getComparisonResults(CompoundingRate o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("interestLegRate", (FloatingRateCalculationReference) o.getInterestLegRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("specificRate", (InterestAccrualsMethod) o.getSpecificRate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CompoundingRate> validate(RosettaPath path, CompoundingRate o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CompoundingRate", ValidationType.CARDINALITY, "CompoundingRate", path, "", error);
		}
		return success("CompoundingRate", ValidationType.CARDINALITY, "CompoundingRate", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CompoundingRate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CompoundingRate", ValidationType.CARDINALITY, "CompoundingRate", path, "", res.getError());
				}
				return success("CompoundingRate", ValidationType.CARDINALITY, "CompoundingRate", path, "");
			})
			.collect(toList());
	}

}
