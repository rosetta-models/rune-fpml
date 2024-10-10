package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityPipeline;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityPipelineValidator implements Validator<CommodityPipeline> {

	private List<ComparisonResult> getComparisonResults(CommodityPipeline o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("pipelineScheme", (String) o.getPipelineScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityPipeline> validate(RosettaPath path, CommodityPipeline o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityPipeline", ValidationType.CARDINALITY, "CommodityPipeline", path, "", error);
		}
		return success("CommodityPipeline", ValidationType.CARDINALITY, "CommodityPipeline", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPipeline o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityPipeline", ValidationType.CARDINALITY, "CommodityPipeline", path, "", res.getError());
				}
				return success("CommodityPipeline", ValidationType.CARDINALITY, "CommodityPipeline", path, "");
			})
			.collect(toList());
	}

}
