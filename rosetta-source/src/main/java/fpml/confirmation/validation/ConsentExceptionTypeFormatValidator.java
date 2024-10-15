package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ConsentException;
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

public class ConsentExceptionTypeFormatValidator implements Validator<ConsentException> {

	private List<ComparisonResult> getComparisonResults(ConsentException o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("expectedBuild", o.getExpectedBuild(), empty(), of(0), of(new BigDecimal("1")), empty()), 
				checkNumber("actualBuild", o.getActualBuild(), empty(), of(0), of(new BigDecimal("1")), empty())
			);
	}

	@Override
	public ValidationResult<ConsentException> validate(RosettaPath path, ConsentException o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ConsentException", ValidationType.TYPE_FORMAT, "ConsentException", path, "", error);
		}
		return success("ConsentException", ValidationType.TYPE_FORMAT, "ConsentException", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ConsentException o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ConsentException", ValidationType.TYPE_FORMAT, "ConsentException", path, "", res.getError());
				}
				return success("ConsentException", ValidationType.TYPE_FORMAT, "ConsentException", path, "");
			})
			.collect(toList());
	}

}
