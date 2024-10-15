package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.DeClear;
import fpml.confirmation.EventValuationModel;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.PortfolioReferenceModel;
import fpml.confirmation.RequestClearing;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.TradingEventsModel;
import fpml.confirmation.ValidationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RequestClearingValidator implements Validator<RequestClearing> {

	private List<ComparisonResult> getComparisonResults(RequestClearing o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("expectedBuild", (Integer) o.getExpectedBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("actualBuild", (Integer) o.getActualBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("header", (RequestMessageHeader) o.getHeader() != null ? 1 : 0, 1, 1), 
				checkCardinality("validationModel", (ValidationModel) o.getValidationModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("isCorrection", (Boolean) o.getIsCorrection() != null ? 1 : 0, 1, 1), 
				checkCardinality("correlationAndSequenceModel", (CorrelationAndSequenceModel) o.getCorrelationAndSequenceModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("onBehalfOfModel", (OnBehalfOfModel) o.getOnBehalfOfModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("portfolioReferenceModel", (PortfolioReferenceModel) o.getPortfolioReferenceModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradingEventsModel", (TradingEventsModel) o.getTradingEventsModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("deClear", (DeClear) o.getDeClear() != null ? 1 : 0, 0, 1), 
				checkCardinality("eventValuationModel", (EventValuationModel) o.getEventValuationModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("partiesAndAccountsModel", (PartiesAndAccountsModel) o.getPartiesAndAccountsModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<RequestClearing> validate(RosettaPath path, RequestClearing o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RequestClearing", ValidationType.CARDINALITY, "RequestClearing", path, "", error);
		}
		return success("RequestClearing", ValidationType.CARDINALITY, "RequestClearing", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RequestClearing o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RequestClearing", ValidationType.CARDINALITY, "RequestClearing", path, "", res.getError());
				}
				return success("RequestClearing", ValidationType.CARDINALITY, "RequestClearing", path, "");
			})
			.collect(toList());
	}

}
