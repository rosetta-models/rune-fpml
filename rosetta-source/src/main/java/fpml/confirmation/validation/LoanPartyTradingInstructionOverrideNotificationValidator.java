package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.FacilityDetailsModel;
import fpml.confirmation.LoanPartyTradingInstructionOverrideNotification;
import fpml.confirmation.LoanTradeSummary;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.TradingInstructionOverride;
import fpml.confirmation.ValidationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanPartyTradingInstructionOverrideNotificationValidator implements Validator<LoanPartyTradingInstructionOverrideNotification> {

	private List<ComparisonResult> getComparisonResults(LoanPartyTradingInstructionOverrideNotification o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("expectedBuild", (Integer) o.getExpectedBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("actualBuild", (Integer) o.getActualBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("header", (RequestMessageHeader) o.getHeader() != null ? 1 : 0, 1, 1), 
				checkCardinality("validationModel", (ValidationModel) o.getValidationModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("isCorrection", (Boolean) o.getIsCorrection() != null ? 1 : 0, 1, 1), 
				checkCardinality("correlationAndSequenceModel", (CorrelationAndSequenceModel) o.getCorrelationAndSequenceModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("onBehalfOfModel", (OnBehalfOfModel) o.getOnBehalfOfModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("comments", (String) o.getComments() != null ? 1 : 0, 0, 1), 
				checkCardinality("override", (TradingInstructionOverride) o.getOverride() != null ? 1 : 0, 1, 1), 
				checkCardinality("tradeSummary", (LoanTradeSummary) o.getTradeSummary() != null ? 1 : 0, 1, 1), 
				checkCardinality("facilityDetailsModel", (FacilityDetailsModel) o.getFacilityDetailsModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("party", (List<? extends Party>) o.getParty() == null ? 0 : ((List<? extends Party>) o.getParty()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<LoanPartyTradingInstructionOverrideNotification> validate(RosettaPath path, LoanPartyTradingInstructionOverrideNotification o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanPartyTradingInstructionOverrideNotification", ValidationType.CARDINALITY, "LoanPartyTradingInstructionOverrideNotification", path, "", error);
		}
		return success("LoanPartyTradingInstructionOverrideNotification", ValidationType.CARDINALITY, "LoanPartyTradingInstructionOverrideNotification", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanPartyTradingInstructionOverrideNotification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanPartyTradingInstructionOverrideNotification", ValidationType.CARDINALITY, "LoanPartyTradingInstructionOverrideNotification", path, "", res.getError());
				}
				return success("LoanPartyTradingInstructionOverrideNotification", ValidationType.CARDINALITY, "LoanPartyTradingInstructionOverrideNotification", path, "");
			})
			.collect(toList());
	}

}
