package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.MetalPhysicalLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MetalPhysicalLegTypeFormatValidator implements Validator<MetalPhysicalLeg> {

	private List<ComparisonResult> getComparisonResults(MetalPhysicalLeg o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<MetalPhysicalLeg> validate(RosettaPath path, MetalPhysicalLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("MetalPhysicalLeg", ValidationType.TYPE_FORMAT, "MetalPhysicalLeg", path, "", error);
		}
		return success("MetalPhysicalLeg", ValidationType.TYPE_FORMAT, "MetalPhysicalLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MetalPhysicalLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MetalPhysicalLeg", ValidationType.TYPE_FORMAT, "MetalPhysicalLeg", path, "", res.getError());
				}
				return success("MetalPhysicalLeg", ValidationType.TYPE_FORMAT, "MetalPhysicalLeg", path, "");
			})
			.collect(toList());
	}

}
