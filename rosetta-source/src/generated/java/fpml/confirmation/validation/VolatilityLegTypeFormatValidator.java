package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.VolatilityLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class VolatilityLegTypeFormatValidator implements Validator<VolatilityLeg> {

	private List<ComparisonResult> getComparisonResults(VolatilityLeg o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<VolatilityLeg> validate(RosettaPath path, VolatilityLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("VolatilityLeg", ValidationType.TYPE_FORMAT, "VolatilityLeg", path, "", error);
		}
		return success("VolatilityLeg", ValidationType.TYPE_FORMAT, "VolatilityLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VolatilityLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VolatilityLeg", ValidationType.TYPE_FORMAT, "VolatilityLeg", path, "", res.getError());
				}
				return success("VolatilityLeg", ValidationType.TYPE_FORMAT, "VolatilityLeg", path, "");
			})
			.collect(toList());
	}

}
