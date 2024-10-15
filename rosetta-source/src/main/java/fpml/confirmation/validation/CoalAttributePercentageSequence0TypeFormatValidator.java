package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CoalAttributePercentageSequence0;
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

public class CoalAttributePercentageSequence0TypeFormatValidator implements Validator<CoalAttributePercentageSequence0> {

	private List<ComparisonResult> getComparisonResults(CoalAttributePercentageSequence0 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("standardContent", o.getStandardContent(), empty(), empty(), of(new BigDecimal("0")), of(new BigDecimal("1"))), 
				checkNumber("rejectionLimit", o.getRejectionLimit(), empty(), empty(), of(new BigDecimal("0")), of(new BigDecimal("1")))
			);
	}

	@Override
	public ValidationResult<CoalAttributePercentageSequence0> validate(RosettaPath path, CoalAttributePercentageSequence0 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CoalAttributePercentageSequence0", ValidationType.TYPE_FORMAT, "CoalAttributePercentageSequence0", path, "", error);
		}
		return success("CoalAttributePercentageSequence0", ValidationType.TYPE_FORMAT, "CoalAttributePercentageSequence0", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CoalAttributePercentageSequence0 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CoalAttributePercentageSequence0", ValidationType.TYPE_FORMAT, "CoalAttributePercentageSequence0", path, "", res.getError());
				}
				return success("CoalAttributePercentageSequence0", ValidationType.TYPE_FORMAT, "CoalAttributePercentageSequence0", path, "");
			})
			.collect(toList());
	}

}
