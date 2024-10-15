package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityForward;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityForwardTypeFormatValidator implements Validator<CommodityForward> {

	private List<ComparisonResult> getComparisonResults(CommodityForward o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityForward> validate(RosettaPath path, CommodityForward o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityForward", ValidationType.TYPE_FORMAT, "CommodityForward", path, "", error);
		}
		return success("CommodityForward", ValidationType.TYPE_FORMAT, "CommodityForward", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityForward o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityForward", ValidationType.TYPE_FORMAT, "CommodityForward", path, "", res.getError());
				}
				return success("CommodityForward", ValidationType.TYPE_FORMAT, "CommodityForward", path, "");
			})
			.collect(toList());
	}

}
