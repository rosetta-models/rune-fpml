package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityPremium;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityPremiumTypeFormatValidator implements Validator<CommodityPremium> {

	private List<ComparisonResult> getComparisonResults(CommodityPremium o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityPremium> validate(RosettaPath path, CommodityPremium o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityPremium", ValidationType.TYPE_FORMAT, "CommodityPremium", path, "", error);
		}
		return success("CommodityPremium", ValidationType.TYPE_FORMAT, "CommodityPremium", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPremium o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityPremium", ValidationType.TYPE_FORMAT, "CommodityPremium", path, "", res.getError());
				}
				return success("CommodityPremium", ValidationType.TYPE_FORMAT, "CommodityPremium", path, "");
			})
			.collect(toList());
	}

}
