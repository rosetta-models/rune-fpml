package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.OnBehalfOf;
import fpml.confirmation.OnBehalfOfModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OnBehalfOfModelValidator implements Validator<OnBehalfOfModel> {

	private List<ComparisonResult> getComparisonResults(OnBehalfOfModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("onBehalfOf", (OnBehalfOf) o.getOnBehalfOf() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<OnBehalfOfModel> validate(RosettaPath path, OnBehalfOfModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OnBehalfOfModel", ValidationType.CARDINALITY, "OnBehalfOfModel", path, "", error);
		}
		return success("OnBehalfOfModel", ValidationType.CARDINALITY, "OnBehalfOfModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OnBehalfOfModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OnBehalfOfModel", ValidationType.CARDINALITY, "OnBehalfOfModel", path, "", res.getError());
				}
				return success("OnBehalfOfModel", ValidationType.CARDINALITY, "OnBehalfOfModel", path, "");
			})
			.collect(toList());
	}

}
