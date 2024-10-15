package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FacilityCommitmentModel;
import fpml.confirmation.FacilityDatesModel;
import fpml.confirmation.FacilityRolesModel;
import fpml.confirmation.FacilitySummary;
import fpml.confirmation.InstrumentId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FacilitySummaryValidator implements Validator<FacilitySummary> {

	private List<ComparisonResult> getComparisonResults(FacilitySummary o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("instrumentId", (List<? extends InstrumentId>) o.getInstrumentId() == null ? 0 : ((List<? extends InstrumentId>) o.getInstrumentId()).size(), 1, 0), 
				checkCardinality("description", (String) o.getDescription() != null ? 1 : 0, 0, 1), 
				checkCardinality("facilityRolesModel", (FacilityRolesModel) o.getFacilityRolesModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("facilityDatesModel", (FacilityDatesModel) o.getFacilityDatesModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("facilityCommitmentModel", (FacilityCommitmentModel) o.getFacilityCommitmentModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<FacilitySummary> validate(RosettaPath path, FacilitySummary o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FacilitySummary", ValidationType.CARDINALITY, "FacilitySummary", path, "", error);
		}
		return success("FacilitySummary", ValidationType.CARDINALITY, "FacilitySummary", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilitySummary o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FacilitySummary", ValidationType.CARDINALITY, "FacilitySummary", path, "", res.getError());
				}
				return success("FacilitySummary", ValidationType.CARDINALITY, "FacilitySummary", path, "");
			})
			.collect(toList());
	}

}
