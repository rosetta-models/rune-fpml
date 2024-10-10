package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.UnderlyerReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class UnderlyerReferenceTypeFormatValidator implements Validator<UnderlyerReference> {

	private List<ComparisonResult> getComparisonResults(UnderlyerReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<UnderlyerReference> validate(RosettaPath path, UnderlyerReference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("UnderlyerReference", ValidationType.TYPE_FORMAT, "UnderlyerReference", path, "", error);
		}
		return success("UnderlyerReference", ValidationType.TYPE_FORMAT, "UnderlyerReference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, UnderlyerReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("UnderlyerReference", ValidationType.TYPE_FORMAT, "UnderlyerReference", path, "", res.getError());
				}
				return success("UnderlyerReference", ValidationType.TYPE_FORMAT, "UnderlyerReference", path, "");
			})
			.collect(toList());
	}

}
