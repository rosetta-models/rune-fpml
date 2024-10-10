package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.EventInstructionOverride;
import fpml.confirmation.OverrideIdentifier;
import fpml.confirmation.SettlementDetails;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EventInstructionOverrideValidator implements Validator<EventInstructionOverride> {

	private List<ComparisonResult> getComparisonResults(EventInstructionOverride o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("overrideIdentifier", (OverrideIdentifier) o.getOverrideIdentifier() != null ? 1 : 0, 1, 1), 
				checkCardinality("eventIdentifier", (BusinessEventIdentifier) o.getEventIdentifier() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementDetails", (List<? extends SettlementDetails>) o.getSettlementDetails() == null ? 0 : ((List<? extends SettlementDetails>) o.getSettlementDetails()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<EventInstructionOverride> validate(RosettaPath path, EventInstructionOverride o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EventInstructionOverride", ValidationType.CARDINALITY, "EventInstructionOverride", path, "", error);
		}
		return success("EventInstructionOverride", ValidationType.CARDINALITY, "EventInstructionOverride", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EventInstructionOverride o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EventInstructionOverride", ValidationType.CARDINALITY, "EventInstructionOverride", path, "", res.getError());
				}
				return success("EventInstructionOverride", ValidationType.CARDINALITY, "EventInstructionOverride", path, "");
			})
			.collect(toList());
	}

}
