package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityFloatingStrikePriceModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityFloatingStrikePriceModelTypeFormatValidator implements Validator<CommodityFloatingStrikePriceModel> {

	private List<ComparisonResult> getComparisonResults(CommodityFloatingStrikePriceModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityFloatingStrikePriceModel> validate(RosettaPath path, CommodityFloatingStrikePriceModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityFloatingStrikePriceModel", ValidationType.TYPE_FORMAT, "CommodityFloatingStrikePriceModel", path, "", error);
		}
		return success("CommodityFloatingStrikePriceModel", ValidationType.TYPE_FORMAT, "CommodityFloatingStrikePriceModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityFloatingStrikePriceModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityFloatingStrikePriceModel", ValidationType.TYPE_FORMAT, "CommodityFloatingStrikePriceModel", path, "", res.getError());
				}
				return success("CommodityFloatingStrikePriceModel", ValidationType.TYPE_FORMAT, "CommodityFloatingStrikePriceModel", path, "");
			})
			.collect(toList());
	}

}
