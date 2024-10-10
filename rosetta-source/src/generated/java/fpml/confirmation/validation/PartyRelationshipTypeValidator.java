package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PartyRelationshipType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PartyRelationshipTypeValidator implements Validator<PartyRelationshipType> {

	private List<ComparisonResult> getComparisonResults(PartyRelationshipType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("partyRelationshipTypeScheme", (String) o.getPartyRelationshipTypeScheme() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<PartyRelationshipType> validate(RosettaPath path, PartyRelationshipType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PartyRelationshipType", ValidationType.CARDINALITY, "PartyRelationshipType", path, "", error);
		}
		return success("PartyRelationshipType", ValidationType.CARDINALITY, "PartyRelationshipType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyRelationshipType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyRelationshipType", ValidationType.CARDINALITY, "PartyRelationshipType", path, "", res.getError());
				}
				return success("PartyRelationshipType", ValidationType.CARDINALITY, "PartyRelationshipType", path, "");
			})
			.collect(toList());
	}

}
