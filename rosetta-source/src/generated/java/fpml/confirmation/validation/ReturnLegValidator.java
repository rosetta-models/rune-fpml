package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.AveragingPeriod;
import fpml.confirmation.FxFeature;
import fpml.confirmation.NotionalAdjustmentEnum;
import fpml.confirmation.OptionSettlementModel;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.Return;
import fpml.confirmation.ReturnLeg;
import fpml.confirmation.ReturnLegValuation;
import fpml.confirmation.ReturnSwapAmount;
import fpml.confirmation.ReturnSwapNotional;
import fpml.confirmation.Underlyer;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReturnLegValidator implements Validator<ReturnLeg> {

	private List<ComparisonResult> getComparisonResults(ReturnLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerReceiverModel", (PayerReceiverModel) o.getPayerReceiverModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("effectiveDate", (AdjustableOrRelativeDate) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("terminationDate", (AdjustableOrRelativeDate) o.getTerminationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("strikeDate", (AdjustableOrRelativeDate) o.getStrikeDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyer", (Underlyer) o.getUnderlyer() != null ? 1 : 0, 1, 1), 
				checkCardinality("optionSettlementModel", (OptionSettlementModel) o.getOptionSettlementModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("rateOfReturn", (ReturnLegValuation) o.getRateOfReturn() != null ? 1 : 0, 1, 1), 
				checkCardinality("notional", (ReturnSwapNotional) o.getNotional() != null ? 1 : 0, 1, 1), 
				checkCardinality("amount", (ReturnSwapAmount) o.getAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("return", (Return) o.getReturn() != null ? 1 : 0, 1, 1), 
				checkCardinality("notionalAdjustments", (NotionalAdjustmentEnum) o.getNotionalAdjustments() != null ? 1 : 0, 1, 1), 
				checkCardinality("fxFeature", (FxFeature) o.getFxFeature() != null ? 1 : 0, 0, 1), 
				checkCardinality("averagingDates", (AveragingPeriod) o.getAveragingDates() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ReturnLeg> validate(RosettaPath path, ReturnLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReturnLeg", ValidationType.CARDINALITY, "ReturnLeg", path, "", error);
		}
		return success("ReturnLeg", ValidationType.CARDINALITY, "ReturnLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReturnLeg", ValidationType.CARDINALITY, "ReturnLeg", path, "", res.getError());
				}
				return success("ReturnLeg", ValidationType.CARDINALITY, "ReturnLeg", path, "");
			})
			.collect(toList());
	}

}
