package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityNotionalQuantity;
import fpml.confirmation.CommoditySettlementPeriodsNotionalQuantitySchedule;
import fpml.confirmation.SettlementPeriodsReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommoditySettlementPeriodsNotionalQuantityScheduleValidator implements Validator<CommoditySettlementPeriodsNotionalQuantitySchedule> {

	private List<ComparisonResult> getComparisonResults(CommoditySettlementPeriodsNotionalQuantitySchedule o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("settlementPeriodsNotionalQuantityStep", (List<? extends CommodityNotionalQuantity>) o.getSettlementPeriodsNotionalQuantityStep() == null ? 0 : ((List<? extends CommodityNotionalQuantity>) o.getSettlementPeriodsNotionalQuantityStep()).size(), 1, 0), 
				checkCardinality("settlementPeriodsReference", (List<? extends SettlementPeriodsReference>) o.getSettlementPeriodsReference() == null ? 0 : ((List<? extends SettlementPeriodsReference>) o.getSettlementPeriodsReference()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<CommoditySettlementPeriodsNotionalQuantitySchedule> validate(RosettaPath path, CommoditySettlementPeriodsNotionalQuantitySchedule o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommoditySettlementPeriodsNotionalQuantitySchedule", ValidationType.CARDINALITY, "CommoditySettlementPeriodsNotionalQuantitySchedule", path, "", error);
		}
		return success("CommoditySettlementPeriodsNotionalQuantitySchedule", ValidationType.CARDINALITY, "CommoditySettlementPeriodsNotionalQuantitySchedule", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommoditySettlementPeriodsNotionalQuantitySchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommoditySettlementPeriodsNotionalQuantitySchedule", ValidationType.CARDINALITY, "CommoditySettlementPeriodsNotionalQuantitySchedule", path, "", res.getError());
				}
				return success("CommoditySettlementPeriodsNotionalQuantitySchedule", ValidationType.CARDINALITY, "CommoditySettlementPeriodsNotionalQuantitySchedule", path, "");
			})
			.collect(toList());
	}

}
