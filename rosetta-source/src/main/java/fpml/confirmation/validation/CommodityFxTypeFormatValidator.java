package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityFx;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityFxTypeFormatValidator implements Validator<CommodityFx> {

	private List<ComparisonResult> getComparisonResults(CommodityFx o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityFx> validate(RosettaPath path, CommodityFx o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityFx", ValidationType.TYPE_FORMAT, "CommodityFx", path, "", error);
		}
		return success("CommodityFx", ValidationType.TYPE_FORMAT, "CommodityFx", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityFx o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityFx", ValidationType.TYPE_FORMAT, "CommodityFx", path, "", res.getError());
				}
				return success("CommodityFx", ValidationType.TYPE_FORMAT, "CommodityFx", path, "");
			})
			.collect(toList());
	}

}
