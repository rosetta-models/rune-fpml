package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FacilityContractIdentifier;
import fpml.confirmation.FixedRateAccrual;
import fpml.confirmation.FloatingRateAccrual;
import fpml.confirmation.FxTerms;
import fpml.confirmation.LoanContract;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanContractValidator implements Validator<LoanContract> {

	private List<ComparisonResult> getComparisonResults(LoanContract o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("identifier", (List<? extends FacilityContractIdentifier>) o.getIdentifier() == null ? 0 : ((List<? extends FacilityContractIdentifier>) o.getIdentifier()).size(), 1, 0), 
				checkCardinality("effectiveDate", (Date) o.getEffectiveDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("borrowerPartyReference", (PartyReference) o.getBorrowerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("guarantorPartyReference", (PartyReference) o.getGuarantorPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("amount", (MoneyWithParticipantShare) o.getAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("repricingDate", (Date) o.getRepricingDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("maturityDate", (Date) o.getMaturityDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedRateAccrual", (FixedRateAccrual) o.getFixedRateAccrual() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRateAccrual", (FloatingRateAccrual) o.getFloatingRateAccrual() != null ? 1 : 0, 0, 1), 
				checkCardinality("facilityFxRate", (FxTerms) o.getFacilityFxRate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<LoanContract> validate(RosettaPath path, LoanContract o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanContract", ValidationType.CARDINALITY, "LoanContract", path, "", error);
		}
		return success("LoanContract", ValidationType.CARDINALITY, "LoanContract", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanContract o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanContract", ValidationType.CARDINALITY, "LoanContract", path, "", res.getError());
				}
				return success("LoanContract", ValidationType.CARDINALITY, "LoanContract", path, "");
			})
			.collect(toList());
	}

}
