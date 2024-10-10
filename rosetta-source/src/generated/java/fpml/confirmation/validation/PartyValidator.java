package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Party;
import fpml.confirmation.PartyModel;
import fpml.confirmation.PartySequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PartyValidator implements Validator<Party> {

	private List<ComparisonResult> getComparisonResults(Party o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyModel", (PartyModel) o.getPartyModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("partySequence", (PartySequence) o.getPartySequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<Party> validate(RosettaPath path, Party o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Party", ValidationType.CARDINALITY, "Party", path, "", error);
		}
		return success("Party", ValidationType.CARDINALITY, "Party", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Party o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Party", ValidationType.CARDINALITY, "Party", path, "", res.getError());
				}
				return success("Party", ValidationType.CARDINALITY, "Party", path, "");
			})
			.collect(toList());
	}

}
