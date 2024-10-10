package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AccrualOptionChangeNotificationSequence0;
import fpml.confirmation.FixedRateOptionChange;
import fpml.confirmation.FloatingRateOptionChange;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AccrualOptionChangeNotificationSequence0Validator implements Validator<AccrualOptionChangeNotificationSequence0> {

	private List<ComparisonResult> getComparisonResults(AccrualOptionChangeNotificationSequence0 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fixedRateOptionChange", (FixedRateOptionChange) o.getFixedRateOptionChange() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRateOptionChange", (FloatingRateOptionChange) o.getFloatingRateOptionChange() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<AccrualOptionChangeNotificationSequence0> validate(RosettaPath path, AccrualOptionChangeNotificationSequence0 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AccrualOptionChangeNotificationSequence0", ValidationType.CARDINALITY, "AccrualOptionChangeNotificationSequence0", path, "", error);
		}
		return success("AccrualOptionChangeNotificationSequence0", ValidationType.CARDINALITY, "AccrualOptionChangeNotificationSequence0", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AccrualOptionChangeNotificationSequence0 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AccrualOptionChangeNotificationSequence0", ValidationType.CARDINALITY, "AccrualOptionChangeNotificationSequence0", path, "", res.getError());
				}
				return success("AccrualOptionChangeNotificationSequence0", ValidationType.CARDINALITY, "AccrualOptionChangeNotificationSequence0", path, "");
			})
			.collect(toList());
	}

}
