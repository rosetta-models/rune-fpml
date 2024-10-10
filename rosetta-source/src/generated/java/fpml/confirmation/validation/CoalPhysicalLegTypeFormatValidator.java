package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CoalPhysicalLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CoalPhysicalLegTypeFormatValidator implements Validator<CoalPhysicalLeg> {

	private List<ComparisonResult> getComparisonResults(CoalPhysicalLeg o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CoalPhysicalLeg> validate(RosettaPath path, CoalPhysicalLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CoalPhysicalLeg", ValidationType.TYPE_FORMAT, "CoalPhysicalLeg", path, "", error);
		}
		return success("CoalPhysicalLeg", ValidationType.TYPE_FORMAT, "CoalPhysicalLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CoalPhysicalLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CoalPhysicalLeg", ValidationType.TYPE_FORMAT, "CoalPhysicalLeg", path, "", res.getError());
				}
				return success("CoalPhysicalLeg", ValidationType.TYPE_FORMAT, "CoalPhysicalLeg", path, "");
			})
			.collect(toList());
	}

}
