package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ClearingInstructions;
import fpml.confirmation.ExerciseSideEnum;
import fpml.confirmation.NonNegativePayment;
import fpml.confirmation.PhysicalSettlement;
import fpml.confirmation.SettlementTypeEnum;
import fpml.confirmation.SimplePayment;
import fpml.confirmation.TouchRateObservationSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TouchRateObservationSequenceValidator implements Validator<TouchRateObservationSequence> {

	private List<ComparisonResult> getComparisonResults(TouchRateObservationSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("exerciseSide", (ExerciseSideEnum) o.getExerciseSide() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementType", (SettlementTypeEnum) o.getSettlementType() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashSettlement", (SimplePayment) o.getCashSettlement() != null ? 1 : 0, 0, 1), 
				checkCardinality("physicalSettlement", (PhysicalSettlement) o.getPhysicalSettlement() != null ? 1 : 0, 0, 1), 
				checkCardinality("payment", (NonNegativePayment) o.getPayment() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearingInstructions", (ClearingInstructions) o.getClearingInstructions() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<TouchRateObservationSequence> validate(RosettaPath path, TouchRateObservationSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TouchRateObservationSequence", ValidationType.CARDINALITY, "TouchRateObservationSequence", path, "", error);
		}
		return success("TouchRateObservationSequence", ValidationType.CARDINALITY, "TouchRateObservationSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TouchRateObservationSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TouchRateObservationSequence", ValidationType.CARDINALITY, "TouchRateObservationSequence", path, "", res.getError());
				}
				return success("TouchRateObservationSequence", ValidationType.CARDINALITY, "TouchRateObservationSequence", path, "");
			})
			.collect(toList());
	}

}
