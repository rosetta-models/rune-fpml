package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityFixedInterestCalculation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityFixedInterestCalculationTypeFormatValidator implements Validator<CommodityFixedInterestCalculation> {

	private List<ComparisonResult> getComparisonResults(CommodityFixedInterestCalculation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityFixedInterestCalculation> validate(RosettaPath path, CommodityFixedInterestCalculation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityFixedInterestCalculation", ValidationType.TYPE_FORMAT, "CommodityFixedInterestCalculation", path, "", error);
		}
		return success("CommodityFixedInterestCalculation", ValidationType.TYPE_FORMAT, "CommodityFixedInterestCalculation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityFixedInterestCalculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityFixedInterestCalculation", ValidationType.TYPE_FORMAT, "CommodityFixedInterestCalculation", path, "", res.getError());
				}
				return success("CommodityFixedInterestCalculation", ValidationType.TYPE_FORMAT, "CommodityFixedInterestCalculation", path, "");
			})
			.collect(toList());
	}

}
