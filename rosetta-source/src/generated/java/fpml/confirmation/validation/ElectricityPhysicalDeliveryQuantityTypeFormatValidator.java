package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ElectricityPhysicalDeliveryQuantity;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ElectricityPhysicalDeliveryQuantityTypeFormatValidator implements Validator<ElectricityPhysicalDeliveryQuantity> {

	private List<ComparisonResult> getComparisonResults(ElectricityPhysicalDeliveryQuantity o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ElectricityPhysicalDeliveryQuantity> validate(RosettaPath path, ElectricityPhysicalDeliveryQuantity o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ElectricityPhysicalDeliveryQuantity", ValidationType.TYPE_FORMAT, "ElectricityPhysicalDeliveryQuantity", path, "", error);
		}
		return success("ElectricityPhysicalDeliveryQuantity", ValidationType.TYPE_FORMAT, "ElectricityPhysicalDeliveryQuantity", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ElectricityPhysicalDeliveryQuantity o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ElectricityPhysicalDeliveryQuantity", ValidationType.TYPE_FORMAT, "ElectricityPhysicalDeliveryQuantity", path, "", res.getError());
				}
				return success("ElectricityPhysicalDeliveryQuantity", ValidationType.TYPE_FORMAT, "ElectricityPhysicalDeliveryQuantity", path, "");
			})
			.collect(toList());
	}

}
