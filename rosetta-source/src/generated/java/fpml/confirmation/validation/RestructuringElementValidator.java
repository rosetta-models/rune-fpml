package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Money;
import fpml.confirmation.RestructuringElement;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RestructuringElementValidator implements Validator<RestructuringElement> {

	private List<ComparisonResult> getComparisonResults(RestructuringElement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partialExerciseAmount", (Money) o.getPartialExerciseAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<RestructuringElement> validate(RosettaPath path, RestructuringElement o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RestructuringElement", ValidationType.CARDINALITY, "RestructuringElement", path, "", error);
		}
		return success("RestructuringElement", ValidationType.CARDINALITY, "RestructuringElement", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RestructuringElement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RestructuringElement", ValidationType.CARDINALITY, "RestructuringElement", path, "", res.getError());
				}
				return success("RestructuringElement", ValidationType.CARDINALITY, "RestructuringElement", path, "");
			})
			.collect(toList());
	}

}
