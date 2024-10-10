package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.NewTradeModel;
import fpml.confirmation.NovationAmountsModel;
import fpml.confirmation.NovationDatesModel;
import fpml.confirmation.NovationRolesModel;
import fpml.confirmation.NovationTermsModel;
import fpml.confirmation.Payment;
import fpml.confirmation.TradeNovationContent;
import fpml.confirmation.TradeNovationContentSequence0;
import fpml.confirmation.TradeNovationContentSequence1;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeNovationContentOnlyExistsValidator implements ValidatorWithArg<TradeNovationContent, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeNovationContent> ValidationResult<TradeNovationContent> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("eventIdentifier", ExistenceChecker.isSet((List<? extends BusinessEventIdentifier>) o.getEventIdentifier()))
				.put("newTradeModel", ExistenceChecker.isSet((NewTradeModel) o.getNewTradeModel()))
				.put("tradeNovationContentSequence0", ExistenceChecker.isSet((TradeNovationContentSequence0) o.getTradeNovationContentSequence0()))
				.put("tradeNovationContentSequence1", ExistenceChecker.isSet((TradeNovationContentSequence1) o.getTradeNovationContentSequence1()))
				.put("novationRolesModel", ExistenceChecker.isSet((NovationRolesModel) o.getNovationRolesModel()))
				.put("novationDatesModel", ExistenceChecker.isSet((NovationDatesModel) o.getNovationDatesModel()))
				.put("novationAmountsModel", ExistenceChecker.isSet((NovationAmountsModel) o.getNovationAmountsModel()))
				.put("novationTermsModel", ExistenceChecker.isSet((NovationTermsModel) o.getNovationTermsModel()))
				.put("payment", ExistenceChecker.isSet((Payment) o.getPayment()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeNovationContent", ValidationType.ONLY_EXISTS, "TradeNovationContent", path, "");
		}
		return failure("TradeNovationContent", ValidationType.ONLY_EXISTS, "TradeNovationContent", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
