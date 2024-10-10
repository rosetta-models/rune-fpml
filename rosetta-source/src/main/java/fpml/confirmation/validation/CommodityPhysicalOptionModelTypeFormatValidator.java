package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityPhysicalOptionModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityPhysicalOptionModelTypeFormatValidator implements Validator<CommodityPhysicalOptionModel> {

	private List<ComparisonResult> getComparisonResults(CommodityPhysicalOptionModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityPhysicalOptionModel> validate(RosettaPath path, CommodityPhysicalOptionModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityPhysicalOptionModel", ValidationType.TYPE_FORMAT, "CommodityPhysicalOptionModel", path, "", error);
		}
		return success("CommodityPhysicalOptionModel", ValidationType.TYPE_FORMAT, "CommodityPhysicalOptionModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPhysicalOptionModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityPhysicalOptionModel", ValidationType.TYPE_FORMAT, "CommodityPhysicalOptionModel", path, "", res.getError());
				}
				return success("CommodityPhysicalOptionModel", ValidationType.TYPE_FORMAT, "CommodityPhysicalOptionModel", path, "");
			})
			.collect(toList());
	}

}
