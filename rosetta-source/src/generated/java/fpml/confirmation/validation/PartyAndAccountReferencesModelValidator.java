package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AccountReference;
import fpml.confirmation.PartyAndAccountReferencesModel;
import fpml.confirmation.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PartyAndAccountReferencesModelValidator implements Validator<PartyAndAccountReferencesModel> {

	private List<ComparisonResult> getComparisonResults(PartyAndAccountReferencesModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyReference", (PartyReference) o.getPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("accountReference", (AccountReference) o.getAccountReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<PartyAndAccountReferencesModel> validate(RosettaPath path, PartyAndAccountReferencesModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PartyAndAccountReferencesModel", ValidationType.CARDINALITY, "PartyAndAccountReferencesModel", path, "", error);
		}
		return success("PartyAndAccountReferencesModel", ValidationType.CARDINALITY, "PartyAndAccountReferencesModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyAndAccountReferencesModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyAndAccountReferencesModel", ValidationType.CARDINALITY, "PartyAndAccountReferencesModel", path, "", res.getError());
				}
				return success("PartyAndAccountReferencesModel", ValidationType.CARDINALITY, "PartyAndAccountReferencesModel", path, "");
			})
			.collect(toList());
	}

}
