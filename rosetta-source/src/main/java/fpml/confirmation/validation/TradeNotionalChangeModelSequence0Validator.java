package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.TradeNotionalChangeModelSequence0;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeNotionalChangeModelSequence0Validator implements Validator<TradeNotionalChangeModelSequence0> {

	private List<ComparisonResult> getComparisonResults(TradeNotionalChangeModelSequence0 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("changeInNotionalAmount", (List<? extends NonNegativeMoney>) o.getChangeInNotionalAmount() == null ? 0 : ((List<? extends NonNegativeMoney>) o.getChangeInNotionalAmount()).size(), 1, 0), 
				checkCardinality("outstandingNotionalAmount", (List<? extends NonNegativeMoney>) o.getOutstandingNotionalAmount() == null ? 0 : ((List<? extends NonNegativeMoney>) o.getOutstandingNotionalAmount()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<TradeNotionalChangeModelSequence0> validate(RosettaPath path, TradeNotionalChangeModelSequence0 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeNotionalChangeModelSequence0", ValidationType.CARDINALITY, "TradeNotionalChangeModelSequence0", path, "", error);
		}
		return success("TradeNotionalChangeModelSequence0", ValidationType.CARDINALITY, "TradeNotionalChangeModelSequence0", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeNotionalChangeModelSequence0 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeNotionalChangeModelSequence0", ValidationType.CARDINALITY, "TradeNotionalChangeModelSequence0", path, "", res.getError());
				}
				return success("TradeNotionalChangeModelSequence0", ValidationType.CARDINALITY, "TradeNotionalChangeModelSequence0", path, "");
			})
			.collect(toList());
	}

}
