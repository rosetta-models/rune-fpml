package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TimestampTypeScheme;
import fpml.confirmation.TradeTimestamp;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeTimestampValidator implements Validator<TradeTimestamp> {

	private List<ComparisonResult> getComparisonResults(TradeTimestamp o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("type", (TimestampTypeScheme) o.getType() != null ? 1 : 0, 1, 1), 
				checkCardinality("value", (ZonedDateTime) o.getValue() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<TradeTimestamp> validate(RosettaPath path, TradeTimestamp o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeTimestamp", ValidationType.CARDINALITY, "TradeTimestamp", path, "", error);
		}
		return success("TradeTimestamp", ValidationType.CARDINALITY, "TradeTimestamp", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeTimestamp o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeTimestamp", ValidationType.CARDINALITY, "TradeTimestamp", path, "", res.getError());
				}
				return success("TradeTimestamp", ValidationType.CARDINALITY, "TradeTimestamp", path, "");
			})
			.collect(toList());
	}

}
