package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CorrelationAndOptionalSequenceModel;
import fpml.confirmation.ExecutionAdviceAcknowledgement;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.ResponseMessageHeader;
import fpml.confirmation.TradeReferenceInformationModel;
import fpml.confirmation.UnprocessedElementWrapper;
import fpml.confirmation.ValidationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ExecutionAdviceAcknowledgementValidator implements Validator<ExecutionAdviceAcknowledgement> {

	private List<ComparisonResult> getComparisonResults(ExecutionAdviceAcknowledgement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("expectedBuild", (Integer) o.getExpectedBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("actualBuild", (Integer) o.getActualBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("header", (ResponseMessageHeader) o.getHeader() != null ? 1 : 0, 1, 1), 
				checkCardinality("validationModel", (ValidationModel) o.getValidationModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("correlationAndOptionalSequenceModel", (CorrelationAndOptionalSequenceModel) o.getCorrelationAndOptionalSequenceModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("onBehalfOfModel", (OnBehalfOfModel) o.getOnBehalfOfModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("originalMessage", (UnprocessedElementWrapper) o.getOriginalMessage() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeReferenceInformationModel", (TradeReferenceInformationModel) o.getTradeReferenceInformationModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("partiesAndAccountsModel", (PartiesAndAccountsModel) o.getPartiesAndAccountsModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ExecutionAdviceAcknowledgement> validate(RosettaPath path, ExecutionAdviceAcknowledgement o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ExecutionAdviceAcknowledgement", ValidationType.CARDINALITY, "ExecutionAdviceAcknowledgement", path, "", error);
		}
		return success("ExecutionAdviceAcknowledgement", ValidationType.CARDINALITY, "ExecutionAdviceAcknowledgement", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExecutionAdviceAcknowledgement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExecutionAdviceAcknowledgement", ValidationType.CARDINALITY, "ExecutionAdviceAcknowledgement", path, "", res.getError());
				}
				return success("ExecutionAdviceAcknowledgement", ValidationType.CARDINALITY, "ExecutionAdviceAcknowledgement", path, "");
			})
			.collect(toList());
	}

}
