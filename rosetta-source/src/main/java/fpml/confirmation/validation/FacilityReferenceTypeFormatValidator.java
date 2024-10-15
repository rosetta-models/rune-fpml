package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FacilityReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FacilityReferenceTypeFormatValidator implements Validator<FacilityReference> {

	private List<ComparisonResult> getComparisonResults(FacilityReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FacilityReference> validate(RosettaPath path, FacilityReference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FacilityReference", ValidationType.TYPE_FORMAT, "FacilityReference", path, "", error);
		}
		return success("FacilityReference", ValidationType.TYPE_FORMAT, "FacilityReference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FacilityReference", ValidationType.TYPE_FORMAT, "FacilityReference", path, "", res.getError());
				}
				return success("FacilityReference", ValidationType.TYPE_FORMAT, "FacilityReference", path, "");
			})
			.collect(toList());
	}

}
