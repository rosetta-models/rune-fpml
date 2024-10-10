package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TradeLegFixedAmountChangeModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeLegFixedAmountChangeModelTypeFormatValidator implements Validator<TradeLegFixedAmountChangeModel> {

	private List<ComparisonResult> getComparisonResults(TradeLegFixedAmountChangeModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<TradeLegFixedAmountChangeModel> validate(RosettaPath path, TradeLegFixedAmountChangeModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeLegFixedAmountChangeModel", ValidationType.TYPE_FORMAT, "TradeLegFixedAmountChangeModel", path, "", error);
		}
		return success("TradeLegFixedAmountChangeModel", ValidationType.TYPE_FORMAT, "TradeLegFixedAmountChangeModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeLegFixedAmountChangeModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeLegFixedAmountChangeModel", ValidationType.TYPE_FORMAT, "TradeLegFixedAmountChangeModel", path, "", res.getError());
				}
				return success("TradeLegFixedAmountChangeModel", ValidationType.TYPE_FORMAT, "TradeLegFixedAmountChangeModel", path, "");
			})
			.collect(toList());
	}

}
