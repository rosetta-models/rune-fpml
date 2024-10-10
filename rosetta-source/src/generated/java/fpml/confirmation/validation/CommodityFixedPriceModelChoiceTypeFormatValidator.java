package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityFixedPriceModelChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityFixedPriceModelChoiceTypeFormatValidator implements Validator<CommodityFixedPriceModelChoice> {

	private List<ComparisonResult> getComparisonResults(CommodityFixedPriceModelChoice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityFixedPriceModelChoice> validate(RosettaPath path, CommodityFixedPriceModelChoice o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityFixedPriceModelChoice", ValidationType.TYPE_FORMAT, "CommodityFixedPriceModelChoice", path, "", error);
		}
		return success("CommodityFixedPriceModelChoice", ValidationType.TYPE_FORMAT, "CommodityFixedPriceModelChoice", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityFixedPriceModelChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityFixedPriceModelChoice", ValidationType.TYPE_FORMAT, "CommodityFixedPriceModelChoice", path, "", res.getError());
				}
				return success("CommodityFixedPriceModelChoice", ValidationType.TYPE_FORMAT, "CommodityFixedPriceModelChoice", path, "");
			})
			.collect(toList());
	}

}
