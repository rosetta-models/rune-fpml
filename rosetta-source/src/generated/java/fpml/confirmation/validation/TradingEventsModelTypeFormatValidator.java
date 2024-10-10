package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TradingEventsModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradingEventsModelTypeFormatValidator implements Validator<TradingEventsModel> {

	private List<ComparisonResult> getComparisonResults(TradingEventsModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<TradingEventsModel> validate(RosettaPath path, TradingEventsModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradingEventsModel", ValidationType.TYPE_FORMAT, "TradingEventsModel", path, "", error);
		}
		return success("TradingEventsModel", ValidationType.TYPE_FORMAT, "TradingEventsModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradingEventsModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradingEventsModel", ValidationType.TYPE_FORMAT, "TradingEventsModel", path, "", res.getError());
				}
				return success("TradingEventsModel", ValidationType.TYPE_FORMAT, "TradingEventsModel", path, "");
			})
			.collect(toList());
	}

}
