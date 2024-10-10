package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.RoutingExplicitDetails;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RoutingExplicitDetailsTypeFormatValidator implements Validator<RoutingExplicitDetails> {

	private List<ComparisonResult> getComparisonResults(RoutingExplicitDetails o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<RoutingExplicitDetails> validate(RosettaPath path, RoutingExplicitDetails o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RoutingExplicitDetails", ValidationType.TYPE_FORMAT, "RoutingExplicitDetails", path, "", error);
		}
		return success("RoutingExplicitDetails", ValidationType.TYPE_FORMAT, "RoutingExplicitDetails", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RoutingExplicitDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RoutingExplicitDetails", ValidationType.TYPE_FORMAT, "RoutingExplicitDetails", path, "", res.getError());
				}
				return success("RoutingExplicitDetails", ValidationType.TYPE_FORMAT, "RoutingExplicitDetails", path, "");
			})
			.collect(toList());
	}

}
