package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Allocations;
import fpml.confirmation.Approvals;
import fpml.confirmation.CalculationAgentModel;
import fpml.confirmation.Collateral;
import fpml.confirmation.Documentation;
import fpml.confirmation.GoverningLaw;
import fpml.confirmation.PartyReference;
import fpml.confirmation.Product;
import fpml.confirmation.Trade;
import fpml.confirmation.TradeHeader;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeValidator implements Validator<Trade> {

	private List<ComparisonResult> getComparisonResults(Trade o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("tradeHeader", (TradeHeader) o.getTradeHeader() != null ? 1 : 0, 1, 1), 
				checkCardinality("product", (Product) o.getProduct() != null ? 1 : 0, 1, 1), 
				checkCardinality("calculationAgentModel", (CalculationAgentModel) o.getCalculationAgentModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("determiningParty", (List<? extends PartyReference>) o.getDeterminingParty() == null ? 0 : ((List<? extends PartyReference>) o.getDeterminingParty()).size(), 0, 2), 
				checkCardinality("barrierDeterminationAgent", (PartyReference) o.getBarrierDeterminationAgent() != null ? 1 : 0, 0, 1), 
				checkCardinality("hedgingParty", (List<? extends PartyReference>) o.getHedgingParty() == null ? 0 : ((List<? extends PartyReference>) o.getHedgingParty()).size(), 0, 2), 
				checkCardinality("collateral", (Collateral) o.getCollateral() != null ? 1 : 0, 0, 1), 
				checkCardinality("documentation", (Documentation) o.getDocumentation() != null ? 1 : 0, 0, 1), 
				checkCardinality("governingLaw", (GoverningLaw) o.getGoverningLaw() != null ? 1 : 0, 0, 1), 
				checkCardinality("allocations", (List<? extends Allocations>) o.getAllocations() == null ? 0 : ((List<? extends Allocations>) o.getAllocations()).size(), 0, 2), 
				checkCardinality("approvals", (Approvals) o.getApprovals() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<Trade> validate(RosettaPath path, Trade o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Trade", ValidationType.CARDINALITY, "Trade", path, "", error);
		}
		return success("Trade", ValidationType.CARDINALITY, "Trade", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Trade o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Trade", ValidationType.CARDINALITY, "Trade", path, "", res.getError());
				}
				return success("Trade", ValidationType.CARDINALITY, "Trade", path, "");
			})
			.collect(toList());
	}

}
