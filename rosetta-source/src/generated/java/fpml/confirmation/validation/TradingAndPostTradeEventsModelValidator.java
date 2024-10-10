package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdditionalEvent;
import fpml.confirmation.PostTradeEventsBaseModel;
import fpml.confirmation.TradingAndPostTradeEventsModel;
import fpml.confirmation.TradingEventsBaseModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradingAndPostTradeEventsModelValidator implements Validator<TradingAndPostTradeEventsModel> {

	private List<ComparisonResult> getComparisonResults(TradingAndPostTradeEventsModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("tradingEventsBaseModel", (TradingEventsBaseModel) o.getTradingEventsBaseModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("postTradeEventsBaseModel", (PostTradeEventsBaseModel) o.getPostTradeEventsBaseModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalEvent", (AdditionalEvent) o.getAdditionalEvent() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<TradingAndPostTradeEventsModel> validate(RosettaPath path, TradingAndPostTradeEventsModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradingAndPostTradeEventsModel", ValidationType.CARDINALITY, "TradingAndPostTradeEventsModel", path, "", error);
		}
		return success("TradingAndPostTradeEventsModel", ValidationType.CARDINALITY, "TradingAndPostTradeEventsModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradingAndPostTradeEventsModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradingAndPostTradeEventsModel", ValidationType.CARDINALITY, "TradingAndPostTradeEventsModel", path, "", res.getError());
				}
				return success("TradingAndPostTradeEventsModel", ValidationType.CARDINALITY, "TradingAndPostTradeEventsModel", path, "");
			})
			.collect(toList());
	}

}
