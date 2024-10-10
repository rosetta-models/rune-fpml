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
import static com.rosetta.model.lib.expression.ExpressionOperators.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CreditLimitUtilizationPositionSequenceTypeFormatValidator implements Validator<CreditLimitUtilizationPositionSequence> {

	private List<ComparisonResult> getComparisonResults(CreditLimitUtilizationPositionSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("short", o.getShort(), empty(), empty(), of(new BigDecimal("0")), empty()), 
				checkNumber("long", o.getLong(), empty(), empty(), of(new BigDecimal("0")), empty()), 
				checkNumber("global", o.getGlobal(), empty(), empty(), of(new BigDecimal("0")), empty())
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
			return failure("CreditLimitUtilizationPositionSequence", ValidationType.TYPE_FORMAT, "CreditLimitUtilizationPositionSequence", path, "", error);
		}
		return success("CreditLimitUtilizationPositionSequence", ValidationType.TYPE_FORMAT, "CreditLimitUtilizationPositionSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditLimitUtilizationPositionSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditLimitUtilizationPositionSequence", ValidationType.TYPE_FORMAT, "CreditLimitUtilizationPositionSequence", path, "", res.getError());
				}
				return success("CreditLimitUtilizationPositionSequence", ValidationType.TYPE_FORMAT, "CreditLimitUtilizationPositionSequence", path, "");
			})
			.collect(toList());
	}

}
