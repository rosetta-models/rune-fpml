package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.NewTradeModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class NewTradeModelTypeFormatValidator implements Validator<NewTradeModel> {

	private List<ComparisonResult> getComparisonResults(NewTradeModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<NewTradeModel> validate(RosettaPath path, NewTradeModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NewTradeModel", ValidationType.TYPE_FORMAT, "NewTradeModel", path, "", error);
		}
		return success("NewTradeModel", ValidationType.TYPE_FORMAT, "NewTradeModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NewTradeModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NewTradeModel", ValidationType.TYPE_FORMAT, "NewTradeModel", path, "", res.getError());
				}
				return success("NewTradeModel", ValidationType.TYPE_FORMAT, "NewTradeModel", path, "");
			})
			.collect(toList());
	}

}
