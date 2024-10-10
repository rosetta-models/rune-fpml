package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CoalAttributePercentage;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CoalAttributePercentageTypeFormatValidator implements Validator<CoalAttributePercentage> {

	private List<ComparisonResult> getComparisonResults(CoalAttributePercentage o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CoalAttributePercentage> validate(RosettaPath path, CoalAttributePercentage o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CoalAttributePercentage", ValidationType.TYPE_FORMAT, "CoalAttributePercentage", path, "", error);
		}
		return success("CoalAttributePercentage", ValidationType.TYPE_FORMAT, "CoalAttributePercentage", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CoalAttributePercentage o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CoalAttributePercentage", ValidationType.TYPE_FORMAT, "CoalAttributePercentage", path, "", res.getError());
				}
				return success("CoalAttributePercentage", ValidationType.TYPE_FORMAT, "CoalAttributePercentage", path, "");
			})
			.collect(toList());
	}

}
