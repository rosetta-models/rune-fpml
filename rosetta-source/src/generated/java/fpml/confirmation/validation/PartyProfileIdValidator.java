package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PartyProfileId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PartyProfileIdValidator implements Validator<PartyProfileId> {

	private List<ComparisonResult> getComparisonResults(PartyProfileId o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("partyProfileIdScheme", (String) o.getPartyProfileIdScheme() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<PartyProfileId> validate(RosettaPath path, PartyProfileId o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PartyProfileId", ValidationType.CARDINALITY, "PartyProfileId", path, "", error);
		}
		return success("PartyProfileId", ValidationType.CARDINALITY, "PartyProfileId", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyProfileId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyProfileId", ValidationType.CARDINALITY, "PartyProfileId", path, "", res.getError());
				}
				return success("PartyProfileId", ValidationType.CARDINALITY, "PartyProfileId", path, "");
			})
			.collect(toList());
	}

}
