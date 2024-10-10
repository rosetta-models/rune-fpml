package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AccruingPikOption;
import fpml.confirmation.FacilityOptionsFeesAndRatesModel;
import fpml.confirmation.FacilityOptionsFeesAndRatesModelChoice;
import fpml.confirmation.FacilityRatesModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FacilityOptionsFeesAndRatesModelValidator implements Validator<FacilityOptionsFeesAndRatesModel> {

	private List<ComparisonResult> getComparisonResults(FacilityOptionsFeesAndRatesModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("facilityOptionsFeesAndRatesModelChoice", (List<? extends FacilityOptionsFeesAndRatesModelChoice>) o.getFacilityOptionsFeesAndRatesModelChoice() == null ? 0 : ((List<? extends FacilityOptionsFeesAndRatesModelChoice>) o.getFacilityOptionsFeesAndRatesModelChoice()).size(), 1, 0), 
				checkCardinality("accruingPikOption", (AccruingPikOption) o.getAccruingPikOption() != null ? 1 : 0, 0, 1), 
				checkCardinality("facilityRatesModel", (FacilityRatesModel) o.getFacilityRatesModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<FacilityOptionsFeesAndRatesModel> validate(RosettaPath path, FacilityOptionsFeesAndRatesModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FacilityOptionsFeesAndRatesModel", ValidationType.CARDINALITY, "FacilityOptionsFeesAndRatesModel", path, "", error);
		}
		return success("FacilityOptionsFeesAndRatesModel", ValidationType.CARDINALITY, "FacilityOptionsFeesAndRatesModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityOptionsFeesAndRatesModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FacilityOptionsFeesAndRatesModel", ValidationType.CARDINALITY, "FacilityOptionsFeesAndRatesModel", path, "", res.getError());
				}
				return success("FacilityOptionsFeesAndRatesModel", ValidationType.CARDINALITY, "FacilityOptionsFeesAndRatesModel", path, "");
			})
			.collect(toList());
	}

}
