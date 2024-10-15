package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityDeliveryPoint;
import fpml.confirmation.CommodityDeliveryPointsModelSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityDeliveryPointsModelSequenceValidator implements Validator<CommodityDeliveryPointsModelSequence> {

	private List<ComparisonResult> getComparisonResults(CommodityDeliveryPointsModelSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("entryPoint", (CommodityDeliveryPoint) o.getEntryPoint() != null ? 1 : 0, 1, 1), 
				checkCardinality("withdrawalPoint", (CommodityDeliveryPoint) o.getWithdrawalPoint() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CommodityDeliveryPointsModelSequence> validate(RosettaPath path, CommodityDeliveryPointsModelSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityDeliveryPointsModelSequence", ValidationType.CARDINALITY, "CommodityDeliveryPointsModelSequence", path, "", error);
		}
		return success("CommodityDeliveryPointsModelSequence", ValidationType.CARDINALITY, "CommodityDeliveryPointsModelSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityDeliveryPointsModelSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityDeliveryPointsModelSequence", ValidationType.CARDINALITY, "CommodityDeliveryPointsModelSequence", path, "", res.getError());
				}
				return success("CommodityDeliveryPointsModelSequence", ValidationType.CARDINALITY, "CommodityDeliveryPointsModelSequence", path, "");
			})
			.collect(toList());
	}

}
