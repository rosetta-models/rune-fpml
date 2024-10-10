package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdditionalTerm;
import fpml.confirmation.AdjustableDate2;
import fpml.confirmation.BasketReferenceInformation;
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.GeneralTerms;
import fpml.confirmation.IndexReferenceInformation;
import fpml.confirmation.ReferenceInformation;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class GeneralTermsOnlyExistsValidator implements ValidatorWithArg<GeneralTerms, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends GeneralTerms> ValidationResult<GeneralTerms> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("effectiveDate", ExistenceChecker.isSet((AdjustableDate2) o.getEffectiveDate()))
				.put("scheduledTerminationDate", ExistenceChecker.isSet((AdjustableDate2) o.getScheduledTerminationDate()))
				.put("buyerSellerModel", ExistenceChecker.isSet((BuyerSellerModel) o.getBuyerSellerModel()))
				.put("dateAdjustments", ExistenceChecker.isSet((BusinessDayAdjustments) o.getDateAdjustments()))
				.put("referenceInformation", ExistenceChecker.isSet((ReferenceInformation) o.getReferenceInformation()))
				.put("indexReferenceInformation", ExistenceChecker.isSet((IndexReferenceInformation) o.getIndexReferenceInformation()))
				.put("basketReferenceInformation", ExistenceChecker.isSet((BasketReferenceInformation) o.getBasketReferenceInformation()))
				.put("additionalTerm", ExistenceChecker.isSet((List<? extends AdditionalTerm>) o.getAdditionalTerm()))
				.put("substitution", ExistenceChecker.isSet((Boolean) o.getSubstitution()))
				.put("modifiedEquityDelivery", ExistenceChecker.isSet((Boolean) o.getModifiedEquityDelivery()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("GeneralTerms", ValidationType.ONLY_EXISTS, "GeneralTerms", path, "");
		}
		return failure("GeneralTerms", ValidationType.ONLY_EXISTS, "GeneralTerms", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
