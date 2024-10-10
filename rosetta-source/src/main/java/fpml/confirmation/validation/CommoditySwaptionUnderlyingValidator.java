package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommoditySwapDetailsModel;
import fpml.confirmation.CommoditySwaptionUnderlying;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommoditySwaptionUnderlyingValidator implements Validator<CommoditySwaptionUnderlying> {

	private List<ComparisonResult> getComparisonResults(CommoditySwaptionUnderlying o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("commoditySwapDetailsModel", (CommoditySwapDetailsModel) o.getCommoditySwapDetailsModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CommoditySwaptionUnderlying> validate(RosettaPath path, CommoditySwaptionUnderlying o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommoditySwaptionUnderlying", ValidationType.CARDINALITY, "CommoditySwaptionUnderlying", path, "", error);
		}
		return success("CommoditySwaptionUnderlying", ValidationType.CARDINALITY, "CommoditySwaptionUnderlying", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommoditySwaptionUnderlying o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommoditySwaptionUnderlying", ValidationType.CARDINALITY, "CommoditySwaptionUnderlying", path, "", res.getError());
				}
				return success("CommoditySwaptionUnderlying", ValidationType.CARDINALITY, "CommoditySwaptionUnderlying", path, "");
			})
			.collect(toList());
	}

}
