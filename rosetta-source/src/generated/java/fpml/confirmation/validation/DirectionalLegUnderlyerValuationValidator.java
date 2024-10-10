package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.DirectionalLegUnderlyerValuation;
import fpml.confirmation.EquityValuation;
import fpml.confirmation.FxFeature;
import fpml.confirmation.OptionSettlementModel;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.Underlyer;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DirectionalLegUnderlyerValuationValidator implements Validator<DirectionalLegUnderlyerValuation> {

	private List<ComparisonResult> getComparisonResults(DirectionalLegUnderlyerValuation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerReceiverModel", (PayerReceiverModel) o.getPayerReceiverModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("effectiveDate", (AdjustableOrRelativeDate) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("terminationDate", (AdjustableOrRelativeDate) o.getTerminationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyer", (Underlyer) o.getUnderlyer() != null ? 1 : 0, 1, 1), 
				checkCardinality("optionSettlementModel", (OptionSettlementModel) o.getOptionSettlementModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("fxFeature", (FxFeature) o.getFxFeature() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuation", (EquityValuation) o.getValuation() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<DirectionalLegUnderlyerValuation> validate(RosettaPath path, DirectionalLegUnderlyerValuation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DirectionalLegUnderlyerValuation", ValidationType.CARDINALITY, "DirectionalLegUnderlyerValuation", path, "", error);
		}
		return success("DirectionalLegUnderlyerValuation", ValidationType.CARDINALITY, "DirectionalLegUnderlyerValuation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DirectionalLegUnderlyerValuation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DirectionalLegUnderlyerValuation", ValidationType.CARDINALITY, "DirectionalLegUnderlyerValuation", path, "", res.getError());
				}
				return success("DirectionalLegUnderlyerValuation", ValidationType.CARDINALITY, "DirectionalLegUnderlyerValuation", path, "");
			})
			.collect(toList());
	}

}
