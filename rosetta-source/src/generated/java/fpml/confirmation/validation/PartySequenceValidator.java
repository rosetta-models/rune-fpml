package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PartyGroupType;
import fpml.confirmation.PartyReference;
import fpml.confirmation.PartySequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PartySequenceValidator implements Validator<PartySequence> {

	private List<ComparisonResult> getComparisonResults(PartySequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("groupType", (PartyGroupType) o.getGroupType() != null ? 1 : 0, 1, 1), 
				checkCardinality("partyReference", (List<? extends PartyReference>) o.getPartyReference() == null ? 0 : ((List<? extends PartyReference>) o.getPartyReference()).size(), 2, 0)
			);
	}

	@Override
	public ValidationResult<PartySequence> validate(RosettaPath path, PartySequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PartySequence", ValidationType.CARDINALITY, "PartySequence", path, "", error);
		}
		return success("PartySequence", ValidationType.CARDINALITY, "PartySequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartySequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartySequence", ValidationType.CARDINALITY, "PartySequence", path, "", res.getError());
				}
				return success("PartySequence", ValidationType.CARDINALITY, "PartySequence", path, "");
			})
			.collect(toList());
	}

}
