package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ApplicableCommunicationDetails;
import fpml.confirmation.ApplicableSettlementInstructionDetails;
import fpml.confirmation.PartyProfileChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PartyProfileChoiceValidator implements Validator<PartyProfileChoice> {

	private List<ComparisonResult> getComparisonResults(PartyProfileChoice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("communicationDetails", (ApplicableCommunicationDetails) o.getCommunicationDetails() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementInstructionDetails", (ApplicableSettlementInstructionDetails) o.getSettlementInstructionDetails() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<PartyProfileChoice> validate(RosettaPath path, PartyProfileChoice o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PartyProfileChoice", ValidationType.CARDINALITY, "PartyProfileChoice", path, "", error);
		}
		return success("PartyProfileChoice", ValidationType.CARDINALITY, "PartyProfileChoice", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyProfileChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyProfileChoice", ValidationType.CARDINALITY, "PartyProfileChoice", path, "", res.getError());
				}
				return success("PartyProfileChoice", ValidationType.CARDINALITY, "PartyProfileChoice", path, "");
			})
			.collect(toList());
	}

}
