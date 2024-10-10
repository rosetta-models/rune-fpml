package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.IdentifiedDate;
import fpml.confirmation.PackageSummary;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.ProductSummary;
import fpml.confirmation.TradeHeader;
import fpml.confirmation.TradeSummary;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeHeaderValidator implements Validator<TradeHeader> {

	private List<ComparisonResult> getComparisonResults(TradeHeader o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyTradeIdentifier", (List<? extends PartyTradeIdentifier>) o.getPartyTradeIdentifier() == null ? 0 : ((List<? extends PartyTradeIdentifier>) o.getPartyTradeIdentifier()).size(), 1, 0), 
				checkCardinality("tradeSummary", (TradeSummary) o.getTradeSummary() != null ? 1 : 0, 0, 1), 
				checkCardinality("productSummary", (ProductSummary) o.getProductSummary() != null ? 1 : 0, 0, 1), 
				checkCardinality("originatingPackage", (PackageSummary) o.getOriginatingPackage() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeDate", (IdentifiedDate) o.getTradeDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("clearedDate", (IdentifiedDate) o.getClearedDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<TradeHeader> validate(RosettaPath path, TradeHeader o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeHeader", ValidationType.CARDINALITY, "TradeHeader", path, "", error);
		}
		return success("TradeHeader", ValidationType.CARDINALITY, "TradeHeader", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeHeader o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeHeader", ValidationType.CARDINALITY, "TradeHeader", path, "", res.getError());
				}
				return success("TradeHeader", ValidationType.CARDINALITY, "TradeHeader", path, "");
			})
			.collect(toList());
	}

}
