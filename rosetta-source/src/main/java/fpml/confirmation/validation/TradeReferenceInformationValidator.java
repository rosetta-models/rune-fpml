package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.OriginatingEvent;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.ProductId;
import fpml.confirmation.ProductType;
import fpml.confirmation.TerminatingEvent;
import fpml.confirmation.TradeReferenceInformation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeReferenceInformationValidator implements Validator<TradeReferenceInformation> {

	private List<ComparisonResult> getComparisonResults(TradeReferenceInformation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("originatingEvent", (OriginatingEvent) o.getOriginatingEvent() != null ? 1 : 0, 0, 1), 
				checkCardinality("terminatingEvent", (TerminatingEvent) o.getTerminatingEvent() != null ? 1 : 0, 0, 1), 
				checkCardinality("partyTradeIdentifier", (List<? extends PartyTradeIdentifier>) o.getPartyTradeIdentifier() == null ? 0 : ((List<? extends PartyTradeIdentifier>) o.getPartyTradeIdentifier()).size(), 1, 0), 
				checkCardinality("productType", (ProductType) o.getProductType() != null ? 1 : 0, 0, 1), 
				checkCardinality("productId", (ProductId) o.getProductId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<TradeReferenceInformation> validate(RosettaPath path, TradeReferenceInformation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeReferenceInformation", ValidationType.CARDINALITY, "TradeReferenceInformation", path, "", error);
		}
		return success("TradeReferenceInformation", ValidationType.CARDINALITY, "TradeReferenceInformation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeReferenceInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeReferenceInformation", ValidationType.CARDINALITY, "TradeReferenceInformation", path, "", res.getError());
				}
				return success("TradeReferenceInformation", ValidationType.CARDINALITY, "TradeReferenceInformation", path, "");
			})
			.collect(toList());
	}

}
