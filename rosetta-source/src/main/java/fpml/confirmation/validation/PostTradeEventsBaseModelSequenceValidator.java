package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PostTradeEventsBaseModelSequence;
import fpml.confirmation.TerminatingEvent;
import fpml.confirmation.TradeNotionalChange;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PostTradeEventsBaseModelSequenceValidator implements Validator<PostTradeEventsBaseModelSequence> {

	private List<ComparisonResult> getComparisonResults(PostTradeEventsBaseModelSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("terminatingEvent", (TerminatingEvent) o.getTerminatingEvent() != null ? 1 : 0, 0, 1), 
				checkCardinality("termination", (TradeNotionalChange) o.getTermination() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<PostTradeEventsBaseModelSequence> validate(RosettaPath path, PostTradeEventsBaseModelSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PostTradeEventsBaseModelSequence", ValidationType.CARDINALITY, "PostTradeEventsBaseModelSequence", path, "", error);
		}
		return success("PostTradeEventsBaseModelSequence", ValidationType.CARDINALITY, "PostTradeEventsBaseModelSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PostTradeEventsBaseModelSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PostTradeEventsBaseModelSequence", ValidationType.CARDINALITY, "PostTradeEventsBaseModelSequence", path, "", res.getError());
				}
				return success("PostTradeEventsBaseModelSequence", ValidationType.CARDINALITY, "PostTradeEventsBaseModelSequence", path, "");
			})
			.collect(toList());
	}

}
