package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Asset;
import fpml.confirmation.AveragingMethodEnum;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.FloatingRate;
import fpml.confirmation.GenericProductExchangeRate;
import fpml.confirmation.IndexReferenceInformation;
import fpml.confirmation.LegalEntity;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.QuotedCurrencyPair;
import fpml.confirmation.Schedule;
import fpml.confirmation.TradeUnderlyer2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeUnderlyer2Validator implements Validator<TradeUnderlyer2> {

	private List<ComparisonResult> getComparisonResults(TradeUnderlyer2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("floatingRate", (FloatingRate) o.getFloatingRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedRate", (Schedule) o.getFixedRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("exchangeRate", (GenericProductExchangeRate) o.getExchangeRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyingAsset", (Asset) o.getUnderlyingAsset() != null ? 1 : 0, 0, 1), 
				checkCardinality("quotedCurrencyPair", (QuotedCurrencyPair) o.getQuotedCurrencyPair() != null ? 1 : 0, 0, 1), 
				checkCardinality("referenceEntity", (LegalEntity) o.getReferenceEntity() != null ? 1 : 0, 0, 1), 
				checkCardinality("indexReferenceInformation", (IndexReferenceInformation) o.getIndexReferenceInformation() != null ? 1 : 0, 0, 1), 
				checkCardinality("averagingMethod", (AveragingMethodEnum) o.getAveragingMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerReceiverModel", (PayerReceiverModel) o.getPayerReceiverModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerSellerModel", (BuyerSellerModel) o.getBuyerSellerModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("dayCountFraction", (DayCountFraction) o.getDayCountFraction() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<TradeUnderlyer2> validate(RosettaPath path, TradeUnderlyer2 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeUnderlyer2", ValidationType.CARDINALITY, "TradeUnderlyer2", path, "", error);
		}
		return success("TradeUnderlyer2", ValidationType.CARDINALITY, "TradeUnderlyer2", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeUnderlyer2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeUnderlyer2", ValidationType.CARDINALITY, "TradeUnderlyer2", path, "", res.getError());
				}
				return success("TradeUnderlyer2", ValidationType.CARDINALITY, "TradeUnderlyer2", path, "");
			})
			.collect(toList());
	}

}
