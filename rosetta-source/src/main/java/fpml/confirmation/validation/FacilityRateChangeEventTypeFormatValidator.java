package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FacilityRateChangeEvent;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FacilityRateChangeEventTypeFormatValidator implements Validator<FacilityRateChangeEvent> {

	private List<ComparisonResult> getComparisonResults(FacilityRateChangeEvent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("comment", o.getComment(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<FacilityRateChangeEvent> validate(RosettaPath path, FacilityRateChangeEvent o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FacilityRateChangeEvent", ValidationType.TYPE_FORMAT, "FacilityRateChangeEvent", path, "", error);
		}
		return success("FacilityRateChangeEvent", ValidationType.TYPE_FORMAT, "FacilityRateChangeEvent", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityRateChangeEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FacilityRateChangeEvent", ValidationType.TYPE_FORMAT, "FacilityRateChangeEvent", path, "", res.getError());
				}
				return success("FacilityRateChangeEvent", ValidationType.TYPE_FORMAT, "FacilityRateChangeEvent", path, "");
			})
			.collect(toList());
	}

}
