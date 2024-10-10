package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TradeCategory;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeCategoryValidator implements Validator<TradeCategory> {

	private List<ComparisonResult> getComparisonResults(TradeCategory o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("categoryScheme", (String) o.getCategoryScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<TradeCategory> validate(RosettaPath path, TradeCategory o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeCategory", ValidationType.CARDINALITY, "TradeCategory", path, "", error);
		}
		return success("TradeCategory", ValidationType.CARDINALITY, "TradeCategory", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeCategory o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeCategory", ValidationType.CARDINALITY, "TradeCategory", path, "", res.getError());
				}
				return success("TradeCategory", ValidationType.CARDINALITY, "TradeCategory", path, "");
			})
			.collect(toList());
	}

}
