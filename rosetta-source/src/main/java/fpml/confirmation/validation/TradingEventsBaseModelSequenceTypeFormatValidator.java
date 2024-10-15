package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TradingEventsBaseModelSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradingEventsBaseModelSequenceTypeFormatValidator implements Validator<TradingEventsBaseModelSequence> {

	private List<ComparisonResult> getComparisonResults(TradingEventsBaseModelSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<TradingEventsBaseModelSequence> validate(RosettaPath path, TradingEventsBaseModelSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradingEventsBaseModelSequence", ValidationType.TYPE_FORMAT, "TradingEventsBaseModelSequence", path, "", error);
		}
		return success("TradingEventsBaseModelSequence", ValidationType.TYPE_FORMAT, "TradingEventsBaseModelSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradingEventsBaseModelSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradingEventsBaseModelSequence", ValidationType.TYPE_FORMAT, "TradingEventsBaseModelSequence", path, "", res.getError());
				}
				return success("TradingEventsBaseModelSequence", ValidationType.TYPE_FORMAT, "TradingEventsBaseModelSequence", path, "");
			})
			.collect(toList());
	}

}
