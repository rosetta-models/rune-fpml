package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AveragingMethodEnum;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.CommodityFx;
import fpml.confirmation.CommodityFxSequence;
import fpml.confirmation.CommodityFxType;
import fpml.confirmation.InformationSource;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityFxValidator implements Validator<CommodityFx> {

	private List<ComparisonResult> getComparisonResults(CommodityFx o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("primaryRateSource", (InformationSource) o.getPrimaryRateSource() != null ? 1 : 0, 1, 1), 
				checkCardinality("secondaryRateSource", (InformationSource) o.getSecondaryRateSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxType", (CommodityFxType) o.getFxType() != null ? 1 : 0, 0, 1), 
				checkCardinality("averagingMethod", (AveragingMethodEnum) o.getAveragingMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixingTime", (BusinessCenterTime) o.getFixingTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityFxSequence", (CommodityFxSequence) o.getCommodityFxSequence() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityFx> validate(RosettaPath path, CommodityFx o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityFx", ValidationType.CARDINALITY, "CommodityFx", path, "", error);
		}
		return success("CommodityFx", ValidationType.CARDINALITY, "CommodityFx", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityFx o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityFx", ValidationType.CARDINALITY, "CommodityFx", path, "", res.getError());
				}
				return success("CommodityFx", ValidationType.CARDINALITY, "CommodityFx", path, "");
			})
			.collect(toList());
	}

}
