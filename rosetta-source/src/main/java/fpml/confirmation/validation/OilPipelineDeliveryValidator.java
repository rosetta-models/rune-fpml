package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityDeliveryPoint;
import fpml.confirmation.CommodityDeliveryRisk;
import fpml.confirmation.CommodityPipeline;
import fpml.confirmation.OilPipelineDelivery;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OilPipelineDeliveryValidator implements Validator<OilPipelineDelivery> {

	private List<ComparisonResult> getComparisonResults(OilPipelineDelivery o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("pipelineName", (CommodityPipeline) o.getPipelineName() != null ? 1 : 0, 1, 1), 
				checkCardinality("withdrawalPoint", (CommodityDeliveryPoint) o.getWithdrawalPoint() != null ? 1 : 0, 0, 1), 
				checkCardinality("entryPoint", (CommodityDeliveryPoint) o.getEntryPoint() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliverableByBarge", (Boolean) o.getDeliverableByBarge() != null ? 1 : 0, 1, 1), 
				checkCardinality("risk", (CommodityDeliveryRisk) o.getRisk() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<OilPipelineDelivery> validate(RosettaPath path, OilPipelineDelivery o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OilPipelineDelivery", ValidationType.CARDINALITY, "OilPipelineDelivery", path, "", error);
		}
		return success("OilPipelineDelivery", ValidationType.CARDINALITY, "OilPipelineDelivery", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OilPipelineDelivery o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OilPipelineDelivery", ValidationType.CARDINALITY, "OilPipelineDelivery", path, "", res.getError());
				}
				return success("OilPipelineDelivery", ValidationType.CARDINALITY, "OilPipelineDelivery", path, "");
			})
			.collect(toList());
	}

}
