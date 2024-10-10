package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.RequestMessageHeader;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RequestMessageHeaderTypeFormatValidator implements Validator<RequestMessageHeader> {

	private List<ComparisonResult> getComparisonResults(RequestMessageHeader o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<RequestMessageHeader> validate(RosettaPath path, RequestMessageHeader o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RequestMessageHeader", ValidationType.TYPE_FORMAT, "RequestMessageHeader", path, "", error);
		}
		return success("RequestMessageHeader", ValidationType.TYPE_FORMAT, "RequestMessageHeader", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RequestMessageHeader o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RequestMessageHeader", ValidationType.TYPE_FORMAT, "RequestMessageHeader", path, "", res.getError());
				}
				return success("RequestMessageHeader", ValidationType.TYPE_FORMAT, "RequestMessageHeader", path, "");
			})
			.collect(toList());
	}

}
