package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ElectricityDelivery;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ElectricityDeliveryTypeFormatValidator implements Validator<ElectricityDelivery> {

	private List<ComparisonResult> getComparisonResults(ElectricityDelivery o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ElectricityDelivery> validate(RosettaPath path, ElectricityDelivery o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ElectricityDelivery", ValidationType.TYPE_FORMAT, "ElectricityDelivery", path, "", error);
		}
		return success("ElectricityDelivery", ValidationType.TYPE_FORMAT, "ElectricityDelivery", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ElectricityDelivery o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ElectricityDelivery", ValidationType.TYPE_FORMAT, "ElectricityDelivery", path, "", res.getError());
				}
				return success("ElectricityDelivery", ValidationType.TYPE_FORMAT, "ElectricityDelivery", path, "");
			})
			.collect(toList());
	}

}
