package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CorrelationIdModel;
import fpml.confirmation.EventIdentifierSequence;
import fpml.confirmation.SequenceModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EventIdentifierSequenceValidator implements Validator<EventIdentifierSequence> {

	private List<ComparisonResult> getComparisonResults(EventIdentifierSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("correlationIdModel", (CorrelationIdModel) o.getCorrelationIdModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("sequenceModel", (SequenceModel) o.getSequenceModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<EventIdentifierSequence> validate(RosettaPath path, EventIdentifierSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EventIdentifierSequence", ValidationType.CARDINALITY, "EventIdentifierSequence", path, "", error);
		}
		return success("EventIdentifierSequence", ValidationType.CARDINALITY, "EventIdentifierSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EventIdentifierSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EventIdentifierSequence", ValidationType.CARDINALITY, "EventIdentifierSequence", path, "", res.getError());
				}
				return success("EventIdentifierSequence", ValidationType.CARDINALITY, "EventIdentifierSequence", path, "");
			})
			.collect(toList());
	}

}
