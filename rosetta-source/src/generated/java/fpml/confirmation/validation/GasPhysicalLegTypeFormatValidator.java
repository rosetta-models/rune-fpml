package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.GasPhysicalLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class GasPhysicalLegTypeFormatValidator implements Validator<GasPhysicalLeg> {

	private List<ComparisonResult> getComparisonResults(GasPhysicalLeg o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<GasPhysicalLeg> validate(RosettaPath path, GasPhysicalLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("GasPhysicalLeg", ValidationType.TYPE_FORMAT, "GasPhysicalLeg", path, "", error);
		}
		return success("GasPhysicalLeg", ValidationType.TYPE_FORMAT, "GasPhysicalLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GasPhysicalLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GasPhysicalLeg", ValidationType.TYPE_FORMAT, "GasPhysicalLeg", path, "", res.getError());
				}
				return success("GasPhysicalLeg", ValidationType.TYPE_FORMAT, "GasPhysicalLeg", path, "");
			})
			.collect(toList());
	}

}
