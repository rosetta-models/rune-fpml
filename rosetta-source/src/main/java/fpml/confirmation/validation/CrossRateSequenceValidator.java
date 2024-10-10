package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CrossRateSequence;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CrossRateSequenceValidator implements Validator<CrossRateSequence> {

	private List<ComparisonResult> getComparisonResults(CrossRateSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("spotRate", (BigDecimal) o.getSpotRate() != null ? 1 : 0, 1, 1), 
				checkCardinality("forwardPoints", (BigDecimal) o.getForwardPoints() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CrossRateSequence> validate(RosettaPath path, CrossRateSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CrossRateSequence", ValidationType.CARDINALITY, "CrossRateSequence", path, "", error);
		}
		return success("CrossRateSequence", ValidationType.CARDINALITY, "CrossRateSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CrossRateSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CrossRateSequence", ValidationType.CARDINALITY, "CrossRateSequence", path, "", res.getError());
				}
				return success("CrossRateSequence", ValidationType.CARDINALITY, "CrossRateSequence", path, "");
			})
			.collect(toList());
	}

}
