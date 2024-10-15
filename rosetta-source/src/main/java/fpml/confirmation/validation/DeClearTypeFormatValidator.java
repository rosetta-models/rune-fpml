package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DeClear;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DeClearTypeFormatValidator implements Validator<DeClear> {

	private List<ComparisonResult> getComparisonResults(DeClear o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<DeClear> validate(RosettaPath path, DeClear o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DeClear", ValidationType.TYPE_FORMAT, "DeClear", path, "", error);
		}
		return success("DeClear", ValidationType.TYPE_FORMAT, "DeClear", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DeClear o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DeClear", ValidationType.TYPE_FORMAT, "DeClear", path, "", res.getError());
				}
				return success("DeClear", ValidationType.TYPE_FORMAT, "DeClear", path, "");
			})
			.collect(toList());
	}

}
