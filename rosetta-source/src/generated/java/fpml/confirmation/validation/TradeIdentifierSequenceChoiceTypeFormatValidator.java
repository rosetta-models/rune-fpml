package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TradeIdentifierSequenceChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeIdentifierSequenceChoiceTypeFormatValidator implements Validator<TradeIdentifierSequenceChoice> {

	private List<ComparisonResult> getComparisonResults(TradeIdentifierSequenceChoice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<TradeIdentifierSequenceChoice> validate(RosettaPath path, TradeIdentifierSequenceChoice o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeIdentifierSequenceChoice", ValidationType.TYPE_FORMAT, "TradeIdentifierSequenceChoice", path, "", error);
		}
		return success("TradeIdentifierSequenceChoice", ValidationType.TYPE_FORMAT, "TradeIdentifierSequenceChoice", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeIdentifierSequenceChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeIdentifierSequenceChoice", ValidationType.TYPE_FORMAT, "TradeIdentifierSequenceChoice", path, "", res.getError());
				}
				return success("TradeIdentifierSequenceChoice", ValidationType.TYPE_FORMAT, "TradeIdentifierSequenceChoice", path, "");
			})
			.collect(toList());
	}

}
