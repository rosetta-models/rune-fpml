package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AccrualOptionChangeNotificationSequence1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AccrualOptionChangeNotificationSequence1TypeFormatValidator implements Validator<AccrualOptionChangeNotificationSequence1> {

	private List<ComparisonResult> getComparisonResults(AccrualOptionChangeNotificationSequence1 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<AccrualOptionChangeNotificationSequence1> validate(RosettaPath path, AccrualOptionChangeNotificationSequence1 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AccrualOptionChangeNotificationSequence1", ValidationType.TYPE_FORMAT, "AccrualOptionChangeNotificationSequence1", path, "", error);
		}
		return success("AccrualOptionChangeNotificationSequence1", ValidationType.TYPE_FORMAT, "AccrualOptionChangeNotificationSequence1", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AccrualOptionChangeNotificationSequence1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AccrualOptionChangeNotificationSequence1", ValidationType.TYPE_FORMAT, "AccrualOptionChangeNotificationSequence1", path, "", res.getError());
				}
				return success("AccrualOptionChangeNotificationSequence1", ValidationType.TYPE_FORMAT, "AccrualOptionChangeNotificationSequence1", path, "");
			})
			.collect(toList());
	}

}
