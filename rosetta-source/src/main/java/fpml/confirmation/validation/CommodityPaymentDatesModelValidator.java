package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityNonPeriodicPaymentDatesModel;
import fpml.confirmation.CommodityPaymentDatesModel;
import fpml.confirmation.CommodityRelativePaymentDates;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityPaymentDatesModelValidator implements Validator<CommodityPaymentDatesModel> {

	private List<ComparisonResult> getComparisonResults(CommodityPaymentDatesModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("relativePaymentDates", (CommodityRelativePaymentDates) o.getRelativePaymentDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityNonPeriodicPaymentDatesModel", (CommodityNonPeriodicPaymentDatesModel) o.getCommodityNonPeriodicPaymentDatesModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityPaymentDatesModel> validate(RosettaPath path, CommodityPaymentDatesModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityPaymentDatesModel", ValidationType.CARDINALITY, "CommodityPaymentDatesModel", path, "", error);
		}
		return success("CommodityPaymentDatesModel", ValidationType.CARDINALITY, "CommodityPaymentDatesModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPaymentDatesModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityPaymentDatesModel", ValidationType.CARDINALITY, "CommodityPaymentDatesModel", path, "", res.getError());
				}
				return success("CommodityPaymentDatesModel", ValidationType.CARDINALITY, "CommodityPaymentDatesModel", path, "");
			})
			.collect(toList());
	}

}
