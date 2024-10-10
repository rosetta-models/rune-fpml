package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Market;
import fpml.confirmation.OnBehalfOf;
import fpml.confirmation.OriginatingEvent;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.Portfolio;
import fpml.confirmation.Trade;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.ValuationDocument;
import fpml.confirmation.ValuationSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ValuationDocumentOnlyExistsValidator implements ValidatorWithArg<ValuationDocument, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ValuationDocument> ValidationResult<ValuationDocument> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("expectedBuild", ExistenceChecker.isSet((Integer) o.getExpectedBuild()))
				.put("actualBuild", ExistenceChecker.isSet((Integer) o.getActualBuild()))
				.put("validationModel", ExistenceChecker.isSet((ValidationModel) o.getValidationModel()))
				.put("onBehalfOf", ExistenceChecker.isSet((OnBehalfOf) o.getOnBehalfOf()))
				.put("originatingEvent", ExistenceChecker.isSet((OriginatingEvent) o.getOriginatingEvent()))
				.put("trade", ExistenceChecker.isSet((List<? extends Trade>) o.getTrade()))
				.put("portfolio", ExistenceChecker.isSet((List<? extends Portfolio>) o.getPortfolio()))
				.put("partiesAndAccountsModel", ExistenceChecker.isSet((PartiesAndAccountsModel) o.getPartiesAndAccountsModel()))
				.put("market", ExistenceChecker.isSet((List<? extends Market>) o.getMarket()))
				.put("valuationSet", ExistenceChecker.isSet((List<? extends ValuationSet>) o.getValuationSet()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ValuationDocument", ValidationType.ONLY_EXISTS, "ValuationDocument", path, "");
		}
		return failure("ValuationDocument", ValidationType.ONLY_EXISTS, "ValuationDocument", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
