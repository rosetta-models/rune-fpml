package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AccountReference;
import fpml.confirmation.NovationRolesModel;
import fpml.confirmation.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class NovationRolesModelValidator implements Validator<NovationRolesModel> {

	private List<ComparisonResult> getComparisonResults(NovationRolesModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("transferor", (PartyReference) o.getTransferor() != null ? 1 : 0, 1, 1), 
				checkCardinality("transferorAccount", (AccountReference) o.getTransferorAccount() != null ? 1 : 0, 0, 1), 
				checkCardinality("transferee", (PartyReference) o.getTransferee() != null ? 1 : 0, 1, 1), 
				checkCardinality("otherTransferee", (PartyReference) o.getOtherTransferee() != null ? 1 : 0, 0, 1), 
				checkCardinality("transfereeAccount", (AccountReference) o.getTransfereeAccount() != null ? 1 : 0, 0, 1), 
				checkCardinality("otherTransfereeAccount", (AccountReference) o.getOtherTransfereeAccount() != null ? 1 : 0, 0, 1), 
				checkCardinality("remainingParty", (PartyReference) o.getRemainingParty() != null ? 1 : 0, 1, 1), 
				checkCardinality("remainingPartyAccount", (AccountReference) o.getRemainingPartyAccount() != null ? 1 : 0, 0, 1), 
				checkCardinality("otherRemainingParty", (PartyReference) o.getOtherRemainingParty() != null ? 1 : 0, 0, 1), 
				checkCardinality("otherRemainingPartyAccount", (AccountReference) o.getOtherRemainingPartyAccount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<NovationRolesModel> validate(RosettaPath path, NovationRolesModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NovationRolesModel", ValidationType.CARDINALITY, "NovationRolesModel", path, "", error);
		}
		return success("NovationRolesModel", ValidationType.CARDINALITY, "NovationRolesModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NovationRolesModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NovationRolesModel", ValidationType.CARDINALITY, "NovationRolesModel", path, "", res.getError());
				}
				return success("NovationRolesModel", ValidationType.CARDINALITY, "NovationRolesModel", path, "");
			})
			.collect(toList());
	}

}
