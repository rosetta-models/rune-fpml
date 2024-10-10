package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.EquityValuation;
import fpml.confirmation.FxFeature;
import fpml.confirmation.OptionSettlementModel;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.Underlyer;
import fpml.confirmation.VarianceAmount;
import fpml.confirmation.VarianceLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class VarianceLegValidator implements Validator<VarianceLeg> {

	private List<ComparisonResult> getComparisonResults(VarianceLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerReceiverModel", (PayerReceiverModel) o.getPayerReceiverModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("effectiveDate", (AdjustableOrRelativeDate) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("terminationDate", (AdjustableOrRelativeDate) o.getTerminationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyer", (Underlyer) o.getUnderlyer() != null ? 1 : 0, 1, 1), 
				checkCardinality("optionSettlementModel", (OptionSettlementModel) o.getOptionSettlementModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("fxFeature", (FxFeature) o.getFxFeature() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuation", (EquityValuation) o.getValuation() != null ? 1 : 0, 1, 1), 
				checkCardinality("amount", (VarianceAmount) o.getAmount() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<VarianceLeg> validate(RosettaPath path, VarianceLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("VarianceLeg", ValidationType.CARDINALITY, "VarianceLeg", path, "", error);
		}
		return success("VarianceLeg", ValidationType.CARDINALITY, "VarianceLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VarianceLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VarianceLeg", ValidationType.CARDINALITY, "VarianceLeg", path, "", res.getError());
				}
				return success("VarianceLeg", ValidationType.CARDINALITY, "VarianceLeg", path, "");
			})
			.collect(toList());
	}

}
