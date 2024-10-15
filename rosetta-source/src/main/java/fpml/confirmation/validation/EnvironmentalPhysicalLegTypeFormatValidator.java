package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EnvironmentalPhysicalLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EnvironmentalPhysicalLegTypeFormatValidator implements Validator<EnvironmentalPhysicalLeg> {

	private List<ComparisonResult> getComparisonResults(EnvironmentalPhysicalLeg o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<EnvironmentalPhysicalLeg> validate(RosettaPath path, EnvironmentalPhysicalLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EnvironmentalPhysicalLeg", ValidationType.TYPE_FORMAT, "EnvironmentalPhysicalLeg", path, "", error);
		}
		return success("EnvironmentalPhysicalLeg", ValidationType.TYPE_FORMAT, "EnvironmentalPhysicalLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EnvironmentalPhysicalLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EnvironmentalPhysicalLeg", ValidationType.TYPE_FORMAT, "EnvironmentalPhysicalLeg", path, "", res.getError());
				}
				return success("EnvironmentalPhysicalLeg", ValidationType.TYPE_FORMAT, "EnvironmentalPhysicalLeg", path, "");
			})
			.collect(toList());
	}

}
