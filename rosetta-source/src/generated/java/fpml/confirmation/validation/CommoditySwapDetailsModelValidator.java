package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.CommodityContentModel;
import fpml.confirmation.CommoditySwapDetailsModel;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.WeatherLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommoditySwapDetailsModelValidator implements Validator<CommoditySwapDetailsModel> {

	private List<ComparisonResult> getComparisonResults(CommoditySwapDetailsModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("effectiveDate", (AdjustableOrRelativeDate) o.getEffectiveDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("terminationDate", (AdjustableOrRelativeDate) o.getTerminationDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementCurrency", (IdentifiedCurrency) o.getSettlementCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("weatherLeg", (List<? extends WeatherLeg>) o.getWeatherLeg() == null ? 0 : ((List<? extends WeatherLeg>) o.getWeatherLeg()).size(), 0, 2), 
				checkCardinality("commodityContentModel", (CommodityContentModel) o.getCommodityContentModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommoditySwapDetailsModel> validate(RosettaPath path, CommoditySwapDetailsModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommoditySwapDetailsModel", ValidationType.CARDINALITY, "CommoditySwapDetailsModel", path, "", error);
		}
		return success("CommoditySwapDetailsModel", ValidationType.CARDINALITY, "CommoditySwapDetailsModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommoditySwapDetailsModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommoditySwapDetailsModel", ValidationType.CARDINALITY, "CommoditySwapDetailsModel", path, "", res.getError());
				}
				return success("CommoditySwapDetailsModel", ValidationType.CARDINALITY, "CommoditySwapDetailsModel", path, "");
			})
			.collect(toList());
	}

}
