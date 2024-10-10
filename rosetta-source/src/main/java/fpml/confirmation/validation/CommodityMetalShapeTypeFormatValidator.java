package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityMetalShape;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityMetalShapeTypeFormatValidator implements Validator<CommodityMetalShape> {

	private List<ComparisonResult> getComparisonResults(CommodityMetalShape o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("commodityMetalShapeScheme", o.getCommodityMetalShapeScheme(), 1, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+")))
			);
	}

	@Override
	public ValidationResult<CommodityMetalShape> validate(RosettaPath path, CommodityMetalShape o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityMetalShape", ValidationType.TYPE_FORMAT, "CommodityMetalShape", path, "", error);
		}
		return success("CommodityMetalShape", ValidationType.TYPE_FORMAT, "CommodityMetalShape", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityMetalShape o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityMetalShape", ValidationType.TYPE_FORMAT, "CommodityMetalShape", path, "", res.getError());
				}
				return success("CommodityMetalShape", ValidationType.TYPE_FORMAT, "CommodityMetalShape", path, "");
			})
			.collect(toList());
	}

}
