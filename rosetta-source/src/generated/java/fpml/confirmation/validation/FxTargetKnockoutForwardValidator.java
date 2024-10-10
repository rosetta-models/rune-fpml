package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxCashSettlementSimple;
import fpml.confirmation.FxExpirySchedule;
import fpml.confirmation.FxInformationSource;
import fpml.confirmation.FxSettlementSchedule;
import fpml.confirmation.FxTarget;
import fpml.confirmation.FxTargetKnockoutForward;
import fpml.confirmation.FxTargetKnockoutForwardSequence;
import fpml.confirmation.FxTargetLinearPayoffRegion;
import fpml.confirmation.FxTargetSettlementPeriodSchedule;
import fpml.confirmation.NonNegativeAmountSchedule;
import fpml.confirmation.ProductModel;
import fpml.confirmation.QuotedCurrencyPair;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxTargetKnockoutForwardValidator implements Validator<FxTargetKnockoutForward> {

	private List<ComparisonResult> getComparisonResults(FxTargetKnockoutForward o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("quotedCurrencyPair", (QuotedCurrencyPair) o.getQuotedCurrencyPair() != null ? 1 : 0, 1, 1), 
				checkCardinality("notionalAmount", (NonNegativeAmountSchedule) o.getNotionalAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("target", (List<? extends FxTarget>) o.getTarget() == null ? 0 : ((List<? extends FxTarget>) o.getTarget()).size(), 1, 2), 
				checkCardinality("expirySchedule", (FxExpirySchedule) o.getExpirySchedule() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementSchedule", (FxSettlementSchedule) o.getSettlementSchedule() != null ? 1 : 0, 1, 1), 
				checkCardinality("fixingInformationSource", (FxInformationSource) o.getFixingInformationSource() != null ? 1 : 0, 1, 1), 
				checkCardinality("spotRate", (BigDecimal) o.getSpotRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxTargetKnockoutForwardSequence", (FxTargetKnockoutForwardSequence) o.getFxTargetKnockoutForwardSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("linearPayoffRegion", (FxTargetLinearPayoffRegion) o.getLinearPayoffRegion() != null ? 1 : 0, 1, 1), 
				checkCardinality("cashSettlement", (FxCashSettlementSimple) o.getCashSettlement() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementPeriodSchedule", (FxTargetSettlementPeriodSchedule) o.getSettlementPeriodSchedule() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxTargetKnockoutForward> validate(RosettaPath path, FxTargetKnockoutForward o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxTargetKnockoutForward", ValidationType.CARDINALITY, "FxTargetKnockoutForward", path, "", error);
		}
		return success("FxTargetKnockoutForward", ValidationType.CARDINALITY, "FxTargetKnockoutForward", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetKnockoutForward o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetKnockoutForward", ValidationType.CARDINALITY, "FxTargetKnockoutForward", path, "", res.getError());
				}
				return success("FxTargetKnockoutForward", ValidationType.CARDINALITY, "FxTargetKnockoutForward", path, "");
			})
			.collect(toList());
	}

}
