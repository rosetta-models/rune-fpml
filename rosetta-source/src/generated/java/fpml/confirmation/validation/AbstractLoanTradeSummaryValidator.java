package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AbstractLoanTradeSummary;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.Money;
import fpml.confirmation.TradeIdentifier;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AbstractLoanTradeSummaryValidator implements Validator<AbstractLoanTradeSummary> {

	private List<ComparisonResult> getComparisonResults(AbstractLoanTradeSummary o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("tradeIdentifier", (TradeIdentifier) o.getTradeIdentifier() != null ? 1 : 0, 1, 1), 
				checkCardinality("facilityReference", (FacilityReference) o.getFacilityReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("amount", (Money) o.getAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("comment", (String) o.getComment() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<AbstractLoanTradeSummary> validate(RosettaPath path, AbstractLoanTradeSummary o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AbstractLoanTradeSummary", ValidationType.CARDINALITY, "AbstractLoanTradeSummary", path, "", error);
		}
		return success("AbstractLoanTradeSummary", ValidationType.CARDINALITY, "AbstractLoanTradeSummary", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AbstractLoanTradeSummary o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AbstractLoanTradeSummary", ValidationType.CARDINALITY, "AbstractLoanTradeSummary", path, "", res.getError());
				}
				return success("AbstractLoanTradeSummary", ValidationType.CARDINALITY, "AbstractLoanTradeSummary", path, "");
			})
			.collect(toList());
	}

}
