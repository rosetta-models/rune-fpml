package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BreakageFeePayment;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.CommitmentAdjustment;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanPrepayment;
import fpml.confirmation.Repayment;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanPrepaymentValidator implements Validator<LoanPrepayment> {

	private List<ComparisonResult> getComparisonResults(LoanPrepayment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("eventIdentifier", (List<? extends BusinessEventIdentifier>) o.getEventIdentifier() == null ? 0 : ((List<? extends BusinessEventIdentifier>) o.getEventIdentifier()).size(), 1, 0), 
				checkCardinality("parentEventIdentifier", (BusinessEventIdentifier) o.getParentEventIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("correctedEventIdentifier", (BusinessEventIdentifier) o.getCorrectedEventIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("lenderAndCashDetailsModel", (LenderAndCashDetailsModel) o.getLenderAndCashDetailsModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("comment", (String) o.getComment() != null ? 1 : 0, 0, 1), 
				checkCardinality("businessEventPartiesModel", (BusinessEventPartiesModel) o.getBusinessEventPartiesModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("effectiveDate", (Date) o.getEffectiveDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("facilityReference", (FacilityReference) o.getFacilityReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("repayment", (Repayment) o.getRepayment() != null ? 1 : 0, 1, 1), 
				checkCardinality("commitmentAdjustment", (CommitmentAdjustment) o.getCommitmentAdjustment() != null ? 1 : 0, 0, 1), 
				checkCardinality("breakageFeePayment", (BreakageFeePayment) o.getBreakageFeePayment() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<LoanPrepayment> validate(RosettaPath path, LoanPrepayment o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanPrepayment", ValidationType.CARDINALITY, "LoanPrepayment", path, "", error);
		}
		return success("LoanPrepayment", ValidationType.CARDINALITY, "LoanPrepayment", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanPrepayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanPrepayment", ValidationType.CARDINALITY, "LoanPrepayment", path, "", res.getError());
				}
				return success("LoanPrepayment", ValidationType.CARDINALITY, "LoanPrepayment", path, "");
			})
			.collect(toList());
	}

}
