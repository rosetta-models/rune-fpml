package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Address;
import fpml.confirmation.RoutingExplicitDetailsModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RoutingExplicitDetailsModelValidator implements Validator<RoutingExplicitDetailsModel> {

	private List<ComparisonResult> getComparisonResults(RoutingExplicitDetailsModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("routingName", (String) o.getRoutingName() != null ? 1 : 0, 1, 1), 
				checkCardinality("routingAddress", (Address) o.getRoutingAddress() != null ? 1 : 0, 0, 1), 
				checkCardinality("routingAccountNumber", (String) o.getRoutingAccountNumber() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<RoutingExplicitDetailsModel> validate(RosettaPath path, RoutingExplicitDetailsModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RoutingExplicitDetailsModel", ValidationType.CARDINALITY, "RoutingExplicitDetailsModel", path, "", error);
		}
		return success("RoutingExplicitDetailsModel", ValidationType.CARDINALITY, "RoutingExplicitDetailsModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RoutingExplicitDetailsModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RoutingExplicitDetailsModel", ValidationType.CARDINALITY, "RoutingExplicitDetailsModel", path, "", res.getError());
				}
				return success("RoutingExplicitDetailsModel", ValidationType.CARDINALITY, "RoutingExplicitDetailsModel", path, "");
			})
			.collect(toList());
	}

}
