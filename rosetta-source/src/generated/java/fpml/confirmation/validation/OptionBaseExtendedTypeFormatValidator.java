package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.OptionBaseExtended;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OptionBaseExtendedTypeFormatValidator implements Validator<OptionBaseExtended> {

	private List<ComparisonResult> getComparisonResults(OptionBaseExtended o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<OptionBaseExtended> validate(RosettaPath path, OptionBaseExtended o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OptionBaseExtended", ValidationType.TYPE_FORMAT, "OptionBaseExtended", path, "", error);
		}
		return success("OptionBaseExtended", ValidationType.TYPE_FORMAT, "OptionBaseExtended", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionBaseExtended o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionBaseExtended", ValidationType.TYPE_FORMAT, "OptionBaseExtended", path, "", res.getError());
				}
				return success("OptionBaseExtended", ValidationType.TYPE_FORMAT, "OptionBaseExtended", path, "");
			})
			.collect(toList());
	}

}
