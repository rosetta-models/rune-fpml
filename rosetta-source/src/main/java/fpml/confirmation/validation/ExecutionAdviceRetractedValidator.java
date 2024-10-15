package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdditionalEvent;
import fpml.confirmation.ChangeEventsBaseModel;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.ExecutionAdviceRetracted;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.OptionsEventsBaseModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.PostTradeEventsBaseModel;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.TradingEventsBaseModel;
import fpml.confirmation.ValidationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ExecutionAdviceRetractedValidator implements Validator<ExecutionAdviceRetracted> {

	private List<ComparisonResult> getComparisonResults(ExecutionAdviceRetracted o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("expectedBuild", (Integer) o.getExpectedBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("actualBuild", (Integer) o.getActualBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("header", (RequestMessageHeader) o.getHeader() != null ? 1 : 0, 1, 1), 
				checkCardinality("validationModel", (ValidationModel) o.getValidationModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("correlationAndSequenceModel", (CorrelationAndSequenceModel) o.getCorrelationAndSequenceModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("onBehalfOfModel", (OnBehalfOfModel) o.getOnBehalfOfModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradingEventsBaseModel", (TradingEventsBaseModel) o.getTradingEventsBaseModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("postTradeEventsBaseModel", (PostTradeEventsBaseModel) o.getPostTradeEventsBaseModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("changeEventsBaseModel", (ChangeEventsBaseModel) o.getChangeEventsBaseModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionsEventsBaseModel", (OptionsEventsBaseModel) o.getOptionsEventsBaseModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalEvent", (AdditionalEvent) o.getAdditionalEvent() != null ? 1 : 0, 0, 1), 
				checkCardinality("partiesAndAccountsModel", (PartiesAndAccountsModel) o.getPartiesAndAccountsModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ExecutionAdviceRetracted> validate(RosettaPath path, ExecutionAdviceRetracted o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ExecutionAdviceRetracted", ValidationType.CARDINALITY, "ExecutionAdviceRetracted", path, "", error);
		}
		return success("ExecutionAdviceRetracted", ValidationType.CARDINALITY, "ExecutionAdviceRetracted", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExecutionAdviceRetracted o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExecutionAdviceRetracted", ValidationType.CARDINALITY, "ExecutionAdviceRetracted", path, "", res.getError());
				}
				return success("ExecutionAdviceRetracted", ValidationType.CARDINALITY, "ExecutionAdviceRetracted", path, "");
			})
			.collect(toList());
	}

}
