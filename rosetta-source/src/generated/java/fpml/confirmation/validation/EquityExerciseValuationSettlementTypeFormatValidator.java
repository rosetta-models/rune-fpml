package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EquityExerciseValuationSettlement;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EquityExerciseValuationSettlementTypeFormatValidator implements Validator<EquityExerciseValuationSettlement> {

	private List<ComparisonResult> getComparisonResults(EquityExerciseValuationSettlement o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<EquityExerciseValuationSettlement> validate(RosettaPath path, EquityExerciseValuationSettlement o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EquityExerciseValuationSettlement", ValidationType.TYPE_FORMAT, "EquityExerciseValuationSettlement", path, "", error);
		}
		return success("EquityExerciseValuationSettlement", ValidationType.TYPE_FORMAT, "EquityExerciseValuationSettlement", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityExerciseValuationSettlement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquityExerciseValuationSettlement", ValidationType.TYPE_FORMAT, "EquityExerciseValuationSettlement", path, "", res.getError());
				}
				return success("EquityExerciseValuationSettlement", ValidationType.TYPE_FORMAT, "EquityExerciseValuationSettlement", path, "");
			})
			.collect(toList());
	}

}
