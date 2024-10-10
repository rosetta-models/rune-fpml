package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AbstractLoanTradePaymentNotification;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.LoanTradePayment;
import fpml.confirmation.LoanTradingPartyRole;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartyReference;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AbstractLoanTradePaymentNotificationValidator implements Validator<AbstractLoanTradePaymentNotification> {

	private List<ComparisonResult> getComparisonResults(AbstractLoanTradePaymentNotification o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("expectedBuild", (Integer) o.getExpectedBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("actualBuild", (Integer) o.getActualBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("header", (RequestMessageHeader) o.getHeader() != null ? 1 : 0, 1, 1), 
				checkCardinality("validationModel", (ValidationModel) o.getValidationModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("isCorrection", (Boolean) o.getIsCorrection() != null ? 1 : 0, 1, 1), 
				checkCardinality("correlationAndSequenceModel", (CorrelationAndSequenceModel) o.getCorrelationAndSequenceModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("onBehalfOfModel", (OnBehalfOfModel) o.getOnBehalfOfModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("noticeDate", (Date) o.getNoticeDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("partyReference", (PartyReference) o.getPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("role", (LoanTradingPartyRole) o.getRole() != null ? 1 : 0, 1, 1), 
				checkCardinality("payment", (List<? extends LoanTradePayment>) o.getPayment() == null ? 0 : ((List<? extends LoanTradePayment>) o.getPayment()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<AbstractLoanTradePaymentNotification> validate(RosettaPath path, AbstractLoanTradePaymentNotification o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AbstractLoanTradePaymentNotification", ValidationType.CARDINALITY, "AbstractLoanTradePaymentNotification", path, "", error);
		}
		return success("AbstractLoanTradePaymentNotification", ValidationType.CARDINALITY, "AbstractLoanTradePaymentNotification", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AbstractLoanTradePaymentNotification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AbstractLoanTradePaymentNotification", ValidationType.CARDINALITY, "AbstractLoanTradePaymentNotification", path, "", res.getError());
				}
				return success("AbstractLoanTradePaymentNotification", ValidationType.CARDINALITY, "AbstractLoanTradePaymentNotification", path, "");
			})
			.collect(toList());
	}

}
