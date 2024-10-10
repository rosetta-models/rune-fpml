package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxForwardVolatilityAgreement;
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

public class FxForwardVolatilityAgreementTypeFormatValidator implements Validator<FxForwardVolatilityAgreement> {

	private List<ComparisonResult> getComparisonResults(FxForwardVolatilityAgreement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("forwardVolatilityStrikePrice", o.getForwardVolatilityStrikePrice(), empty(), empty(), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public ValidationResult<FxForwardVolatilityAgreement> validate(RosettaPath path, FxForwardVolatilityAgreement o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxForwardVolatilityAgreement", ValidationType.TYPE_FORMAT, "FxForwardVolatilityAgreement", path, "", error);
		}
		return success("FxForwardVolatilityAgreement", ValidationType.TYPE_FORMAT, "FxForwardVolatilityAgreement", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxForwardVolatilityAgreement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxForwardVolatilityAgreement", ValidationType.TYPE_FORMAT, "FxForwardVolatilityAgreement", path, "", res.getError());
				}
				return success("FxForwardVolatilityAgreement", ValidationType.TYPE_FORMAT, "FxForwardVolatilityAgreement", path, "");
			})
			.collect(toList());
	}

}
