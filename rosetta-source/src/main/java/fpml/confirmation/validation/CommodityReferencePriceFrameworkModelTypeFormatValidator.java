package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityReferencePriceFrameworkModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityReferencePriceFrameworkModelTypeFormatValidator implements Validator<CommodityReferencePriceFrameworkModel> {

	private List<ComparisonResult> getComparisonResults(CommodityReferencePriceFrameworkModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityReferencePriceFrameworkModel> validate(RosettaPath path, CommodityReferencePriceFrameworkModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityReferencePriceFrameworkModel", ValidationType.TYPE_FORMAT, "CommodityReferencePriceFrameworkModel", path, "", error);
		}
		return success("CommodityReferencePriceFrameworkModel", ValidationType.TYPE_FORMAT, "CommodityReferencePriceFrameworkModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityReferencePriceFrameworkModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityReferencePriceFrameworkModel", ValidationType.TYPE_FORMAT, "CommodityReferencePriceFrameworkModel", path, "", res.getError());
				}
				return success("CommodityReferencePriceFrameworkModel", ValidationType.TYPE_FORMAT, "CommodityReferencePriceFrameworkModel", path, "");
			})
			.collect(toList());
	}

}
