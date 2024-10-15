package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.RequestExecutionRetracted;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RequestExecutionRetractedTypeFormatValidator implements Validator<RequestExecutionRetracted> {

	private List<ComparisonResult> getComparisonResults(RequestExecutionRetracted o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("expectedBuild", o.getExpectedBuild(), empty(), of(0), of(new BigDecimal("1")), empty()), 
				checkNumber("actualBuild", o.getActualBuild(), empty(), of(0), of(new BigDecimal("1")), empty())
			);
	}

	@Override
	public ValidationResult<RequestExecutionRetracted> validate(RosettaPath path, RequestExecutionRetracted o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RequestExecutionRetracted", ValidationType.TYPE_FORMAT, "RequestExecutionRetracted", path, "", error);
		}
		return success("RequestExecutionRetracted", ValidationType.TYPE_FORMAT, "RequestExecutionRetracted", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RequestExecutionRetracted o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RequestExecutionRetracted", ValidationType.TYPE_FORMAT, "RequestExecutionRetracted", path, "", res.getError());
				}
				return success("RequestExecutionRetracted", ValidationType.TYPE_FORMAT, "RequestExecutionRetracted", path, "");
			})
			.collect(toList());
	}

}
