package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EquityExerciseValuationSettlementSequence;
import fpml.confirmation.MakeWholeProvisions;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EquityExerciseValuationSettlementSequenceValidator implements Validator<EquityExerciseValuationSettlementSequence> {

	private List<ComparisonResult> getComparisonResults(EquityExerciseValuationSettlementSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("automaticExercise", (Boolean) o.getAutomaticExercise() != null ? 1 : 0, 1, 1), 
				checkCardinality("makeWholeProvisions", (MakeWholeProvisions) o.getMakeWholeProvisions() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<EquityExerciseValuationSettlementSequence> validate(RosettaPath path, EquityExerciseValuationSettlementSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EquityExerciseValuationSettlementSequence", ValidationType.CARDINALITY, "EquityExerciseValuationSettlementSequence", path, "", error);
		}
		return success("EquityExerciseValuationSettlementSequence", ValidationType.CARDINALITY, "EquityExerciseValuationSettlementSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityExerciseValuationSettlementSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquityExerciseValuationSettlementSequence", ValidationType.CARDINALITY, "EquityExerciseValuationSettlementSequence", path, "", res.getError());
				}
				return success("EquityExerciseValuationSettlementSequence", ValidationType.CARDINALITY, "EquityExerciseValuationSettlementSequence", path, "");
			})
			.collect(toList());
	}

}
