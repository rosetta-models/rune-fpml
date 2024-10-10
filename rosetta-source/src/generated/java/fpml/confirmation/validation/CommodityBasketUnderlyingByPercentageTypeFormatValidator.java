package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityBasketUnderlyingByPercentage;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityBasketUnderlyingByPercentageTypeFormatValidator implements Validator<CommodityBasketUnderlyingByPercentage> {

	private List<ComparisonResult> getComparisonResults(CommodityBasketUnderlyingByPercentage o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("constituentWeight", o.getConstituentWeight(), empty(), empty(), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public ValidationResult<CommodityBasketUnderlyingByPercentage> validate(RosettaPath path, CommodityBasketUnderlyingByPercentage o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityBasketUnderlyingByPercentage", ValidationType.TYPE_FORMAT, "CommodityBasketUnderlyingByPercentage", path, "", error);
		}
		return success("CommodityBasketUnderlyingByPercentage", ValidationType.TYPE_FORMAT, "CommodityBasketUnderlyingByPercentage", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityBasketUnderlyingByPercentage o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityBasketUnderlyingByPercentage", ValidationType.TYPE_FORMAT, "CommodityBasketUnderlyingByPercentage", path, "", res.getError());
				}
				return success("CommodityBasketUnderlyingByPercentage", ValidationType.TYPE_FORMAT, "CommodityBasketUnderlyingByPercentage", path, "");
			})
			.collect(toList());
	}

}
