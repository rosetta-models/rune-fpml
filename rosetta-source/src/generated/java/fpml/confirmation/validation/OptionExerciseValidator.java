package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ClearingInstructions;
import fpml.confirmation.ExerciseSideEnum;
import fpml.confirmation.ExerciseTimingEnum;
import fpml.confirmation.NonNegativePayment;
import fpml.confirmation.OptionExercise;
import fpml.confirmation.OptionExerciseAmountModel;
import fpml.confirmation.OptionExerciseSequence;
import fpml.confirmation.PartyReference;
import fpml.confirmation.PhysicalSettlement;
import fpml.confirmation.SettlementTypeEnum;
import fpml.confirmation.SimplePayment;
import fpml.confirmation.Trade;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OptionExerciseValidator implements Validator<OptionExercise> {

	private List<ComparisonResult> getComparisonResults(OptionExercise o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("optionSeller", (PartyReference) o.getOptionSeller() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionBuyer", (PartyReference) o.getOptionBuyer() != null ? 1 : 0, 0, 1), 
				checkCardinality("originalTrade", (Trade) o.getOriginalTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionExerciseSequence", (OptionExerciseSequence) o.getOptionExerciseSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseTiming", (ExerciseTimingEnum) o.getExerciseTiming() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionExerciseAmountModel", (OptionExerciseAmountModel) o.getOptionExerciseAmountModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("exerciseSide", (ExerciseSideEnum) o.getExerciseSide() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementType", (SettlementTypeEnum) o.getSettlementType() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashSettlement", (SimplePayment) o.getCashSettlement() != null ? 1 : 0, 0, 1), 
				checkCardinality("physicalSettlement", (PhysicalSettlement) o.getPhysicalSettlement() != null ? 1 : 0, 0, 1), 
				checkCardinality("payment", (NonNegativePayment) o.getPayment() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearingInstructions", (ClearingInstructions) o.getClearingInstructions() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<OptionExercise> validate(RosettaPath path, OptionExercise o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OptionExercise", ValidationType.CARDINALITY, "OptionExercise", path, "", error);
		}
		return success("OptionExercise", ValidationType.CARDINALITY, "OptionExercise", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionExercise", ValidationType.CARDINALITY, "OptionExercise", path, "", res.getError());
				}
				return success("OptionExercise", ValidationType.CARDINALITY, "OptionExercise", path, "");
			})
			.collect(toList());
	}

}
