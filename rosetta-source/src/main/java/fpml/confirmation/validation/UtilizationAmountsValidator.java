package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.UtilizationAmounts;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class UtilizationAmountsValidator implements Validator<UtilizationAmounts> {

	private List<ComparisonResult> getComparisonResults(UtilizationAmounts o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fundedAmount", (BigDecimal) o.getFundedAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("unfundedAmount", (BigDecimal) o.getUnfundedAmount() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<UtilizationAmounts> validate(RosettaPath path, UtilizationAmounts o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("UtilizationAmounts", ValidationType.CARDINALITY, "UtilizationAmounts", path, "", error);
		}
		return success("UtilizationAmounts", ValidationType.CARDINALITY, "UtilizationAmounts", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, UtilizationAmounts o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("UtilizationAmounts", ValidationType.CARDINALITY, "UtilizationAmounts", path, "", res.getError());
				}
				return success("UtilizationAmounts", ValidationType.CARDINALITY, "UtilizationAmounts", path, "");
			})
			.collect(toList());
	}

}
