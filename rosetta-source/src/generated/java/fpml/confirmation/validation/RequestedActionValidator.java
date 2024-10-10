package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.RequestedAction;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RequestedActionValidator implements Validator<RequestedAction> {

	private List<ComparisonResult> getComparisonResults(RequestedAction o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("requestedActionScheme", (String) o.getRequestedActionScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<RequestedAction> validate(RosettaPath path, RequestedAction o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RequestedAction", ValidationType.CARDINALITY, "RequestedAction", path, "", error);
		}
		return success("RequestedAction", ValidationType.CARDINALITY, "RequestedAction", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RequestedAction o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RequestedAction", ValidationType.CARDINALITY, "RequestedAction", path, "", res.getError());
				}
				return success("RequestedAction", ValidationType.CARDINALITY, "RequestedAction", path, "");
			})
			.collect(toList());
	}

}
