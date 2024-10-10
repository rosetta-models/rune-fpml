package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxOutstandingGain;
import fpml.confirmation.FxSettlementAdjustmentMethodEnum;
import fpml.confirmation.FxTargetReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxOutstandingGainValidator implements Validator<FxOutstandingGain> {

	private List<ComparisonResult> getComparisonResults(FxOutstandingGain o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("targetReference", (FxTargetReference) o.getTargetReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementAdjustmentStyle", (FxSettlementAdjustmentMethodEnum) o.getSettlementAdjustmentStyle() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxOutstandingGain> validate(RosettaPath path, FxOutstandingGain o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxOutstandingGain", ValidationType.CARDINALITY, "FxOutstandingGain", path, "", error);
		}
		return success("FxOutstandingGain", ValidationType.CARDINALITY, "FxOutstandingGain", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxOutstandingGain o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxOutstandingGain", ValidationType.CARDINALITY, "FxOutstandingGain", path, "", res.getError());
				}
				return success("FxOutstandingGain", ValidationType.CARDINALITY, "FxOutstandingGain", path, "");
			})
			.collect(toList());
	}

}
