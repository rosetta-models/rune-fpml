package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityFixedPriceModel;
import fpml.confirmation.CommodityFixedPriceModelChoice;
import fpml.confirmation.CommodityFixedPriceSchedule;
import fpml.confirmation.NonNegativeMoney;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityFixedPriceModelValidator implements Validator<CommodityFixedPriceModel> {

	private List<ComparisonResult> getComparisonResults(CommodityFixedPriceModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fixedPriceSchedule", (CommodityFixedPriceSchedule) o.getFixedPriceSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityFixedPriceModelChoice", (CommodityFixedPriceModelChoice) o.getCommodityFixedPriceModelChoice() != null ? 1 : 0, 0, 1), 
				checkCardinality("totalPrice", (NonNegativeMoney) o.getTotalPrice() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityFixedPriceModel> validate(RosettaPath path, CommodityFixedPriceModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityFixedPriceModel", ValidationType.CARDINALITY, "CommodityFixedPriceModel", path, "", error);
		}
		return success("CommodityFixedPriceModel", ValidationType.CARDINALITY, "CommodityFixedPriceModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityFixedPriceModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityFixedPriceModel", ValidationType.CARDINALITY, "CommodityFixedPriceModel", path, "", res.getError());
				}
				return success("CommodityFixedPriceModel", ValidationType.CARDINALITY, "CommodityFixedPriceModel", path, "");
			})
			.collect(toList());
	}

}
