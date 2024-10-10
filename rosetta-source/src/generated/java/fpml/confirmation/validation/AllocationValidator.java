package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Allocation;
import fpml.confirmation.AllocationContentModel;
import fpml.confirmation.Money;
import fpml.confirmation.PartyAndAccountReferencesModel;
import fpml.confirmation.TradeIdentifier;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AllocationValidator implements Validator<Allocation> {

	private List<ComparisonResult> getComparisonResults(Allocation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("allocationTradeId", (List<? extends TradeIdentifier>) o.getAllocationTradeId() == null ? 0 : ((List<? extends TradeIdentifier>) o.getAllocationTradeId()).size(), 1, 0), 
				checkCardinality("partyAndAccountReferencesModel", (PartyAndAccountReferencesModel) o.getPartyAndAccountReferencesModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("allocatedFraction", (BigDecimal) o.getAllocatedFraction() != null ? 1 : 0, 0, 1), 
				checkCardinality("allocatedNotional", (List<? extends Money>) o.getAllocatedNotional() == null ? 0 : ((List<? extends Money>) o.getAllocatedNotional()).size(), 0, 2), 
				checkCardinality("allocationContentModel", (AllocationContentModel) o.getAllocationContentModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<Allocation> validate(RosettaPath path, Allocation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Allocation", ValidationType.CARDINALITY, "Allocation", path, "", error);
		}
		return success("Allocation", ValidationType.CARDINALITY, "Allocation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Allocation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Allocation", ValidationType.CARDINALITY, "Allocation", path, "", res.getError());
				}
				return success("Allocation", ValidationType.CARDINALITY, "Allocation", path, "");
			})
			.collect(toList());
	}

}
