package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EventProposedMatch;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EventProposedMatchTypeFormatValidator implements Validator<EventProposedMatch> {

	private List<ComparisonResult> getComparisonResults(EventProposedMatch o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<EventProposedMatch> validate(RosettaPath path, EventProposedMatch o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EventProposedMatch", ValidationType.TYPE_FORMAT, "EventProposedMatch", path, "", error);
		}
		return success("EventProposedMatch", ValidationType.TYPE_FORMAT, "EventProposedMatch", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EventProposedMatch o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EventProposedMatch", ValidationType.TYPE_FORMAT, "EventProposedMatch", path, "", res.getError());
				}
				return success("EventProposedMatch", ValidationType.TYPE_FORMAT, "EventProposedMatch", path, "");
			})
			.collect(toList());
	}

}
