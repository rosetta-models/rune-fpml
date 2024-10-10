package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.OilPipelineDelivery;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OilPipelineDeliveryTypeFormatValidator implements Validator<OilPipelineDelivery> {

	private List<ComparisonResult> getComparisonResults(OilPipelineDelivery o) {
		return Lists.<ComparisonResult>newArrayList(
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
			return failure("OilPipelineDelivery", ValidationType.TYPE_FORMAT, "OilPipelineDelivery", path, "", error);
		}
		return success("OilPipelineDelivery", ValidationType.TYPE_FORMAT, "OilPipelineDelivery", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OilPipelineDelivery o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OilPipelineDelivery", ValidationType.TYPE_FORMAT, "OilPipelineDelivery", path, "", res.getError());
				}
				return success("OilPipelineDelivery", ValidationType.TYPE_FORMAT, "OilPipelineDelivery", path, "");
			})
			.collect(toList());
	}

}
