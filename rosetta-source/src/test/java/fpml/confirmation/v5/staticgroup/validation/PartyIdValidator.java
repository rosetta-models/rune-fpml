package fpml.confirmation.v5.staticgroup.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.v5.staticgroup.PartyId;

import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PartyIdValidator implements Validator<PartyId> {

	private List<ComparisonResult> getComparisonResults(PartyId o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("partyIdScheme", (String) o.getPartyIdScheme() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<PartyId> validate(RosettaPath path, PartyId o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PartyId", ValidationType.CARDINALITY, "PartyId", path, "", error);
		}
		return success("PartyId", ValidationType.CARDINALITY, "PartyId", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyId", ValidationType.CARDINALITY, "PartyId", path, "", res.getError());
				}
				return success("PartyId", ValidationType.CARDINALITY, "PartyId", path, "");
			})
			.collect(toList());
	}

}
