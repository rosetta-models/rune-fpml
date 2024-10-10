package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityPhysicalQuantityBase;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityPhysicalQuantityBaseTypeFormatValidator implements Validator<CommodityPhysicalQuantityBase> {

	private List<ComparisonResult> getComparisonResults(CommodityPhysicalQuantityBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityPhysicalQuantityBase> validate(RosettaPath path, CommodityPhysicalQuantityBase o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityPhysicalQuantityBase", ValidationType.TYPE_FORMAT, "CommodityPhysicalQuantityBase", path, "", error);
		}
		return success("CommodityPhysicalQuantityBase", ValidationType.TYPE_FORMAT, "CommodityPhysicalQuantityBase", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPhysicalQuantityBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityPhysicalQuantityBase", ValidationType.TYPE_FORMAT, "CommodityPhysicalQuantityBase", path, "", res.getError());
				}
				return success("CommodityPhysicalQuantityBase", ValidationType.TYPE_FORMAT, "CommodityPhysicalQuantityBase", path, "");
			})
			.collect(toList());
	}

}
