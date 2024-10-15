package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityStrikePriceModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityStrikePriceModelTypeFormatValidator implements Validator<CommodityStrikePriceModel> {

	private List<ComparisonResult> getComparisonResults(CommodityStrikePriceModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityStrikePriceModel> validate(RosettaPath path, CommodityStrikePriceModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityStrikePriceModel", ValidationType.TYPE_FORMAT, "CommodityStrikePriceModel", path, "", error);
		}
		return success("CommodityStrikePriceModel", ValidationType.TYPE_FORMAT, "CommodityStrikePriceModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityStrikePriceModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityStrikePriceModel", ValidationType.TYPE_FORMAT, "CommodityStrikePriceModel", path, "", res.getError());
				}
				return success("CommodityStrikePriceModel", ValidationType.TYPE_FORMAT, "CommodityStrikePriceModel", path, "");
			})
			.collect(toList());
	}

}
