package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.InstrumentTradeQuantity;
import fpml.confirmation.Money;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class InstrumentTradeQuantityValidator implements Validator<InstrumentTradeQuantity> {

	private List<ComparisonResult> getComparisonResults(InstrumentTradeQuantity o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("number", (BigDecimal) o.getNumber() != null ? 1 : 0, 0, 1), 
				checkCardinality("nominal", (Money) o.getNominal() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<InstrumentTradeQuantity> validate(RosettaPath path, InstrumentTradeQuantity o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("InstrumentTradeQuantity", ValidationType.CARDINALITY, "InstrumentTradeQuantity", path, "", error);
		}
		return success("InstrumentTradeQuantity", ValidationType.CARDINALITY, "InstrumentTradeQuantity", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InstrumentTradeQuantity o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InstrumentTradeQuantity", ValidationType.CARDINALITY, "InstrumentTradeQuantity", path, "", res.getError());
				}
				return success("InstrumentTradeQuantity", ValidationType.CARDINALITY, "InstrumentTradeQuantity", path, "");
			})
			.collect(toList());
	}

}
