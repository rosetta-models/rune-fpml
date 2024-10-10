package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessCentersOrReferenceModel;
import fpml.confirmation.CommodityCalculationPeriodsPointerModel;
import fpml.confirmation.CommodityPayRelativeToEnum;
import fpml.confirmation.CommodityPayRelativeToEvent;
import fpml.confirmation.CommodityRelativePaymentDates;
import fpml.confirmation.DateOffset;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityRelativePaymentDatesValidator implements Validator<CommodityRelativePaymentDates> {

	private List<ComparisonResult> getComparisonResults(CommodityRelativePaymentDates o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("payRelativeTo", (CommodityPayRelativeToEnum) o.getPayRelativeTo() != null ? 1 : 0, 0, 1), 
				checkCardinality("payRelativeToEvent", (CommodityPayRelativeToEvent) o.getPayRelativeToEvent() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityCalculationPeriodsPointerModel", (CommodityCalculationPeriodsPointerModel) o.getCommodityCalculationPeriodsPointerModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("paymentDaysOffset", (DateOffset) o.getPaymentDaysOffset() != null ? 1 : 0, 1, 1), 
				checkCardinality("businessCentersOrReferenceModel", (BusinessCentersOrReferenceModel) o.getBusinessCentersOrReferenceModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityRelativePaymentDates> validate(RosettaPath path, CommodityRelativePaymentDates o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityRelativePaymentDates", ValidationType.CARDINALITY, "CommodityRelativePaymentDates", path, "", error);
		}
		return success("CommodityRelativePaymentDates", ValidationType.CARDINALITY, "CommodityRelativePaymentDates", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityRelativePaymentDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityRelativePaymentDates", ValidationType.CARDINALITY, "CommodityRelativePaymentDates", path, "", res.getError());
				}
				return success("CommodityRelativePaymentDates", ValidationType.CARDINALITY, "CommodityRelativePaymentDates", path, "");
			})
			.collect(toList());
	}

}
