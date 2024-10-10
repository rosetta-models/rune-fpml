package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FacilityEventGroup;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FacilityEventGroupTypeFormatValidator implements Validator<FacilityEventGroup> {

	private List<ComparisonResult> getComparisonResults(FacilityEventGroup o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("comment", o.getComment(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<FacilityEventGroup> validate(RosettaPath path, FacilityEventGroup o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FacilityEventGroup", ValidationType.TYPE_FORMAT, "FacilityEventGroup", path, "", error);
		}
		return success("FacilityEventGroup", ValidationType.TYPE_FORMAT, "FacilityEventGroup", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityEventGroup o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FacilityEventGroup", ValidationType.TYPE_FORMAT, "FacilityEventGroup", path, "", res.getError());
				}
				return success("FacilityEventGroup", ValidationType.TYPE_FORMAT, "FacilityEventGroup", path, "");
			})
			.collect(toList());
	}

}
