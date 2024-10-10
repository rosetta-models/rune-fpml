package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.VolatilityCapSequence;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class VolatilityCapSequenceValidator implements Validator<VolatilityCapSequence> {

	private List<ComparisonResult> getComparisonResults(VolatilityCapSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("volatilityCapFactor", (BigDecimal) o.getVolatilityCapFactor() != null ? 1 : 0, 1, 1), 
				checkCardinality("totalVolatilityCap", (BigDecimal) o.getTotalVolatilityCap() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<VolatilityCapSequence> validate(RosettaPath path, VolatilityCapSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("VolatilityCapSequence", ValidationType.CARDINALITY, "VolatilityCapSequence", path, "", error);
		}
		return success("VolatilityCapSequence", ValidationType.CARDINALITY, "VolatilityCapSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VolatilityCapSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VolatilityCapSequence", ValidationType.CARDINALITY, "VolatilityCapSequence", path, "", res.getError());
				}
				return success("VolatilityCapSequence", ValidationType.CARDINALITY, "VolatilityCapSequence", path, "");
			})
			.collect(toList());
	}

}
