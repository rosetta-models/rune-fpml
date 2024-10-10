package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ElectricityTransmissionContingencyType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ElectricityTransmissionContingencyTypeValidator implements Validator<ElectricityTransmissionContingencyType> {

	private List<ComparisonResult> getComparisonResults(ElectricityTransmissionContingencyType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("electricityTransmissionContingencyScheme", (String) o.getElectricityTransmissionContingencyScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ElectricityTransmissionContingencyType> validate(RosettaPath path, ElectricityTransmissionContingencyType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ElectricityTransmissionContingencyType", ValidationType.CARDINALITY, "ElectricityTransmissionContingencyType", path, "", error);
		}
		return success("ElectricityTransmissionContingencyType", ValidationType.CARDINALITY, "ElectricityTransmissionContingencyType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ElectricityTransmissionContingencyType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ElectricityTransmissionContingencyType", ValidationType.CARDINALITY, "ElectricityTransmissionContingencyType", path, "", res.getError());
				}
				return success("ElectricityTransmissionContingencyType", ValidationType.CARDINALITY, "ElectricityTransmissionContingencyType", path, "");
			})
			.collect(toList());
	}

}
