package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ClearingInstructions;
import fpml.confirmation.ExerciseSideEnum;
import fpml.confirmation.NoTouchRateObservationSequence1;
import fpml.confirmation.NonNegativePayment;
import fpml.confirmation.PhysicalSettlement;
import fpml.confirmation.SettlementTypeEnum;
import fpml.confirmation.SimplePayment;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class NoTouchRateObservationSequence1Validator implements Validator<NoTouchRateObservationSequence1> {

	private List<ComparisonResult> getComparisonResults(NoTouchRateObservationSequence1 o) {
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
	public ValidationResult<NoTouchRateObservationSequence1> validate(RosettaPath path, NoTouchRateObservationSequence1 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NoTouchRateObservationSequence1", ValidationType.CARDINALITY, "NoTouchRateObservationSequence1", path, "", error);
		}
		return success("NoTouchRateObservationSequence1", ValidationType.CARDINALITY, "NoTouchRateObservationSequence1", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NoTouchRateObservationSequence1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NoTouchRateObservationSequence1", ValidationType.CARDINALITY, "NoTouchRateObservationSequence1", path, "", res.getError());
				}
				return success("NoTouchRateObservationSequence1", ValidationType.CARDINALITY, "NoTouchRateObservationSequence1", path, "");
			})
			.collect(toList());
	}

}
