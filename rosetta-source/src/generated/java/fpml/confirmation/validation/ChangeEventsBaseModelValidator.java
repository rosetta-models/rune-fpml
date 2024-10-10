package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ChangeEventsBaseModel;
import fpml.confirmation.TradeChangeContent;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ChangeEventsBaseModelValidator implements Validator<ChangeEventsBaseModel> {

	private List<ComparisonResult> getComparisonResults(ChangeEventsBaseModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("change", (TradeChangeContent) o.getChange() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<ChangeEventsBaseModel> validate(RosettaPath path, ChangeEventsBaseModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ChangeEventsBaseModel", ValidationType.CARDINALITY, "ChangeEventsBaseModel", path, "", error);
		}
		return success("ChangeEventsBaseModel", ValidationType.CARDINALITY, "ChangeEventsBaseModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ChangeEventsBaseModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ChangeEventsBaseModel", ValidationType.CARDINALITY, "ChangeEventsBaseModel", path, "", res.getError());
				}
				return success("ChangeEventsBaseModel", ValidationType.CARDINALITY, "ChangeEventsBaseModel", path, "");
			})
			.collect(toList());
	}

}
