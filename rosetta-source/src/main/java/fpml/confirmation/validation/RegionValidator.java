package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Region;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RegionValidator implements Validator<Region> {

	private List<ComparisonResult> getComparisonResults(Region o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("regionScheme", (String) o.getRegionScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<Region> validate(RosettaPath path, Region o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Region", ValidationType.CARDINALITY, "Region", path, "", error);
		}
		return success("Region", ValidationType.CARDINALITY, "Region", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Region o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Region", ValidationType.CARDINALITY, "Region", path, "", res.getError());
				}
				return success("Region", ValidationType.CARDINALITY, "Region", path, "");
			})
			.collect(toList());
	}

}
