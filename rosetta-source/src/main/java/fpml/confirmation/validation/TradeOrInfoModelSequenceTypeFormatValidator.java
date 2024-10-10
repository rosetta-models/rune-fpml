package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TradeOrInfoModelSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeOrInfoModelSequenceTypeFormatValidator implements Validator<TradeOrInfoModelSequence> {

	private List<ComparisonResult> getComparisonResults(TradeOrInfoModelSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<TradeOrInfoModelSequence> validate(RosettaPath path, TradeOrInfoModelSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeOrInfoModelSequence", ValidationType.TYPE_FORMAT, "TradeOrInfoModelSequence", path, "", error);
		}
		return success("TradeOrInfoModelSequence", ValidationType.TYPE_FORMAT, "TradeOrInfoModelSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeOrInfoModelSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeOrInfoModelSequence", ValidationType.TYPE_FORMAT, "TradeOrInfoModelSequence", path, "", res.getError());
				}
				return success("TradeOrInfoModelSequence", ValidationType.TYPE_FORMAT, "TradeOrInfoModelSequence", path, "");
			})
			.collect(toList());
	}

}
