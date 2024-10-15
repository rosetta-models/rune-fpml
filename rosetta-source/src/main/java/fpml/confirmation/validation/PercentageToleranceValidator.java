package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PartyReference;
import fpml.confirmation.PercentageTolerance;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PercentageToleranceValidator implements Validator<PercentageTolerance> {

	private List<ComparisonResult> getComparisonResults(PercentageTolerance o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("postitive", (BigDecimal) o.getPostitive() != null ? 1 : 0, 1, 1), 
				checkCardinality("negative", (BigDecimal) o.getNegative() != null ? 1 : 0, 1, 1), 
				checkCardinality("option", (PartyReference) o.getOption() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<PercentageTolerance> validate(RosettaPath path, PercentageTolerance o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PercentageTolerance", ValidationType.CARDINALITY, "PercentageTolerance", path, "", error);
		}
		return success("PercentageTolerance", ValidationType.CARDINALITY, "PercentageTolerance", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PercentageTolerance o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PercentageTolerance", ValidationType.CARDINALITY, "PercentageTolerance", path, "", res.getError());
				}
				return success("PercentageTolerance", ValidationType.CARDINALITY, "PercentageTolerance", path, "");
			})
			.collect(toList());
	}

}
