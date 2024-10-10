package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.RoutingIdentificationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RoutingIdentificationModelTypeFormatValidator implements Validator<RoutingIdentificationModel> {

	private List<ComparisonResult> getComparisonResults(RoutingIdentificationModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<RoutingIdentificationModel> validate(RosettaPath path, RoutingIdentificationModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RoutingIdentificationModel", ValidationType.TYPE_FORMAT, "RoutingIdentificationModel", path, "", error);
		}
		return success("RoutingIdentificationModel", ValidationType.TYPE_FORMAT, "RoutingIdentificationModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RoutingIdentificationModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RoutingIdentificationModel", ValidationType.TYPE_FORMAT, "RoutingIdentificationModel", path, "", res.getError());
				}
				return success("RoutingIdentificationModel", ValidationType.TYPE_FORMAT, "RoutingIdentificationModel", path, "");
			})
			.collect(toList());
	}

}
