package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityDeliveryPointsModel;
import fpml.confirmation.CommodityDeliveryPointsModelSequence;
import fpml.confirmation.GasDeliveryPoint;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityDeliveryPointsModelValidator implements Validator<CommodityDeliveryPointsModel> {

	private List<ComparisonResult> getComparisonResults(CommodityDeliveryPointsModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("deliveryPoint", (GasDeliveryPoint) o.getDeliveryPoint() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityDeliveryPointsModelSequence", (CommodityDeliveryPointsModelSequence) o.getCommodityDeliveryPointsModelSequence() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityDeliveryPointsModel> validate(RosettaPath path, CommodityDeliveryPointsModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityDeliveryPointsModel", ValidationType.CARDINALITY, "CommodityDeliveryPointsModel", path, "", error);
		}
		return success("CommodityDeliveryPointsModel", ValidationType.CARDINALITY, "CommodityDeliveryPointsModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityDeliveryPointsModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityDeliveryPointsModel", ValidationType.CARDINALITY, "CommodityDeliveryPointsModel", path, "", res.getError());
				}
				return success("CommodityDeliveryPointsModel", ValidationType.CARDINALITY, "CommodityDeliveryPointsModel", path, "");
			})
			.collect(toList());
	}

}
