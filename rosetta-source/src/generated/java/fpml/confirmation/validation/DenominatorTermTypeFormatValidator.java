package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DenominatorTerm;
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

public class DenominatorTermTypeFormatValidator implements Validator<DenominatorTerm> {

	private List<ComparisonResult> getComparisonResults(DenominatorTerm o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("power", o.getPower(), empty(), of(0), of(new BigDecimal("1")), empty())
			);
	}

	@Override
	public ValidationResult<DenominatorTerm> validate(RosettaPath path, DenominatorTerm o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DenominatorTerm", ValidationType.TYPE_FORMAT, "DenominatorTerm", path, "", error);
		}
		return success("DenominatorTerm", ValidationType.TYPE_FORMAT, "DenominatorTerm", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DenominatorTerm o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DenominatorTerm", ValidationType.TYPE_FORMAT, "DenominatorTerm", path, "", res.getError());
				}
				return success("DenominatorTerm", ValidationType.TYPE_FORMAT, "DenominatorTerm", path, "");
			})
			.collect(toList());
	}

}
