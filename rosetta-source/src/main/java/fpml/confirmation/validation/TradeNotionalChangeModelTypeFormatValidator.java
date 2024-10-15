package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TradeNotionalChangeModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeNotionalChangeModelTypeFormatValidator implements Validator<TradeNotionalChangeModel> {

	private List<ComparisonResult> getComparisonResults(TradeNotionalChangeModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<TradeNotionalChangeModel> validate(RosettaPath path, TradeNotionalChangeModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeNotionalChangeModel", ValidationType.TYPE_FORMAT, "TradeNotionalChangeModel", path, "", error);
		}
		return success("TradeNotionalChangeModel", ValidationType.TYPE_FORMAT, "TradeNotionalChangeModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeNotionalChangeModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeNotionalChangeModel", ValidationType.TYPE_FORMAT, "TradeNotionalChangeModel", path, "", res.getError());
				}
				return success("TradeNotionalChangeModel", ValidationType.TYPE_FORMAT, "TradeNotionalChangeModel", path, "");
			})
			.collect(toList());
	}

}
