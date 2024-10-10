package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FacilityDetailsModel;
import fpml.confirmation.FacilityIdentifier;
import fpml.confirmation.FacilitySummary;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FacilityDetailsModelValidator implements Validator<FacilityDetailsModel> {

	private List<ComparisonResult> getComparisonResults(FacilityDetailsModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("facilityIdentifier", (FacilityIdentifier) o.getFacilityIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("facilitySummary", (FacilitySummary) o.getFacilitySummary() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FacilityDetailsModel> validate(RosettaPath path, FacilityDetailsModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FacilityDetailsModel", ValidationType.CARDINALITY, "FacilityDetailsModel", path, "", error);
		}
		return success("FacilityDetailsModel", ValidationType.CARDINALITY, "FacilityDetailsModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityDetailsModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FacilityDetailsModel", ValidationType.CARDINALITY, "FacilityDetailsModel", path, "", res.getError());
				}
				return success("FacilityDetailsModel", ValidationType.CARDINALITY, "FacilityDetailsModel", path, "");
			})
			.collect(toList());
	}

}
