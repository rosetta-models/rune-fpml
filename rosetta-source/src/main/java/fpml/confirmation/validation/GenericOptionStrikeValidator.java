package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Currency;
import fpml.confirmation.EquityStrikeSequence;
import fpml.confirmation.GenericOptionStrike;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class GenericOptionStrikeValidator implements Validator<GenericOptionStrike> {

	private List<ComparisonResult> getComparisonResults(GenericOptionStrike o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("strikePrice", (BigDecimal) o.getStrikePrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("equityStrikeSequence", (EquityStrikeSequence) o.getEquityStrikeSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("currency", (Currency) o.getCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("units", (String) o.getUnits() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<GenericOptionStrike> validate(RosettaPath path, GenericOptionStrike o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("GenericOptionStrike", ValidationType.CARDINALITY, "GenericOptionStrike", path, "", error);
		}
		return success("GenericOptionStrike", ValidationType.CARDINALITY, "GenericOptionStrike", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericOptionStrike o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GenericOptionStrike", ValidationType.CARDINALITY, "GenericOptionStrike", path, "", res.getError());
				}
				return success("GenericOptionStrike", ValidationType.CARDINALITY, "GenericOptionStrike", path, "");
			})
			.collect(toList());
	}

}
