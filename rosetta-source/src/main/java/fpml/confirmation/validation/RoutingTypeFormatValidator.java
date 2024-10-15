package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Routing;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RoutingTypeFormatValidator implements Validator<Routing> {

	private List<ComparisonResult> getComparisonResults(Routing o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<Routing> validate(RosettaPath path, Routing o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Routing", ValidationType.TYPE_FORMAT, "Routing", path, "", error);
		}
		return success("Routing", ValidationType.TYPE_FORMAT, "Routing", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Routing o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Routing", ValidationType.TYPE_FORMAT, "Routing", path, "", res.getError());
				}
				return success("Routing", ValidationType.TYPE_FORMAT, "Routing", path, "");
			})
			.collect(toList());
	}

}
