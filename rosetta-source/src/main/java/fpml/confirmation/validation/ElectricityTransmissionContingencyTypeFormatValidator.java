package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ElectricityTransmissionContingency;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ElectricityTransmissionContingencyTypeFormatValidator implements Validator<ElectricityTransmissionContingency> {

	private List<ComparisonResult> getComparisonResults(ElectricityTransmissionContingency o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ElectricityTransmissionContingency> validate(RosettaPath path, ElectricityTransmissionContingency o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ElectricityTransmissionContingency", ValidationType.TYPE_FORMAT, "ElectricityTransmissionContingency", path, "", error);
		}
		return success("ElectricityTransmissionContingency", ValidationType.TYPE_FORMAT, "ElectricityTransmissionContingency", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ElectricityTransmissionContingency o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ElectricityTransmissionContingency", ValidationType.TYPE_FORMAT, "ElectricityTransmissionContingency", path, "", res.getError());
				}
				return success("ElectricityTransmissionContingency", ValidationType.TYPE_FORMAT, "ElectricityTransmissionContingency", path, "");
			})
			.collect(toList());
	}

}
