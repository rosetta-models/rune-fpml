package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.GasDeliveryPeriodsSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class GasDeliveryPeriodsSequenceTypeFormatValidator implements Validator<GasDeliveryPeriodsSequence> {

	private List<ComparisonResult> getComparisonResults(GasDeliveryPeriodsSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<GasDeliveryPeriodsSequence> validate(RosettaPath path, GasDeliveryPeriodsSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("GasDeliveryPeriodsSequence", ValidationType.TYPE_FORMAT, "GasDeliveryPeriodsSequence", path, "", error);
		}
		return success("GasDeliveryPeriodsSequence", ValidationType.TYPE_FORMAT, "GasDeliveryPeriodsSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GasDeliveryPeriodsSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GasDeliveryPeriodsSequence", ValidationType.TYPE_FORMAT, "GasDeliveryPeriodsSequence", path, "", res.getError());
				}
				return success("GasDeliveryPeriodsSequence", ValidationType.TYPE_FORMAT, "GasDeliveryPeriodsSequence", path, "");
			})
			.collect(toList());
	}

}
