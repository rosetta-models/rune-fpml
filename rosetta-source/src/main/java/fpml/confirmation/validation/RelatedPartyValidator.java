package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PartyAndAccountReferencesModel;
import fpml.confirmation.PartyRole;
import fpml.confirmation.PartyRoleType;
import fpml.confirmation.RelatedParty;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RelatedPartyValidator implements Validator<RelatedParty> {

	private List<ComparisonResult> getComparisonResults(RelatedParty o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyAndAccountReferencesModel", (PartyAndAccountReferencesModel) o.getPartyAndAccountReferencesModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("role", (PartyRole) o.getRole() != null ? 1 : 0, 1, 1), 
				checkCardinality("_type", (PartyRoleType) o.get_type() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<RelatedParty> validate(RosettaPath path, RelatedParty o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RelatedParty", ValidationType.CARDINALITY, "RelatedParty", path, "", error);
		}
		return success("RelatedParty", ValidationType.CARDINALITY, "RelatedParty", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RelatedParty o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RelatedParty", ValidationType.CARDINALITY, "RelatedParty", path, "", res.getError());
				}
				return success("RelatedParty", ValidationType.CARDINALITY, "RelatedParty", path, "");
			})
			.collect(toList());
	}

}
