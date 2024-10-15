package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.EventId;
import fpml.confirmation.PartyAndAccountReferencesModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BusinessEventIdentifierValidator implements Validator<BusinessEventIdentifier> {

	private List<ComparisonResult> getComparisonResults(BusinessEventIdentifier o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyAndAccountReferencesModel", (PartyAndAccountReferencesModel) o.getPartyAndAccountReferencesModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("eventId", (EventId) o.getEventId() != null ? 1 : 0, 1, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<BusinessEventIdentifier> validate(RosettaPath path, BusinessEventIdentifier o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("BusinessEventIdentifier", ValidationType.CARDINALITY, "BusinessEventIdentifier", path, "", error);
		}
		return success("BusinessEventIdentifier", ValidationType.CARDINALITY, "BusinessEventIdentifier", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BusinessEventIdentifier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BusinessEventIdentifier", ValidationType.CARDINALITY, "BusinessEventIdentifier", path, "", res.getError());
				}
				return success("BusinessEventIdentifier", ValidationType.CARDINALITY, "BusinessEventIdentifier", path, "");
			})
			.collect(toList());
	}

}
