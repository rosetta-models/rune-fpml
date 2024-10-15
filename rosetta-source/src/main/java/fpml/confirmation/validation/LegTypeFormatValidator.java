package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Leg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LegTypeFormatValidator implements Validator<Leg> {

	private List<ComparisonResult> getComparisonResults(Leg o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<Leg> validate(RosettaPath path, Leg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Leg", ValidationType.TYPE_FORMAT, "Leg", path, "", error);
		}
		return success("Leg", ValidationType.TYPE_FORMAT, "Leg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Leg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Leg", ValidationType.TYPE_FORMAT, "Leg", path, "", res.getError());
				}
				return success("Leg", ValidationType.TYPE_FORMAT, "Leg", path, "");
			})
			.collect(toList());
	}

}
