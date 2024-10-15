package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AccruingPikPayment;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.PeriodModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AccruingPikPaymentValidator implements Validator<AccruingPikPayment> {

	private List<ComparisonResult> getComparisonResults(AccruingPikPayment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("eventIdentifier", (List<? extends BusinessEventIdentifier>) o.getEventIdentifier() == null ? 0 : ((List<? extends BusinessEventIdentifier>) o.getEventIdentifier()).size(), 1, 0), 
				checkCardinality("parentEventIdentifier", (BusinessEventIdentifier) o.getParentEventIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("correctedEventIdentifier", (BusinessEventIdentifier) o.getCorrectedEventIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("lenderAndCashDetailsModel", (LenderAndCashDetailsModel) o.getLenderAndCashDetailsModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("comment", (String) o.getComment() != null ? 1 : 0, 0, 1), 
				checkCardinality("businessEventPartiesModel", (BusinessEventPartiesModel) o.getBusinessEventPartiesModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("effectiveDate", (Date) o.getEffectiveDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("facilityReference", (FacilityReference) o.getFacilityReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("periodModel", (PeriodModel) o.getPeriodModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("amount", (MoneyWithParticipantShare) o.getAmount() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<AccruingPikPayment> validate(RosettaPath path, AccruingPikPayment o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AccruingPikPayment", ValidationType.CARDINALITY, "AccruingPikPayment", path, "", error);
		}
		return success("AccruingPikPayment", ValidationType.CARDINALITY, "AccruingPikPayment", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AccruingPikPayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AccruingPikPayment", ValidationType.CARDINALITY, "AccruingPikPayment", path, "", res.getError());
				}
				return success("AccruingPikPayment", ValidationType.CARDINALITY, "AccruingPikPayment", path, "");
			})
			.collect(toList());
	}

}
