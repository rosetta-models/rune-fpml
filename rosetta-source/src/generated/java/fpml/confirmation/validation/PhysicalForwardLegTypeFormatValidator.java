package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PhysicalForwardLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PhysicalForwardLegTypeFormatValidator implements Validator<PhysicalForwardLeg> {

	private List<ComparisonResult> getComparisonResults(PhysicalForwardLeg o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PhysicalForwardLeg> validate(RosettaPath path, PhysicalForwardLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PhysicalForwardLeg", ValidationType.TYPE_FORMAT, "PhysicalForwardLeg", path, "", error);
		}
		return success("PhysicalForwardLeg", ValidationType.TYPE_FORMAT, "PhysicalForwardLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PhysicalForwardLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PhysicalForwardLeg", ValidationType.TYPE_FORMAT, "PhysicalForwardLeg", path, "", res.getError());
				}
				return success("PhysicalForwardLeg", ValidationType.TYPE_FORMAT, "PhysicalForwardLeg", path, "");
			})
			.collect(toList());
	}

}
