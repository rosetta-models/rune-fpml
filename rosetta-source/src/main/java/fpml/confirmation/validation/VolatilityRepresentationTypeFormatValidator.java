package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.VolatilityRepresentation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class VolatilityRepresentationTypeFormatValidator implements Validator<VolatilityRepresentation> {

	private List<ComparisonResult> getComparisonResults(VolatilityRepresentation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<VolatilityRepresentation> validate(RosettaPath path, VolatilityRepresentation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("VolatilityRepresentation", ValidationType.TYPE_FORMAT, "VolatilityRepresentation", path, "", error);
		}
		return success("VolatilityRepresentation", ValidationType.TYPE_FORMAT, "VolatilityRepresentation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VolatilityRepresentation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VolatilityRepresentation", ValidationType.TYPE_FORMAT, "VolatilityRepresentation", path, "", res.getError());
				}
				return success("VolatilityRepresentation", ValidationType.TYPE_FORMAT, "VolatilityRepresentation", path, "");
			})
			.collect(toList());
	}

}
