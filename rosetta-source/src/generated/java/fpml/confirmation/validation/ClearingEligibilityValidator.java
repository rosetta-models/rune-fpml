package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ClearingEligibility;
import fpml.confirmation.CorrelationAndOptionalSequenceModel;
import fpml.confirmation.DeClear;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.ResponseMessageHeader;
import fpml.confirmation.TradingEventsModel;
import fpml.confirmation.ValidationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ClearingEligibilityValidator implements Validator<ClearingEligibility> {

	private List<ComparisonResult> getComparisonResults(ClearingEligibility o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("expectedBuild", (Integer) o.getExpectedBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("actualBuild", (Integer) o.getActualBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("header", (ResponseMessageHeader) o.getHeader() != null ? 1 : 0, 1, 1), 
				checkCardinality("validationModel", (ValidationModel) o.getValidationModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("correlationAndOptionalSequenceModel", (CorrelationAndOptionalSequenceModel) o.getCorrelationAndOptionalSequenceModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("onBehalfOfModel", (OnBehalfOfModel) o.getOnBehalfOfModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradingEventsModel", (TradingEventsModel) o.getTradingEventsModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("deClear", (DeClear) o.getDeClear() != null ? 1 : 0, 0, 1), 
				checkCardinality("partyTradeIdentifier", (PartyTradeIdentifier) o.getPartyTradeIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("eligibleForClearing", (Boolean) o.getEligibleForClearing() != null ? 1 : 0, 1, 1), 
				checkCardinality("partiesAndAccountsModel", (PartiesAndAccountsModel) o.getPartiesAndAccountsModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<ClearingEligibility> validate(RosettaPath path, ClearingEligibility o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ClearingEligibility", ValidationType.CARDINALITY, "ClearingEligibility", path, "", error);
		}
		return success("ClearingEligibility", ValidationType.CARDINALITY, "ClearingEligibility", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ClearingEligibility o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ClearingEligibility", ValidationType.CARDINALITY, "ClearingEligibility", path, "", res.getError());
				}
				return success("ClearingEligibility", ValidationType.CARDINALITY, "ClearingEligibility", path, "");
			})
			.collect(toList());
	}

}
