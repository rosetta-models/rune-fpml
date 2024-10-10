package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeProcessingTimestamps;
import fpml.confirmation.TradeTimestamp;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeProcessingTimestampsOnlyExistsValidator implements ValidatorWithArg<TradeProcessingTimestamps, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeProcessingTimestamps> ValidationResult<TradeProcessingTimestamps> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("orderEntered", ExistenceChecker.isSet((ZonedDateTime) o.getOrderEntered()))
				.put("orderSubmitted", ExistenceChecker.isSet((ZonedDateTime) o.getOrderSubmitted()))
				.put("publiclyReported", ExistenceChecker.isSet((ZonedDateTime) o.getPubliclyReported()))
				.put("publicReportAccepted", ExistenceChecker.isSet((ZonedDateTime) o.getPublicReportAccepted()))
				.put("publicReportUpdated", ExistenceChecker.isSet((ZonedDateTime) o.getPublicReportUpdated()))
				.put("nonpubliclyReported", ExistenceChecker.isSet((ZonedDateTime) o.getNonpubliclyReported()))
				.put("nonpublicReportAccepted", ExistenceChecker.isSet((ZonedDateTime) o.getNonpublicReportAccepted()))
				.put("nonpublicReportUpdated", ExistenceChecker.isSet((ZonedDateTime) o.getNonpublicReportUpdated()))
				.put("submittedForConfirmation", ExistenceChecker.isSet((ZonedDateTime) o.getSubmittedForConfirmation()))
				.put("updatedForConfirmation", ExistenceChecker.isSet((ZonedDateTime) o.getUpdatedForConfirmation()))
				.put("confirmed", ExistenceChecker.isSet((ZonedDateTime) o.getConfirmed()))
				.put("submittedForClearing", ExistenceChecker.isSet((ZonedDateTime) o.getSubmittedForClearing()))
				.put("updatedForClearing", ExistenceChecker.isSet((ZonedDateTime) o.getUpdatedForClearing()))
				.put("cleared", ExistenceChecker.isSet((ZonedDateTime) o.getCleared()))
				.put("allocationsSubmitted", ExistenceChecker.isSet((ZonedDateTime) o.getAllocationsSubmitted()))
				.put("allocationsUpdated", ExistenceChecker.isSet((ZonedDateTime) o.getAllocationsUpdated()))
				.put("allocationsCompleted", ExistenceChecker.isSet((ZonedDateTime) o.getAllocationsCompleted()))
				.put("timestamp", ExistenceChecker.isSet((List<? extends TradeTimestamp>) o.getTimestamp()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeProcessingTimestamps", ValidationType.ONLY_EXISTS, "TradeProcessingTimestamps", path, "");
		}
		return failure("TradeProcessingTimestamps", ValidationType.ONLY_EXISTS, "TradeProcessingTimestamps", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
