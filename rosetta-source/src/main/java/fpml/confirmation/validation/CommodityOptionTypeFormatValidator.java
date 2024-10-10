package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityOption;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityOptionTypeFormatValidator implements Validator<CommodityOption> {

	private List<ComparisonResult> getComparisonResults(CommodityOption o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityOption> validate(RosettaPath path, CommodityOption o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityOption", ValidationType.TYPE_FORMAT, "CommodityOption", path, "", error);
		}
		return success("CommodityOption", ValidationType.TYPE_FORMAT, "CommodityOption", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityOption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityOption", ValidationType.TYPE_FORMAT, "CommodityOption", path, "", res.getError());
				}
				return success("CommodityOption", ValidationType.TYPE_FORMAT, "CommodityOption", path, "");
			})
			.collect(toList());
	}

}
