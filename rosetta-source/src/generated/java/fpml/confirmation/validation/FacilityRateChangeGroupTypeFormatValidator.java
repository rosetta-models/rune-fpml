package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FacilityRateChangeGroup;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FacilityRateChangeGroupTypeFormatValidator implements Validator<FacilityRateChangeGroup> {

	private List<ComparisonResult> getComparisonResults(FacilityRateChangeGroup o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("comment", o.getComment(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<FacilityRateChangeGroup> validate(RosettaPath path, FacilityRateChangeGroup o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FacilityRateChangeGroup", ValidationType.TYPE_FORMAT, "FacilityRateChangeGroup", path, "", error);
		}
		return success("FacilityRateChangeGroup", ValidationType.TYPE_FORMAT, "FacilityRateChangeGroup", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityRateChangeGroup o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FacilityRateChangeGroup", ValidationType.TYPE_FORMAT, "FacilityRateChangeGroup", path, "", res.getError());
				}
				return success("FacilityRateChangeGroup", ValidationType.TYPE_FORMAT, "FacilityRateChangeGroup", path, "");
			})
			.collect(toList());
	}

}
