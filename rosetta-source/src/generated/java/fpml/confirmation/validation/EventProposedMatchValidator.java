package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdditionalEvent;
import fpml.confirmation.ChangeEventsBaseModel;
import fpml.confirmation.EventProposedMatch;
import fpml.confirmation.OptionsEventsBaseModel;
import fpml.confirmation.PostTradeEventsBaseModel;
import fpml.confirmation.ProposedMatchModel;
import fpml.confirmation.TradingEventsBaseModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EventProposedMatchValidator implements Validator<EventProposedMatch> {

	private List<ComparisonResult> getComparisonResults(EventProposedMatch o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("tradingEventsBaseModel", (TradingEventsBaseModel) o.getTradingEventsBaseModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("postTradeEventsBaseModel", (PostTradeEventsBaseModel) o.getPostTradeEventsBaseModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("changeEventsBaseModel", (ChangeEventsBaseModel) o.getChangeEventsBaseModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionsEventsBaseModel", (OptionsEventsBaseModel) o.getOptionsEventsBaseModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalEvent", (AdditionalEvent) o.getAdditionalEvent() != null ? 1 : 0, 0, 1), 
				checkCardinality("proposedMatchModel", (ProposedMatchModel) o.getProposedMatchModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<EventProposedMatch> validate(RosettaPath path, EventProposedMatch o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EventProposedMatch", ValidationType.CARDINALITY, "EventProposedMatch", path, "", error);
		}
		return success("EventProposedMatch", ValidationType.CARDINALITY, "EventProposedMatch", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EventProposedMatch o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EventProposedMatch", ValidationType.CARDINALITY, "EventProposedMatch", path, "", res.getError());
				}
				return success("EventProposedMatch", ValidationType.CARDINALITY, "EventProposedMatch", path, "");
			})
			.collect(toList());
	}

}
