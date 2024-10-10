package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FeeTradeModel;
import fpml.confirmation.NewTradeModel;
import fpml.confirmation.OldTradeModel;
import fpml.confirmation.TradeNovationContentSequence0;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeNovationContentSequence0Validator implements Validator<TradeNovationContentSequence0> {

	private List<ComparisonResult> getComparisonResults(TradeNovationContentSequence0 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("oldTradeModel", (OldTradeModel) o.getOldTradeModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("feeTradeModel", (FeeTradeModel) o.getFeeTradeModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("newTradeModel", (NewTradeModel) o.getNewTradeModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<TradeNovationContentSequence0> validate(RosettaPath path, TradeNovationContentSequence0 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeNovationContentSequence0", ValidationType.CARDINALITY, "TradeNovationContentSequence0", path, "", error);
		}
		return success("TradeNovationContentSequence0", ValidationType.CARDINALITY, "TradeNovationContentSequence0", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeNovationContentSequence0 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeNovationContentSequence0", ValidationType.CARDINALITY, "TradeNovationContentSequence0", path, "", res.getError());
				}
				return success("TradeNovationContentSequence0", ValidationType.CARDINALITY, "TradeNovationContentSequence0", path, "");
			})
			.collect(toList());
	}

}
