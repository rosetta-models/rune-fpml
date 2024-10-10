package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DealRolesModel;
import fpml.confirmation.DealRolesModelSequence;
import fpml.confirmation.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DealRolesModelValidator implements Validator<DealRolesModel> {

	private List<ComparisonResult> getComparisonResults(DealRolesModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("issuerPartyReference", (PartyReference) o.getIssuerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("agentPartyReference", (PartyReference) o.getAgentPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("dealRolesModelSequence", (DealRolesModelSequence) o.getDealRolesModelSequence() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<DealRolesModel> validate(RosettaPath path, DealRolesModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DealRolesModel", ValidationType.CARDINALITY, "DealRolesModel", path, "", error);
		}
		return success("DealRolesModel", ValidationType.CARDINALITY, "DealRolesModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DealRolesModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DealRolesModel", ValidationType.CARDINALITY, "DealRolesModel", path, "", res.getError());
				}
				return success("DealRolesModel", ValidationType.CARDINALITY, "DealRolesModel", path, "");
			})
			.collect(toList());
	}

}
