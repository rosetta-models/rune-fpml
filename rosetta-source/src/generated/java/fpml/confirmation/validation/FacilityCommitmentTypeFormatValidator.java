package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FacilityCommitment;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FacilityCommitmentTypeFormatValidator implements Validator<FacilityCommitment> {

	private List<ComparisonResult> getComparisonResults(FacilityCommitment o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FacilityCommitment> validate(RosettaPath path, FacilityCommitment o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FacilityCommitment", ValidationType.TYPE_FORMAT, "FacilityCommitment", path, "", error);
		}
		return success("FacilityCommitment", ValidationType.TYPE_FORMAT, "FacilityCommitment", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityCommitment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FacilityCommitment", ValidationType.TYPE_FORMAT, "FacilityCommitment", path, "", res.getError());
				}
				return success("FacilityCommitment", ValidationType.TYPE_FORMAT, "FacilityCommitment", path, "");
			})
			.collect(toList());
	}

}
