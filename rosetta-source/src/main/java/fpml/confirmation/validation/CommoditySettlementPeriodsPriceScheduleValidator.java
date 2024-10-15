package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommoditySettlementPeriodsPriceSchedule;
import fpml.confirmation.FixedPrice;
import fpml.confirmation.SettlementPeriodsReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommoditySettlementPeriodsPriceScheduleValidator implements Validator<CommoditySettlementPeriodsPriceSchedule> {

	private List<ComparisonResult> getComparisonResults(CommoditySettlementPeriodsPriceSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("settlementPeriodsPriceStep", (List<? extends FixedPrice>) o.getSettlementPeriodsPriceStep() == null ? 0 : ((List<? extends FixedPrice>) o.getSettlementPeriodsPriceStep()).size(), 1, 0), 
				checkCardinality("settlementPeriodsReference", (List<? extends SettlementPeriodsReference>) o.getSettlementPeriodsReference() == null ? 0 : ((List<? extends SettlementPeriodsReference>) o.getSettlementPeriodsReference()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<CommoditySettlementPeriodsPriceSchedule> validate(RosettaPath path, CommoditySettlementPeriodsPriceSchedule o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommoditySettlementPeriodsPriceSchedule", ValidationType.CARDINALITY, "CommoditySettlementPeriodsPriceSchedule", path, "", error);
		}
		return success("CommoditySettlementPeriodsPriceSchedule", ValidationType.CARDINALITY, "CommoditySettlementPeriodsPriceSchedule", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommoditySettlementPeriodsPriceSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommoditySettlementPeriodsPriceSchedule", ValidationType.CARDINALITY, "CommoditySettlementPeriodsPriceSchedule", path, "", res.getError());
				}
				return success("CommoditySettlementPeriodsPriceSchedule", ValidationType.CARDINALITY, "CommoditySettlementPeriodsPriceSchedule", path, "");
			})
			.collect(toList());
	}

}
