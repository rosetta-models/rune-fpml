package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CreditLimitUtilizationPositionSequence;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CreditLimitUtilizationPositionSequenceValidator implements Validator<CreditLimitUtilizationPositionSequence> {

	private List<ComparisonResult> getComparisonResults(CreditLimitUtilizationPositionSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("short", (BigDecimal) o.getShort() != null ? 1 : 0, 1, 1), 
				checkCardinality("long", (BigDecimal) o.getLong() != null ? 1 : 0, 1, 1), 
				checkCardinality("global", (BigDecimal) o.getGlobal() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CreditLimitUtilizationPositionSequence> validate(RosettaPath path, CreditLimitUtilizationPositionSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CreditLimitUtilizationPositionSequence", ValidationType.CARDINALITY, "CreditLimitUtilizationPositionSequence", path, "", error);
		}
		return success("CreditLimitUtilizationPositionSequence", ValidationType.CARDINALITY, "CreditLimitUtilizationPositionSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditLimitUtilizationPositionSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditLimitUtilizationPositionSequence", ValidationType.CARDINALITY, "CreditLimitUtilizationPositionSequence", path, "", res.getError());
				}
				return success("CreditLimitUtilizationPositionSequence", ValidationType.CARDINALITY, "CreditLimitUtilizationPositionSequence", path, "");
			})
			.collect(toList());
	}

}
