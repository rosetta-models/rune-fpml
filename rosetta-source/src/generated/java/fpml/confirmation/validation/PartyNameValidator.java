package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PartyName;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PartyNameValidator implements Validator<PartyName> {

	private List<ComparisonResult> getComparisonResults(PartyName o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("partyNameScheme", (String) o.getPartyNameScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<PartyName> validate(RosettaPath path, PartyName o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PartyName", ValidationType.CARDINALITY, "PartyName", path, "", error);
		}
		return success("PartyName", ValidationType.CARDINALITY, "PartyName", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyName o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyName", ValidationType.CARDINALITY, "PartyName", path, "", res.getError());
				}
				return success("PartyName", ValidationType.CARDINALITY, "PartyName", path, "");
			})
			.collect(toList());
	}

}
