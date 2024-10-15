package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ResponseMessageHeader;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ResponseMessageHeaderTypeFormatValidator implements Validator<ResponseMessageHeader> {

	private List<ComparisonResult> getComparisonResults(ResponseMessageHeader o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ResponseMessageHeader> validate(RosettaPath path, ResponseMessageHeader o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ResponseMessageHeader", ValidationType.TYPE_FORMAT, "ResponseMessageHeader", path, "", error);
		}
		return success("ResponseMessageHeader", ValidationType.TYPE_FORMAT, "ResponseMessageHeader", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ResponseMessageHeader o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ResponseMessageHeader", ValidationType.TYPE_FORMAT, "ResponseMessageHeader", path, "", res.getError());
				}
				return success("ResponseMessageHeader", ValidationType.TYPE_FORMAT, "ResponseMessageHeader", path, "");
			})
			.collect(toList());
	}

}
