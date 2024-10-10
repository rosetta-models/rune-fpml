package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FacilityCommitmentSequence;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.UtilizationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FacilityCommitmentSequenceValidator implements Validator<FacilityCommitmentSequence> {

	private List<ComparisonResult> getComparisonResults(FacilityCommitmentSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("utilizationModel", (UtilizationModel) o.getUtilizationModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("unavailableToUtilizeAmount", (MoneyWithParticipantShare) o.getUnavailableToUtilizeAmount() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<FacilityCommitmentSequence> validate(RosettaPath path, FacilityCommitmentSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FacilityCommitmentSequence", ValidationType.CARDINALITY, "FacilityCommitmentSequence", path, "", error);
		}
		return success("FacilityCommitmentSequence", ValidationType.CARDINALITY, "FacilityCommitmentSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityCommitmentSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FacilityCommitmentSequence", ValidationType.CARDINALITY, "FacilityCommitmentSequence", path, "", res.getError());
				}
				return success("FacilityCommitmentSequence", ValidationType.CARDINALITY, "FacilityCommitmentSequence", path, "");
			})
			.collect(toList());
	}

}
