package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanContractReference;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.Repayment;
import fpml.confirmation.RepaymentTypeModel;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RepaymentValidator implements Validator<Repayment> {

	private List<ComparisonResult> getComparisonResults(Repayment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("eventIdentifier", (List<? extends BusinessEventIdentifier>) o.getEventIdentifier() == null ? 0 : ((List<? extends BusinessEventIdentifier>) o.getEventIdentifier()).size(), 1, 0), 
				checkCardinality("parentEventIdentifier", (BusinessEventIdentifier) o.getParentEventIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("correctedEventIdentifier", (BusinessEventIdentifier) o.getCorrectedEventIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("lenderAndCashDetailsModel", (LenderAndCashDetailsModel) o.getLenderAndCashDetailsModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("comment", (String) o.getComment() != null ? 1 : 0, 0, 1), 
				checkCardinality("businessEventPartiesModel", (BusinessEventPartiesModel) o.getBusinessEventPartiesModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("effectiveDate", (Date) o.getEffectiveDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("loanContractReference", (LoanContractReference) o.getLoanContractReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("amount", (MoneyWithParticipantShare) o.getAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("price", (BigDecimal) o.getPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("repaymentTypeModel", (RepaymentTypeModel) o.getRepaymentTypeModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<Repayment> validate(RosettaPath path, Repayment o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Repayment", ValidationType.CARDINALITY, "Repayment", path, "", error);
		}
		return success("Repayment", ValidationType.CARDINALITY, "Repayment", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Repayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Repayment", ValidationType.CARDINALITY, "Repayment", path, "", res.getError());
				}
				return success("Repayment", ValidationType.CARDINALITY, "Repayment", path, "");
			})
			.collect(toList());
	}

}
