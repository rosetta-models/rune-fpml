package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.OptionElement;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkNumber;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OptionElementTypeFormatValidator implements Validator<OptionElement> {

	private List<ComparisonResult> getComparisonResults(OptionElement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("description", o.getDescription(), 0, of(255), empty()), 
				checkNumber("multiplier", o.getMultiplier(), empty(), empty(), of(new BigDecimal("0")), empty()), 
				checkString("contractReference", o.getContractReference(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<OptionElement> validate(RosettaPath path, OptionElement o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OptionElement", ValidationType.TYPE_FORMAT, "OptionElement", path, "", error);
		}
		return success("OptionElement", ValidationType.TYPE_FORMAT, "OptionElement", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionElement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionElement", ValidationType.TYPE_FORMAT, "OptionElement", path, "", res.getError());
				}
				return success("OptionElement", ValidationType.TYPE_FORMAT, "OptionElement", path, "");
			})
			.collect(toList());
	}

}
