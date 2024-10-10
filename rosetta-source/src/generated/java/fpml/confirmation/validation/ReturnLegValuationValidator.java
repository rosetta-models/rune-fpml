package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ExchangeTradedContract;
import fpml.confirmation.ReturnLegValuation;
import fpml.confirmation.ReturnLegValuationPrice;
import fpml.confirmation.ReturnSwapPaymentDates;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReturnLegValuationValidator implements Validator<ReturnLegValuation> {

	private List<ComparisonResult> getComparisonResults(ReturnLegValuation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("initialPrice", (ReturnLegValuationPrice) o.getInitialPrice() != null ? 1 : 0, 1, 1), 
				checkCardinality("notionalReset", (Boolean) o.getNotionalReset() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationPriceInterim", (ReturnLegValuationPrice) o.getValuationPriceInterim() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationPriceFinal", (ReturnLegValuationPrice) o.getValuationPriceFinal() != null ? 1 : 0, 1, 1), 
				checkCardinality("paymentDates", (ReturnSwapPaymentDates) o.getPaymentDates() != null ? 1 : 0, 1, 1), 
				checkCardinality("exchangeTradedContractNearest", (ExchangeTradedContract) o.getExchangeTradedContractNearest() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ReturnLegValuation> validate(RosettaPath path, ReturnLegValuation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReturnLegValuation", ValidationType.CARDINALITY, "ReturnLegValuation", path, "", error);
		}
		return success("ReturnLegValuation", ValidationType.CARDINALITY, "ReturnLegValuation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnLegValuation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReturnLegValuation", ValidationType.CARDINALITY, "ReturnLegValuation", path, "", res.getError());
				}
				return success("ReturnLegValuation", ValidationType.CARDINALITY, "ReturnLegValuation", path, "");
			})
			.collect(toList());
	}

}
