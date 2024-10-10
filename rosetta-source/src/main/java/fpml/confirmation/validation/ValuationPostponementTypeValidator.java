package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ValuationPostponementType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ValuationPostponementTypeValidator implements Validator<ValuationPostponementType> {

	private List<ComparisonResult> getComparisonResults(ValuationPostponementType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("maximumDaysOfPostponement", (Integer) o.getMaximumDaysOfPostponement() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<ValuationPostponementType> validate(RosettaPath path, ValuationPostponementType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ValuationPostponementType", ValidationType.CARDINALITY, "ValuationPostponementType", path, "", error);
		}
		return success("ValuationPostponementType", ValidationType.CARDINALITY, "ValuationPostponementType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ValuationPostponementType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ValuationPostponementType", ValidationType.CARDINALITY, "ValuationPostponementType", path, "", res.getError());
				}
				return success("ValuationPostponementType", ValidationType.CARDINALITY, "ValuationPostponementType", path, "");
			})
			.collect(toList());
	}

}
