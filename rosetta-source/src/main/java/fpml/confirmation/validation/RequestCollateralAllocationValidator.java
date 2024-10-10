package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.PartyReference;
import fpml.confirmation.ProposedCollateralAllocation;
import fpml.confirmation.RequestCollateralAllocation;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.RequestedCollateralAllocationAction;
import fpml.confirmation.ValidationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RequestCollateralAllocationValidator implements Validator<RequestCollateralAllocation> {

	private List<ComparisonResult> getComparisonResults(RequestCollateralAllocation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("expectedBuild", (Integer) o.getExpectedBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("actualBuild", (Integer) o.getActualBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("header", (RequestMessageHeader) o.getHeader() != null ? 1 : 0, 1, 1), 
				checkCardinality("validationModel", (ValidationModel) o.getValidationModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("isCorrection", (Boolean) o.getIsCorrection() != null ? 1 : 0, 1, 1), 
				checkCardinality("correlationAndSequenceModel", (CorrelationAndSequenceModel) o.getCorrelationAndSequenceModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("onBehalfOfModel", (OnBehalfOfModel) o.getOnBehalfOfModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("serviceName", (String) o.getServiceName() != null ? 1 : 0, 0, 1), 
				checkCardinality("requestedAction", (RequestedCollateralAllocationAction) o.getRequestedAction() != null ? 1 : 0, 0, 1), 
				checkCardinality("collateralGiverPartyReference", (PartyReference) o.getCollateralGiverPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("collateralAllocation", (List<? extends ProposedCollateralAllocation>) o.getCollateralAllocation() == null ? 0 : ((List<? extends ProposedCollateralAllocation>) o.getCollateralAllocation()).size(), 1, 0), 
				checkCardinality("partiesAndAccountsModel", (PartiesAndAccountsModel) o.getPartiesAndAccountsModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<RequestCollateralAllocation> validate(RosettaPath path, RequestCollateralAllocation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RequestCollateralAllocation", ValidationType.CARDINALITY, "RequestCollateralAllocation", path, "", error);
		}
		return success("RequestCollateralAllocation", ValidationType.CARDINALITY, "RequestCollateralAllocation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RequestCollateralAllocation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RequestCollateralAllocation", ValidationType.CARDINALITY, "RequestCollateralAllocation", path, "", res.getError());
				}
				return success("RequestCollateralAllocation", ValidationType.CARDINALITY, "RequestCollateralAllocation", path, "");
			})
			.collect(toList());
	}

}
