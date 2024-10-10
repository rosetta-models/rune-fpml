package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ClearingConfirmed;
import fpml.confirmation.ClearingResultsModel;
import fpml.confirmation.CompressionModel;
import fpml.confirmation.CorrelationAndOptionalSequenceModel;
import fpml.confirmation.EventValuationModel;
import fpml.confirmation.NotificationMessageHeader;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.PortfolioReferenceModel;
import fpml.confirmation.ValidationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ClearingConfirmedValidator implements Validator<ClearingConfirmed> {

	private List<ComparisonResult> getComparisonResults(ClearingConfirmed o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("expectedBuild", (Integer) o.getExpectedBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("actualBuild", (Integer) o.getActualBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("header", (NotificationMessageHeader) o.getHeader() != null ? 1 : 0, 1, 1), 
				checkCardinality("validationModel", (ValidationModel) o.getValidationModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("correlationAndOptionalSequenceModel", (CorrelationAndOptionalSequenceModel) o.getCorrelationAndOptionalSequenceModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("onBehalfOfModel", (OnBehalfOfModel) o.getOnBehalfOfModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("compressionModel", (CompressionModel) o.getCompressionModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("portfolioReferenceModel", (PortfolioReferenceModel) o.getPortfolioReferenceModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearingResultsModel", (ClearingResultsModel) o.getClearingResultsModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("eventValuationModel", (EventValuationModel) o.getEventValuationModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("partiesAndAccountsModel", (PartiesAndAccountsModel) o.getPartiesAndAccountsModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ClearingConfirmed> validate(RosettaPath path, ClearingConfirmed o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ClearingConfirmed", ValidationType.CARDINALITY, "ClearingConfirmed", path, "", error);
		}
		return success("ClearingConfirmed", ValidationType.CARDINALITY, "ClearingConfirmed", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ClearingConfirmed o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ClearingConfirmed", ValidationType.CARDINALITY, "ClearingConfirmed", path, "", res.getError());
				}
				return success("ClearingConfirmed", ValidationType.CARDINALITY, "ClearingConfirmed", path, "");
			})
			.collect(toList());
	}

}
