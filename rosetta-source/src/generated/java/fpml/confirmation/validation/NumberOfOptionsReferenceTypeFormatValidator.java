package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.NumberOfOptionsReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class NumberOfOptionsReferenceTypeFormatValidator implements Validator<NumberOfOptionsReference> {

	private List<ComparisonResult> getComparisonResults(NumberOfOptionsReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<NumberOfOptionsReference> validate(RosettaPath path, NumberOfOptionsReference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NumberOfOptionsReference", ValidationType.TYPE_FORMAT, "NumberOfOptionsReference", path, "", error);
		}
		return success("NumberOfOptionsReference", ValidationType.TYPE_FORMAT, "NumberOfOptionsReference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NumberOfOptionsReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NumberOfOptionsReference", ValidationType.TYPE_FORMAT, "NumberOfOptionsReference", path, "", res.getError());
				}
				return success("NumberOfOptionsReference", ValidationType.TYPE_FORMAT, "NumberOfOptionsReference", path, "");
			})
			.collect(toList());
	}

}
