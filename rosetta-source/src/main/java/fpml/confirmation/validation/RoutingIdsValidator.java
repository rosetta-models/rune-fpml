package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.RoutingId;
import fpml.confirmation.RoutingIds;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RoutingIdsValidator implements Validator<RoutingIds> {

	private List<ComparisonResult> getComparisonResults(RoutingIds o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("routingId", (List<? extends RoutingId>) o.getRoutingId() == null ? 0 : ((List<? extends RoutingId>) o.getRoutingId()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<RoutingIds> validate(RosettaPath path, RoutingIds o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RoutingIds", ValidationType.CARDINALITY, "RoutingIds", path, "", error);
		}
		return success("RoutingIds", ValidationType.CARDINALITY, "RoutingIds", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RoutingIds o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RoutingIds", ValidationType.CARDINALITY, "RoutingIds", path, "", res.getError());
				}
				return success("RoutingIds", ValidationType.CARDINALITY, "RoutingIds", path, "");
			})
			.collect(toList());
	}

}
