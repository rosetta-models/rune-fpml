package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityAsianModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityAsianModelTypeFormatValidator implements Validator<CommodityAsianModel> {

	private List<ComparisonResult> getComparisonResults(CommodityAsianModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityAsianModel> validate(RosettaPath path, CommodityAsianModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityAsianModel", ValidationType.TYPE_FORMAT, "CommodityAsianModel", path, "", error);
		}
		return success("CommodityAsianModel", ValidationType.TYPE_FORMAT, "CommodityAsianModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityAsianModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityAsianModel", ValidationType.TYPE_FORMAT, "CommodityAsianModel", path, "", res.getError());
				}
				return success("CommodityAsianModel", ValidationType.TYPE_FORMAT, "CommodityAsianModel", path, "");
			})
			.collect(toList());
	}

}
