package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityForwardLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityForwardLegTypeFormatValidator implements Validator<CommodityForwardLeg> {

	private List<ComparisonResult> getComparisonResults(CommodityForwardLeg o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityForwardLeg> validate(RosettaPath path, CommodityForwardLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityForwardLeg", ValidationType.TYPE_FORMAT, "CommodityForwardLeg", path, "", error);
		}
		return success("CommodityForwardLeg", ValidationType.TYPE_FORMAT, "CommodityForwardLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityForwardLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityForwardLeg", ValidationType.TYPE_FORMAT, "CommodityForwardLeg", path, "", res.getError());
				}
				return success("CommodityForwardLeg", ValidationType.TYPE_FORMAT, "CommodityForwardLeg", path, "");
			})
			.collect(toList());
	}

}
