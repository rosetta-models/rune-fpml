package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.VarianceLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class VarianceLegTypeFormatValidator implements Validator<VarianceLeg> {

	private List<ComparisonResult> getComparisonResults(VarianceLeg o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<VarianceLeg> validate(RosettaPath path, VarianceLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("VarianceLeg", ValidationType.TYPE_FORMAT, "VarianceLeg", path, "", error);
		}
		return success("VarianceLeg", ValidationType.TYPE_FORMAT, "VarianceLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VarianceLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VarianceLeg", ValidationType.TYPE_FORMAT, "VarianceLeg", path, "", res.getError());
				}
				return success("VarianceLeg", ValidationType.TYPE_FORMAT, "VarianceLeg", path, "");
			})
			.collect(toList());
	}

}
