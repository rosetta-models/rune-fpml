package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TradingEventsBaseModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradingEventsBaseModelTypeFormatValidator implements Validator<TradingEventsBaseModel> {

	private List<ComparisonResult> getComparisonResults(TradingEventsBaseModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<TradingEventsBaseModel> validate(RosettaPath path, TradingEventsBaseModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradingEventsBaseModel", ValidationType.TYPE_FORMAT, "TradingEventsBaseModel", path, "", error);
		}
		return success("TradingEventsBaseModel", ValidationType.TYPE_FORMAT, "TradingEventsBaseModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradingEventsBaseModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradingEventsBaseModel", ValidationType.TYPE_FORMAT, "TradingEventsBaseModel", path, "", res.getError());
				}
				return success("TradingEventsBaseModel", ValidationType.TYPE_FORMAT, "TradingEventsBaseModel", path, "");
			})
			.collect(toList());
	}

}
