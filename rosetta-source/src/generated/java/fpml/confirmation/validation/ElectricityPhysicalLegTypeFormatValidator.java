package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ElectricityPhysicalLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ElectricityPhysicalLegTypeFormatValidator implements Validator<ElectricityPhysicalLeg> {

	private List<ComparisonResult> getComparisonResults(ElectricityPhysicalLeg o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ElectricityPhysicalLeg> validate(RosettaPath path, ElectricityPhysicalLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ElectricityPhysicalLeg", ValidationType.TYPE_FORMAT, "ElectricityPhysicalLeg", path, "", error);
		}
		return success("ElectricityPhysicalLeg", ValidationType.TYPE_FORMAT, "ElectricityPhysicalLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ElectricityPhysicalLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ElectricityPhysicalLeg", ValidationType.TYPE_FORMAT, "ElectricityPhysicalLeg", path, "", res.getError());
				}
				return success("ElectricityPhysicalLeg", ValidationType.TYPE_FORMAT, "ElectricityPhysicalLeg", path, "");
			})
			.collect(toList());
	}

}
