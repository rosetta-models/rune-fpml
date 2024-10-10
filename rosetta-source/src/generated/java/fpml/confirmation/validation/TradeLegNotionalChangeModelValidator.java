package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.NotionalReference;
import fpml.confirmation.TradeLegNotionalChangeModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeLegNotionalChangeModelValidator implements Validator<TradeLegNotionalChangeModel> {

	private List<ComparisonResult> getComparisonResults(TradeLegNotionalChangeModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("notionalReference", (NotionalReference) o.getNotionalReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("changeInNotionalAmount", (NonNegativeMoney) o.getChangeInNotionalAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("outstandingNotionalAmount", (NonNegativeMoney) o.getOutstandingNotionalAmount() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<TradeLegNotionalChangeModel> validate(RosettaPath path, TradeLegNotionalChangeModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeLegNotionalChangeModel", ValidationType.CARDINALITY, "TradeLegNotionalChangeModel", path, "", error);
		}
		return success("TradeLegNotionalChangeModel", ValidationType.CARDINALITY, "TradeLegNotionalChangeModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeLegNotionalChangeModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeLegNotionalChangeModel", ValidationType.CARDINALITY, "TradeLegNotionalChangeModel", path, "", res.getError());
				}
				return success("TradeLegNotionalChangeModel", ValidationType.CARDINALITY, "TradeLegNotionalChangeModel", path, "");
			})
			.collect(toList());
	}

}
