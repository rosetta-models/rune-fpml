package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AbstractFacility;
import fpml.confirmation.FacilityCommitmentModel;
import fpml.confirmation.FacilityDatesModel;
import fpml.confirmation.FacilityFeaturesModel;
import fpml.confirmation.FacilityOptionsFeesAndRatesModel;
import fpml.confirmation.FacilityRolesModel;
import fpml.confirmation.GoverningLaw;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.MultiCurrency;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AbstractFacilityValidator implements Validator<AbstractFacility> {

	private List<ComparisonResult> getComparisonResults(AbstractFacility o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("instrumentId", (List<? extends InstrumentId>) o.getInstrumentId() == null ? 0 : ((List<? extends InstrumentId>) o.getInstrumentId()).size(), 1, 0), 
				checkCardinality("description", (String) o.getDescription() != null ? 1 : 0, 0, 1), 
				checkCardinality("facilityRolesModel", (FacilityRolesModel) o.getFacilityRolesModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("facilityDatesModel", (FacilityDatesModel) o.getFacilityDatesModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("facilityCommitmentModel", (FacilityCommitmentModel) o.getFacilityCommitmentModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("governingLaw", (GoverningLaw) o.getGoverningLaw() != null ? 1 : 0, 0, 1), 
				checkCardinality("facilityFeaturesModel", (FacilityFeaturesModel) o.getFacilityFeaturesModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("facilityOptionsFeesAndRatesModel", (FacilityOptionsFeesAndRatesModel) o.getFacilityOptionsFeesAndRatesModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("multiCurrency", (MultiCurrency) o.getMultiCurrency() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<AbstractFacility> validate(RosettaPath path, AbstractFacility o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AbstractFacility", ValidationType.CARDINALITY, "AbstractFacility", path, "", error);
		}
		return success("AbstractFacility", ValidationType.CARDINALITY, "AbstractFacility", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AbstractFacility o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AbstractFacility", ValidationType.CARDINALITY, "AbstractFacility", path, "", res.getError());
				}
				return success("AbstractFacility", ValidationType.CARDINALITY, "AbstractFacility", path, "");
			})
			.collect(toList());
	}

}
