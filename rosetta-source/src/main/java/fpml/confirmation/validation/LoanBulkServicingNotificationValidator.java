package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.LoanBulkServicingNotification;
import fpml.confirmation.LoanBulkServicingNotificationChoice0;
import fpml.confirmation.LoanBulkServicingNotificationChoice1;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanBulkServicingNotificationValidator implements Validator<LoanBulkServicingNotification> {

	private List<ComparisonResult> getComparisonResults(LoanBulkServicingNotification o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("expectedBuild", (Integer) o.getExpectedBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("actualBuild", (Integer) o.getActualBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("header", (RequestMessageHeader) o.getHeader() != null ? 1 : 0, 1, 1), 
				checkCardinality("validationModel", (ValidationModel) o.getValidationModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("isCorrection", (Boolean) o.getIsCorrection() != null ? 1 : 0, 1, 1), 
				checkCardinality("correlationAndSequenceModel", (CorrelationAndSequenceModel) o.getCorrelationAndSequenceModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("onBehalfOfModel", (OnBehalfOfModel) o.getOnBehalfOfModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("noticeDate", (Date) o.getNoticeDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("isGlobalOnly", (Boolean) o.getIsGlobalOnly() != null ? 1 : 0, 1, 1), 
				checkCardinality("loanBulkServicingNotificationChoice0", (List<? extends LoanBulkServicingNotificationChoice0>) o.getLoanBulkServicingNotificationChoice0() == null ? 0 : ((List<? extends LoanBulkServicingNotificationChoice0>) o.getLoanBulkServicingNotificationChoice0()).size(), 2, 0), 
				checkCardinality("loanBulkServicingNotificationChoice1", (List<? extends LoanBulkServicingNotificationChoice1>) o.getLoanBulkServicingNotificationChoice1() == null ? 0 : ((List<? extends LoanBulkServicingNotificationChoice1>) o.getLoanBulkServicingNotificationChoice1()).size(), 1, 0), 
				checkCardinality("party", (List<? extends Party>) o.getParty() == null ? 0 : ((List<? extends Party>) o.getParty()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<LoanBulkServicingNotification> validate(RosettaPath path, LoanBulkServicingNotification o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanBulkServicingNotification", ValidationType.CARDINALITY, "LoanBulkServicingNotification", path, "", error);
		}
		return success("LoanBulkServicingNotification", ValidationType.CARDINALITY, "LoanBulkServicingNotification", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanBulkServicingNotification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanBulkServicingNotification", ValidationType.CARDINALITY, "LoanBulkServicingNotification", path, "", res.getError());
				}
				return success("LoanBulkServicingNotification", ValidationType.CARDINALITY, "LoanBulkServicingNotification", path, "");
			})
			.collect(toList());
	}

}
