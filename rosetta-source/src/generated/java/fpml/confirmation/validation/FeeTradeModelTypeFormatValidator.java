package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FeeTradeModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FeeTradeModelTypeFormatValidator implements Validator<FeeTradeModel> {

	private List<ComparisonResult> getComparisonResults(FeeTradeModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FeeTradeModel> validate(RosettaPath path, FeeTradeModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FeeTradeModel", ValidationType.TYPE_FORMAT, "FeeTradeModel", path, "", error);
		}
		return success("FeeTradeModel", ValidationType.TYPE_FORMAT, "FeeTradeModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FeeTradeModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FeeTradeModel", ValidationType.TYPE_FORMAT, "FeeTradeModel", path, "", res.getError());
				}
				return success("FeeTradeModel", ValidationType.TYPE_FORMAT, "FeeTradeModel", path, "");
			})
			.collect(toList());
	}

}
