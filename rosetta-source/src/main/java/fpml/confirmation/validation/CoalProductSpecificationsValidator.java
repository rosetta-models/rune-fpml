package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CoalProductSpecifications;
import fpml.confirmation.CoalStandardQuality;
import fpml.confirmation.CoalStandardQualitySchedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CoalProductSpecificationsValidator implements Validator<CoalProductSpecifications> {

	private List<ComparisonResult> getComparisonResults(CoalProductSpecifications o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("standardQuality", (CoalStandardQuality) o.getStandardQuality() != null ? 1 : 0, 0, 1), 
				checkCardinality("standardQualitySchedule", (CoalStandardQualitySchedule) o.getStandardQualitySchedule() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CoalProductSpecifications> validate(RosettaPath path, CoalProductSpecifications o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CoalProductSpecifications", ValidationType.CARDINALITY, "CoalProductSpecifications", path, "", error);
		}
		return success("CoalProductSpecifications", ValidationType.CARDINALITY, "CoalProductSpecifications", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CoalProductSpecifications o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CoalProductSpecifications", ValidationType.CARDINALITY, "CoalProductSpecifications", path, "", res.getError());
				}
				return success("CoalProductSpecifications", ValidationType.CARDINALITY, "CoalProductSpecifications", path, "");
			})
			.collect(toList());
	}

}
