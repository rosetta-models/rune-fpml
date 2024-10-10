package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.MultiDimensionalPricingData;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MultiDimensionalPricingDataTypeFormatValidator implements Validator<MultiDimensionalPricingData> {

	private List<ComparisonResult> getComparisonResults(MultiDimensionalPricingData o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<MultiDimensionalPricingData> validate(RosettaPath path, MultiDimensionalPricingData o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("MultiDimensionalPricingData", ValidationType.TYPE_FORMAT, "MultiDimensionalPricingData", path, "", error);
		}
		return success("MultiDimensionalPricingData", ValidationType.TYPE_FORMAT, "MultiDimensionalPricingData", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MultiDimensionalPricingData o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MultiDimensionalPricingData", ValidationType.TYPE_FORMAT, "MultiDimensionalPricingData", path, "", res.getError());
				}
				return success("MultiDimensionalPricingData", ValidationType.TYPE_FORMAT, "MultiDimensionalPricingData", path, "");
			})
			.collect(toList());
	}

}
