package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EventsOrInfoModel;
import fpml.confirmation.TradeReferenceInformationModel;
import fpml.confirmation.TradingAndPostTradeEventsModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EventsOrInfoModelValidator implements Validator<EventsOrInfoModel> {

	private List<ComparisonResult> getComparisonResults(EventsOrInfoModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("tradingAndPostTradeEventsModel", (TradingAndPostTradeEventsModel) o.getTradingAndPostTradeEventsModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeReferenceInformationModel", (TradeReferenceInformationModel) o.getTradeReferenceInformationModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<EventsOrInfoModel> validate(RosettaPath path, EventsOrInfoModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EventsOrInfoModel", ValidationType.CARDINALITY, "EventsOrInfoModel", path, "", error);
		}
		return success("EventsOrInfoModel", ValidationType.CARDINALITY, "EventsOrInfoModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EventsOrInfoModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EventsOrInfoModel", ValidationType.CARDINALITY, "EventsOrInfoModel", path, "", res.getError());
				}
				return success("EventsOrInfoModel", ValidationType.CARDINALITY, "EventsOrInfoModel", path, "");
			})
			.collect(toList());
	}

}
