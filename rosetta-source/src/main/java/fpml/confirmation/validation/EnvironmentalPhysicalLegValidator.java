package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.BusinessCentersOrReferenceModel;
import fpml.confirmation.DateOffset;
import fpml.confirmation.EEPParameters;
import fpml.confirmation.EnvironmentalAbandonmentOfSchemeEnum;
import fpml.confirmation.EnvironmentalPhysicalLeg;
import fpml.confirmation.EnvironmentalProduct;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.UnitQuantity;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EnvironmentalPhysicalLegValidator implements Validator<EnvironmentalPhysicalLeg> {

	private List<ComparisonResult> getComparisonResults(EnvironmentalPhysicalLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerReceiverModel", (PayerReceiverModel) o.getPayerReceiverModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("numberOfAllowances", (UnitQuantity) o.getNumberOfAllowances() != null ? 1 : 0, 1, 1), 
				checkCardinality("environmental", (EnvironmentalProduct) o.getEnvironmental() != null ? 1 : 0, 1, 1), 
				checkCardinality("abandonmentOfScheme", (EnvironmentalAbandonmentOfSchemeEnum) o.getAbandonmentOfScheme() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryDate", (AdjustableOrRelativeDate) o.getDeliveryDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("paymentDate", (DateOffset) o.getPaymentDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("businessCentersOrReferenceModel", (BusinessCentersOrReferenceModel) o.getBusinessCentersOrReferenceModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("failureToDeliverApplicable", (Boolean) o.getFailureToDeliverApplicable() != null ? 1 : 0, 0, 1), 
				checkCardinality("eEPParameters", (EEPParameters) o.getEEPParameters() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<EnvironmentalPhysicalLeg> validate(RosettaPath path, EnvironmentalPhysicalLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EnvironmentalPhysicalLeg", ValidationType.CARDINALITY, "EnvironmentalPhysicalLeg", path, "", error);
		}
		return success("EnvironmentalPhysicalLeg", ValidationType.CARDINALITY, "EnvironmentalPhysicalLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EnvironmentalPhysicalLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EnvironmentalPhysicalLeg", ValidationType.CARDINALITY, "EnvironmentalPhysicalLeg", path, "", res.getError());
				}
				return success("EnvironmentalPhysicalLeg", ValidationType.CARDINALITY, "EnvironmentalPhysicalLeg", path, "");
			})
			.collect(toList());
	}

}
