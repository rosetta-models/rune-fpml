package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ProRataFacilities;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ProRataFacilitiesTypeFormatValidator implements Validator<ProRataFacilities> {

	private List<ComparisonResult> getComparisonResults(ProRataFacilities o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ProRataFacilities> validate(RosettaPath path, ProRataFacilities o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ProRataFacilities", ValidationType.TYPE_FORMAT, "ProRataFacilities", path, "", error);
		}
		return success("ProRataFacilities", ValidationType.TYPE_FORMAT, "ProRataFacilities", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ProRataFacilities o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ProRataFacilities", ValidationType.TYPE_FORMAT, "ProRataFacilities", path, "", res.getError());
				}
				return success("ProRataFacilities", ValidationType.TYPE_FORMAT, "ProRataFacilities", path, "");
			})
			.collect(toList());
	}

}
