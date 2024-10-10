package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.NumberOfUnitsReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class NumberOfUnitsReferenceTypeFormatValidator implements Validator<NumberOfUnitsReference> {

	private List<ComparisonResult> getComparisonResults(NumberOfUnitsReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<NumberOfUnitsReference> validate(RosettaPath path, NumberOfUnitsReference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NumberOfUnitsReference", ValidationType.TYPE_FORMAT, "NumberOfUnitsReference", path, "", error);
		}
		return success("NumberOfUnitsReference", ValidationType.TYPE_FORMAT, "NumberOfUnitsReference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NumberOfUnitsReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NumberOfUnitsReference", ValidationType.TYPE_FORMAT, "NumberOfUnitsReference", path, "", res.getError());
				}
				return success("NumberOfUnitsReference", ValidationType.TYPE_FORMAT, "NumberOfUnitsReference", path, "");
			})
			.collect(toList());
	}

}
