package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.OilTransferDelivery;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OilTransferDeliveryTypeFormatValidator implements Validator<OilTransferDelivery> {

	private List<ComparisonResult> getComparisonResults(OilTransferDelivery o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<OilTransferDelivery> validate(RosettaPath path, OilTransferDelivery o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OilTransferDelivery", ValidationType.TYPE_FORMAT, "OilTransferDelivery", path, "", error);
		}
		return success("OilTransferDelivery", ValidationType.TYPE_FORMAT, "OilTransferDelivery", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OilTransferDelivery o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OilTransferDelivery", ValidationType.TYPE_FORMAT, "OilTransferDelivery", path, "", res.getError());
				}
				return success("OilTransferDelivery", ValidationType.TYPE_FORMAT, "OilTransferDelivery", path, "");
			})
			.collect(toList());
	}

}
