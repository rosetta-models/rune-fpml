package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableDates;
import fpml.confirmation.Currency;
import fpml.confirmation.FxFixingDate;
import fpml.confirmation.NonDeliverableSettlement;
import fpml.confirmation.PriceSourceDisruptionType;
import fpml.confirmation.SettlementRateOption;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class NonDeliverableSettlementValidator implements Validator<NonDeliverableSettlement> {

	private List<ComparisonResult> getComparisonResults(NonDeliverableSettlement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("referenceCurrency", (Currency) o.getReferenceCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("fxFixingDate", (FxFixingDate) o.getFxFixingDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxFixingSchedule", (AdjustableDates) o.getFxFixingSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementRateOption", (SettlementRateOption) o.getSettlementRateOption() != null ? 1 : 0, 1, 1), 
				checkCardinality("priceSourceDisruption", (PriceSourceDisruptionType) o.getPriceSourceDisruption() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<NonDeliverableSettlement> validate(RosettaPath path, NonDeliverableSettlement o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NonDeliverableSettlement", ValidationType.CARDINALITY, "NonDeliverableSettlement", path, "", error);
		}
		return success("NonDeliverableSettlement", ValidationType.CARDINALITY, "NonDeliverableSettlement", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NonDeliverableSettlement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NonDeliverableSettlement", ValidationType.CARDINALITY, "NonDeliverableSettlement", path, "", res.getError());
				}
				return success("NonDeliverableSettlement", ValidationType.CARDINALITY, "NonDeliverableSettlement", path, "");
			})
			.collect(toList());
	}

}
