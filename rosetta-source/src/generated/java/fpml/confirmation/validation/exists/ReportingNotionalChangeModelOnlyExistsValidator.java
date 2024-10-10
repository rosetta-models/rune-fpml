package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AmountRef;
import fpml.confirmation.MoneyRef;
import fpml.confirmation.NotionalChangeEnum;
import fpml.confirmation.ReportingNotionalChangeModel;
import fpml.confirmation.UnitQuantityRef;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ReportingNotionalChangeModelOnlyExistsValidator implements ValidatorWithArg<ReportingNotionalChangeModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ReportingNotionalChangeModel> ValidationResult<ReportingNotionalChangeModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("notionalChange", ExistenceChecker.isSet((NotionalChangeEnum) o.getNotionalChange()))
				.put("changeInNotional", ExistenceChecker.isSet((List<? extends MoneyRef>) o.getChangeInNotional()))
				.put("changeInNumberOfOptions", ExistenceChecker.isSet((List<? extends AmountRef>) o.getChangeInNumberOfOptions()))
				.put("changeInQuantity", ExistenceChecker.isSet((List<? extends UnitQuantityRef>) o.getChangeInQuantity()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReportingNotionalChangeModel", ValidationType.ONLY_EXISTS, "ReportingNotionalChangeModel", path, "");
		}
		return failure("ReportingNotionalChangeModel", ValidationType.ONLY_EXISTS, "ReportingNotionalChangeModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
