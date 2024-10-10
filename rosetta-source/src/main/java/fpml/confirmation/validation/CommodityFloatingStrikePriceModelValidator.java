package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityCalculationPeriodsSchedule;
import fpml.confirmation.CommodityFloatingStrikePriceModel;
import fpml.confirmation.FloatingStrikePrice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityFloatingStrikePriceModelValidator implements Validator<CommodityFloatingStrikePriceModel> {

	private List<ComparisonResult> getComparisonResults(CommodityFloatingStrikePriceModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("floatingStrikePricePerUnit", (FloatingStrikePrice) o.getFloatingStrikePricePerUnit() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingStrikePricePerUnitSchedule", (CommodityCalculationPeriodsSchedule) o.getFloatingStrikePricePerUnitSchedule() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityFloatingStrikePriceModel> validate(RosettaPath path, CommodityFloatingStrikePriceModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityFloatingStrikePriceModel", ValidationType.CARDINALITY, "CommodityFloatingStrikePriceModel", path, "", error);
		}
		return success("CommodityFloatingStrikePriceModel", ValidationType.CARDINALITY, "CommodityFloatingStrikePriceModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityFloatingStrikePriceModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityFloatingStrikePriceModel", ValidationType.CARDINALITY, "CommodityFloatingStrikePriceModel", path, "", res.getError());
				}
				return success("CommodityFloatingStrikePriceModel", ValidationType.CARDINALITY, "CommodityFloatingStrikePriceModel", path, "");
			})
			.collect(toList());
	}

}
