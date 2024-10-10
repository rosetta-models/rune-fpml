package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.GasDeliverySequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class GasDeliverySequenceTypeFormatValidator implements Validator<GasDeliverySequence> {

	private List<ComparisonResult> getComparisonResults(GasDeliverySequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<GasDeliverySequence> validate(RosettaPath path, GasDeliverySequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("GasDeliverySequence", ValidationType.TYPE_FORMAT, "GasDeliverySequence", path, "", error);
		}
		return success("GasDeliverySequence", ValidationType.TYPE_FORMAT, "GasDeliverySequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GasDeliverySequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GasDeliverySequence", ValidationType.TYPE_FORMAT, "GasDeliverySequence", path, "", res.getError());
				}
				return success("GasDeliverySequence", ValidationType.TYPE_FORMAT, "GasDeliverySequence", path, "");
			})
			.collect(toList());
	}

}
