package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ConditionEnum;
import fpml.confirmation.FxAccrualBarrier;
import fpml.confirmation.FxAccrualBarrierSequence;
import fpml.confirmation.FxAccrualKnockoutBarrierRetentionEnum;
import fpml.confirmation.FxBarrierScopeEnum;
import fpml.confirmation.FxBarrierStyleEnum;
import fpml.confirmation.FxBarrierTypeSimpleEnum;
import fpml.confirmation.FxComplexBarrierBaseSequence0;
import fpml.confirmation.FxComplexBarrierBaseSequence1;
import fpml.confirmation.FxRateObservableReference;
import fpml.confirmation.Schedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAccrualBarrierValidator implements Validator<FxAccrualBarrier> {

	private List<ComparisonResult> getComparisonResults(FxAccrualBarrier o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("barrierType", (FxBarrierTypeSimpleEnum) o.getBarrierType() != null ? 1 : 0, 1, 1), 
				checkCardinality("style", (FxBarrierStyleEnum) o.getStyle() != null ? 1 : 0, 1, 1), 
				checkCardinality("scope", (FxBarrierScopeEnum) o.getScope() != null ? 1 : 0, 1, 1), 
				checkCardinality("condition", (ConditionEnum) o.getCondition() != null ? 1 : 0, 1, 1), 
				checkCardinality("triggerRate", (Schedule) o.getTriggerRate() != null ? 1 : 0, 1, 1), 
				checkCardinality("fxComplexBarrierBaseSequence0", (FxComplexBarrierBaseSequence0) o.getFxComplexBarrierBaseSequence0() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxComplexBarrierBaseSequence1", (FxComplexBarrierBaseSequence1) o.getFxComplexBarrierBaseSequence1() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("accrualRetention", (FxAccrualKnockoutBarrierRetentionEnum) o.getAccrualRetention() != null ? 1 : 0, 0, 1), 
				checkCardinality("observableReference", (FxRateObservableReference) o.getObservableReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxAccrualBarrierSequence", (FxAccrualBarrierSequence) o.getFxAccrualBarrierSequence() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxAccrualBarrier> validate(RosettaPath path, FxAccrualBarrier o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAccrualBarrier", ValidationType.CARDINALITY, "FxAccrualBarrier", path, "", error);
		}
		return success("FxAccrualBarrier", ValidationType.CARDINALITY, "FxAccrualBarrier", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualBarrier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualBarrier", ValidationType.CARDINALITY, "FxAccrualBarrier", path, "", res.getError());
				}
				return success("FxAccrualBarrier", ValidationType.CARDINALITY, "FxAccrualBarrier", path, "");
			})
			.collect(toList());
	}

}
