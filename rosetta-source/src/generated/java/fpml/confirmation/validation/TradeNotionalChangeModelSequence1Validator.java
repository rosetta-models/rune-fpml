package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TradeNotionalChangeModelSequence1;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeNotionalChangeModelSequence1Validator implements Validator<TradeNotionalChangeModelSequence1> {

	private List<ComparisonResult> getComparisonResults(TradeNotionalChangeModelSequence1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("changeInNumberOfOptions", (BigDecimal) o.getChangeInNumberOfOptions() != null ? 1 : 0, 1, 1), 
				checkCardinality("outstandingNumberOfOptions", (BigDecimal) o.getOutstandingNumberOfOptions() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<TradeNotionalChangeModelSequence1> validate(RosettaPath path, TradeNotionalChangeModelSequence1 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeNotionalChangeModelSequence1", ValidationType.CARDINALITY, "TradeNotionalChangeModelSequence1", path, "", error);
		}
		return success("TradeNotionalChangeModelSequence1", ValidationType.CARDINALITY, "TradeNotionalChangeModelSequence1", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeNotionalChangeModelSequence1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeNotionalChangeModelSequence1", ValidationType.CARDINALITY, "TradeNotionalChangeModelSequence1", path, "", res.getError());
				}
				return success("TradeNotionalChangeModelSequence1", ValidationType.CARDINALITY, "TradeNotionalChangeModelSequence1", path, "");
			})
			.collect(toList());
	}

}
