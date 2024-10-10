package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FacilityPosition;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FacilityPositionTypeFormatValidator implements Validator<FacilityPosition> {

	private List<ComparisonResult> getComparisonResults(FacilityPosition o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FacilityPosition> validate(RosettaPath path, FacilityPosition o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FacilityPosition", ValidationType.TYPE_FORMAT, "FacilityPosition", path, "", error);
		}
		return success("FacilityPosition", ValidationType.TYPE_FORMAT, "FacilityPosition", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityPosition o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FacilityPosition", ValidationType.TYPE_FORMAT, "FacilityPosition", path, "", res.getError());
				}
				return success("FacilityPosition", ValidationType.TYPE_FORMAT, "FacilityPosition", path, "");
			})
			.collect(toList());
	}

}
