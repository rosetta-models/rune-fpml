package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommitmentSchedule;
import fpml.confirmation.FacilityCommitment;
import fpml.confirmation.FacilityCommitmentModel;
import fpml.confirmation.FxTerms;
import fpml.confirmation.MoneyWithParticipantShare;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FacilityCommitmentModelValidator implements Validator<FacilityCommitmentModel> {

	private List<ComparisonResult> getComparisonResults(FacilityCommitmentModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("currentCommitment", (FacilityCommitment) o.getCurrentCommitment() != null ? 1 : 0, 1, 1), 
				checkCardinality("originalCommitment", (MoneyWithParticipantShare) o.getOriginalCommitment() != null ? 1 : 0, 0, 1), 
				checkCardinality("commitmentSchedule", (CommitmentSchedule) o.getCommitmentSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("dealFxRate", (FxTerms) o.getDealFxRate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FacilityCommitmentModel> validate(RosettaPath path, FacilityCommitmentModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FacilityCommitmentModel", ValidationType.CARDINALITY, "FacilityCommitmentModel", path, "", error);
		}
		return success("FacilityCommitmentModel", ValidationType.CARDINALITY, "FacilityCommitmentModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityCommitmentModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FacilityCommitmentModel", ValidationType.CARDINALITY, "FacilityCommitmentModel", path, "", res.getError());
				}
				return success("FacilityCommitmentModel", ValidationType.CARDINALITY, "FacilityCommitmentModel", path, "");
			})
			.collect(toList());
	}

}
