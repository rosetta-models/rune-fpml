package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FacilityContractIdentifier;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FacilityContractIdentifierTypeFormatValidator implements Validator<FacilityContractIdentifier> {

	private List<ComparisonResult> getComparisonResults(FacilityContractIdentifier o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FacilityContractIdentifier> validate(RosettaPath path, FacilityContractIdentifier o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FacilityContractIdentifier", ValidationType.TYPE_FORMAT, "FacilityContractIdentifier", path, "", error);
		}
		return success("FacilityContractIdentifier", ValidationType.TYPE_FORMAT, "FacilityContractIdentifier", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityContractIdentifier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FacilityContractIdentifier", ValidationType.TYPE_FORMAT, "FacilityContractIdentifier", path, "", res.getError());
				}
				return success("FacilityContractIdentifier", ValidationType.TYPE_FORMAT, "FacilityContractIdentifier", path, "");
			})
			.collect(toList());
	}

}
