package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.OilPhysicalLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OilPhysicalLegTypeFormatValidator implements Validator<OilPhysicalLeg> {

	private List<ComparisonResult> getComparisonResults(OilPhysicalLeg o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<OilPhysicalLeg> validate(RosettaPath path, OilPhysicalLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OilPhysicalLeg", ValidationType.TYPE_FORMAT, "OilPhysicalLeg", path, "", error);
		}
		return success("OilPhysicalLeg", ValidationType.TYPE_FORMAT, "OilPhysicalLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OilPhysicalLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OilPhysicalLeg", ValidationType.TYPE_FORMAT, "OilPhysicalLeg", path, "", res.getError());
				}
				return success("OilPhysicalLeg", ValidationType.TYPE_FORMAT, "OilPhysicalLeg", path, "");
			})
			.collect(toList());
	}

}
