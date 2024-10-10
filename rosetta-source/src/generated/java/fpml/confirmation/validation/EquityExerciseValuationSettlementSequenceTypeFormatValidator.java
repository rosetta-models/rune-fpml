package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EquityExerciseValuationSettlementSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EquityExerciseValuationSettlementSequenceTypeFormatValidator implements Validator<EquityExerciseValuationSettlementSequence> {

	private List<ComparisonResult> getComparisonResults(EquityExerciseValuationSettlementSequence o) {
		return Lists.<ComparisonResult>newArrayList(
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
			return failure("EquityExerciseValuationSettlementSequence", ValidationType.TYPE_FORMAT, "EquityExerciseValuationSettlementSequence", path, "", error);
		}
		return success("EquityExerciseValuationSettlementSequence", ValidationType.TYPE_FORMAT, "EquityExerciseValuationSettlementSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityExerciseValuationSettlementSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquityExerciseValuationSettlementSequence", ValidationType.TYPE_FORMAT, "EquityExerciseValuationSettlementSequence", path, "", res.getError());
				}
				return success("EquityExerciseValuationSettlementSequence", ValidationType.TYPE_FORMAT, "EquityExerciseValuationSettlementSequence", path, "");
			})
			.collect(toList());
	}

}
