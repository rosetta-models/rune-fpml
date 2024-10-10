package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.StockLoanModel;
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

public class StockLoanModelTypeFormatValidator implements Validator<StockLoanModel> {

	private List<ComparisonResult> getComparisonResults(StockLoanModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("maximumStockLoanRate", o.getMaximumStockLoanRate(), empty(), empty(), of(new BigDecimal("0")), of(new BigDecimal("1"))), 
				checkNumber("initialStockLoanRate", o.getInitialStockLoanRate(), empty(), empty(), of(new BigDecimal("0")), of(new BigDecimal("1")))
			);
	}

	@Override
	public ValidationResult<StockLoanModel> validate(RosettaPath path, StockLoanModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("StockLoanModel", ValidationType.TYPE_FORMAT, "StockLoanModel", path, "", error);
		}
		return success("StockLoanModel", ValidationType.TYPE_FORMAT, "StockLoanModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, StockLoanModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("StockLoanModel", ValidationType.TYPE_FORMAT, "StockLoanModel", path, "", res.getError());
				}
				return success("StockLoanModel", ValidationType.TYPE_FORMAT, "StockLoanModel", path, "");
			})
			.collect(toList());
	}

}
