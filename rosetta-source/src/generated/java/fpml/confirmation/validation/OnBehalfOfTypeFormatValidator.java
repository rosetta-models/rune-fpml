package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.OnBehalfOf;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OnBehalfOfTypeFormatValidator implements Validator<OnBehalfOf> {

	private List<ComparisonResult> getComparisonResults(OnBehalfOf o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<OnBehalfOf> validate(RosettaPath path, OnBehalfOf o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OnBehalfOf", ValidationType.TYPE_FORMAT, "OnBehalfOf", path, "", error);
		}
		return success("OnBehalfOf", ValidationType.TYPE_FORMAT, "OnBehalfOf", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OnBehalfOf o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OnBehalfOf", ValidationType.TYPE_FORMAT, "OnBehalfOf", path, "", res.getError());
				}
				return success("OnBehalfOf", ValidationType.TYPE_FORMAT, "OnBehalfOf", path, "");
			})
			.collect(toList());
	}

}
