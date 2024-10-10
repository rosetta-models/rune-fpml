package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityVarianceLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityVarianceLegTypeFormatValidator implements Validator<CommodityVarianceLeg> {

	private List<ComparisonResult> getComparisonResults(CommodityVarianceLeg o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityVarianceLeg> validate(RosettaPath path, CommodityVarianceLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityVarianceLeg", ValidationType.TYPE_FORMAT, "CommodityVarianceLeg", path, "", error);
		}
		return success("CommodityVarianceLeg", ValidationType.TYPE_FORMAT, "CommodityVarianceLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityVarianceLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityVarianceLeg", ValidationType.TYPE_FORMAT, "CommodityVarianceLeg", path, "", res.getError());
				}
				return success("CommodityVarianceLeg", ValidationType.TYPE_FORMAT, "CommodityVarianceLeg", path, "");
			})
			.collect(toList());
	}

}
