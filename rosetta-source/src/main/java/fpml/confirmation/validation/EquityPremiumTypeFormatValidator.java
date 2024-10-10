package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EquityPremium;
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

public class EquityPremiumTypeFormatValidator implements Validator<EquityPremium> {

	private List<ComparisonResult> getComparisonResults(EquityPremium o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("percentageOfNotional", o.getPercentageOfNotional(), empty(), empty(), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public ValidationResult<EquityPremium> validate(RosettaPath path, EquityPremium o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EquityPremium", ValidationType.TYPE_FORMAT, "EquityPremium", path, "", error);
		}
		return success("EquityPremium", ValidationType.TYPE_FORMAT, "EquityPremium", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityPremium o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquityPremium", ValidationType.TYPE_FORMAT, "EquityPremium", path, "", res.getError());
				}
				return success("EquityPremium", ValidationType.TYPE_FORMAT, "EquityPremium", path, "");
			})
			.collect(toList());
	}

}
