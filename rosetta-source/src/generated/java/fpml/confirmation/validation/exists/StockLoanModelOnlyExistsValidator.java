package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.StockLoanModel;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class StockLoanModelOnlyExistsValidator implements ValidatorWithArg<StockLoanModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends StockLoanModel> ValidationResult<StockLoanModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("lossOfStockBorrow", ExistenceChecker.isSet((Boolean) o.getLossOfStockBorrow()))
				.put("maximumStockLoanRate", ExistenceChecker.isSet((BigDecimal) o.getMaximumStockLoanRate()))
				.put("increasedCostOfStockBorrow", ExistenceChecker.isSet((Boolean) o.getIncreasedCostOfStockBorrow()))
				.put("initialStockLoanRate", ExistenceChecker.isSet((BigDecimal) o.getInitialStockLoanRate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("StockLoanModel", ValidationType.ONLY_EXISTS, "StockLoanModel", path, "");
		}
		return failure("StockLoanModel", ValidationType.ONLY_EXISTS, "StockLoanModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
