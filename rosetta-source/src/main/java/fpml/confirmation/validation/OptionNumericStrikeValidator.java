package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.OptionNumericStrike;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OptionNumericStrikeValidator implements Validator<OptionNumericStrike> {

	private List<ComparisonResult> getComparisonResults(OptionNumericStrike o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("strikePrice", (BigDecimal) o.getStrikePrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("strikePercentage", (BigDecimal) o.getStrikePercentage() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<OptionNumericStrike> validate(RosettaPath path, OptionNumericStrike o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OptionNumericStrike", ValidationType.CARDINALITY, "OptionNumericStrike", path, "", error);
		}
		return success("OptionNumericStrike", ValidationType.CARDINALITY, "OptionNumericStrike", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionNumericStrike o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionNumericStrike", ValidationType.CARDINALITY, "OptionNumericStrike", path, "", res.getError());
				}
				return success("OptionNumericStrike", ValidationType.CARDINALITY, "OptionNumericStrike", path, "");
			})
			.collect(toList());
	}

}
