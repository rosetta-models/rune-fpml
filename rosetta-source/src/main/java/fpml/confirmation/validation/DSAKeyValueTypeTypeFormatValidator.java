package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DSAKeyValueType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DSAKeyValueTypeTypeFormatValidator implements Validator<DSAKeyValueType> {

	private List<ComparisonResult> getComparisonResults(DSAKeyValueType o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<DSAKeyValueType> validate(RosettaPath path, DSAKeyValueType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DSAKeyValueType", ValidationType.TYPE_FORMAT, "DSAKeyValueType", path, "", error);
		}
		return success("DSAKeyValueType", ValidationType.TYPE_FORMAT, "DSAKeyValueType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DSAKeyValueType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DSAKeyValueType", ValidationType.TYPE_FORMAT, "DSAKeyValueType", path, "", res.getError());
				}
				return success("DSAKeyValueType", ValidationType.TYPE_FORMAT, "DSAKeyValueType", path, "");
			})
			.collect(toList());
	}

}
