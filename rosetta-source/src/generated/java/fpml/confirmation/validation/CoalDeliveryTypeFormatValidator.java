package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CoalDelivery;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CoalDeliveryTypeFormatValidator implements Validator<CoalDelivery> {

	private List<ComparisonResult> getComparisonResults(CoalDelivery o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CoalDelivery> validate(RosettaPath path, CoalDelivery o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CoalDelivery", ValidationType.TYPE_FORMAT, "CoalDelivery", path, "", error);
		}
		return success("CoalDelivery", ValidationType.TYPE_FORMAT, "CoalDelivery", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CoalDelivery o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CoalDelivery", ValidationType.TYPE_FORMAT, "CoalDelivery", path, "", res.getError());
				}
				return success("CoalDelivery", ValidationType.TYPE_FORMAT, "CoalDelivery", path, "");
			})
			.collect(toList());
	}

}
