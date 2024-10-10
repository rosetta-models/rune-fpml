package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityFixedPhysicalQuantityModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityFixedPhysicalQuantityModelTypeFormatValidator implements Validator<CommodityFixedPhysicalQuantityModel> {

	private List<ComparisonResult> getComparisonResults(CommodityFixedPhysicalQuantityModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityFixedPhysicalQuantityModel> validate(RosettaPath path, CommodityFixedPhysicalQuantityModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityFixedPhysicalQuantityModel", ValidationType.TYPE_FORMAT, "CommodityFixedPhysicalQuantityModel", path, "", error);
		}
		return success("CommodityFixedPhysicalQuantityModel", ValidationType.TYPE_FORMAT, "CommodityFixedPhysicalQuantityModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityFixedPhysicalQuantityModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityFixedPhysicalQuantityModel", ValidationType.TYPE_FORMAT, "CommodityFixedPhysicalQuantityModel", path, "", res.getError());
				}
				return success("CommodityFixedPhysicalQuantityModel", ValidationType.TYPE_FORMAT, "CommodityFixedPhysicalQuantityModel", path, "");
			})
			.collect(toList());
	}

}
