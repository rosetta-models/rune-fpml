package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityDeliveryPeriodsPointerModel;
import fpml.confirmation.SettlementPeriodsSchedule;
import fpml.confirmation.SettlementPeriodsStep;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SettlementPeriodsScheduleValidator implements Validator<SettlementPeriodsSchedule> {

	private List<ComparisonResult> getComparisonResults(SettlementPeriodsSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("settlementPeriodsStep", (List<? extends SettlementPeriodsStep>) o.getSettlementPeriodsStep() == null ? 0 : ((List<? extends SettlementPeriodsStep>) o.getSettlementPeriodsStep()).size(), 1, 0), 
				checkCardinality("commodityDeliveryPeriodsPointerModel", (CommodityDeliveryPeriodsPointerModel) o.getCommodityDeliveryPeriodsPointerModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<SettlementPeriodsSchedule> validate(RosettaPath path, SettlementPeriodsSchedule o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SettlementPeriodsSchedule", ValidationType.CARDINALITY, "SettlementPeriodsSchedule", path, "", error);
		}
		return success("SettlementPeriodsSchedule", ValidationType.CARDINALITY, "SettlementPeriodsSchedule", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementPeriodsSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SettlementPeriodsSchedule", ValidationType.CARDINALITY, "SettlementPeriodsSchedule", path, "", res.getError());
				}
				return success("SettlementPeriodsSchedule", ValidationType.CARDINALITY, "SettlementPeriodsSchedule", path, "");
			})
			.collect(toList());
	}

}
