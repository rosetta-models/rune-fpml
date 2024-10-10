package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityReturnLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityReturnLegTypeFormatValidator implements Validator<CommodityReturnLeg> {

	private List<ComparisonResult> getComparisonResults(CommodityReturnLeg o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityReturnLeg> validate(RosettaPath path, CommodityReturnLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityReturnLeg", ValidationType.TYPE_FORMAT, "CommodityReturnLeg", path, "", error);
		}
		return success("CommodityReturnLeg", ValidationType.TYPE_FORMAT, "CommodityReturnLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityReturnLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityReturnLeg", ValidationType.TYPE_FORMAT, "CommodityReturnLeg", path, "", res.getError());
				}
				return success("CommodityReturnLeg", ValidationType.TYPE_FORMAT, "CommodityReturnLeg", path, "");
			})
			.collect(toList());
	}

}
