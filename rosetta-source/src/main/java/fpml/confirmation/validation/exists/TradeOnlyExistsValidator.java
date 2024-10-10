package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Allocations;
import fpml.confirmation.Approvals;
import fpml.confirmation.CalculationAgentModel;
import fpml.confirmation.Collateral;
import fpml.confirmation.Documentation;
import fpml.confirmation.GoverningLaw;
import fpml.confirmation.PartyReference;
import fpml.confirmation.Payment;
import fpml.confirmation.Product;
import fpml.confirmation.Trade;
import fpml.confirmation.TradeHeader;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeOnlyExistsValidator implements ValidatorWithArg<Trade, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Trade> ValidationResult<Trade> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("tradeHeader", ExistenceChecker.isSet((TradeHeader) o.getTradeHeader()))
				.put("product", ExistenceChecker.isSet((Product) o.getProduct()))
				.put("otherPartyPayment", ExistenceChecker.isSet((List<? extends Payment>) o.getOtherPartyPayment()))
				.put("brokerPartyReference", ExistenceChecker.isSet((List<? extends PartyReference>) o.getBrokerPartyReference()))
				.put("calculationAgentModel", ExistenceChecker.isSet((CalculationAgentModel) o.getCalculationAgentModel()))
				.put("determiningParty", ExistenceChecker.isSet((List<? extends PartyReference>) o.getDeterminingParty()))
				.put("barrierDeterminationAgent", ExistenceChecker.isSet((PartyReference) o.getBarrierDeterminationAgent()))
				.put("hedgingParty", ExistenceChecker.isSet((List<? extends PartyReference>) o.getHedgingParty()))
				.put("collateral", ExistenceChecker.isSet((Collateral) o.getCollateral()))
				.put("documentation", ExistenceChecker.isSet((Documentation) o.getDocumentation()))
				.put("governingLaw", ExistenceChecker.isSet((GoverningLaw) o.getGoverningLaw()))
				.put("allocations", ExistenceChecker.isSet((List<? extends Allocations>) o.getAllocations()))
				.put("approvals", ExistenceChecker.isSet((Approvals) o.getApprovals()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Trade", ValidationType.ONLY_EXISTS, "Trade", path, "");
		}
		return failure("Trade", ValidationType.ONLY_EXISTS, "Trade", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
