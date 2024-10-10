package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ClearanceSystem;
import fpml.confirmation.CreditSeniority;
import fpml.confirmation.ExchangeId;
import fpml.confirmation.FacilityType;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.Lien;
import fpml.confirmation.Loan;
import fpml.confirmation.ProductReference;
import fpml.confirmation.UnderlyingAssetTranche;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanValidator implements Validator<Loan> {

	private List<ComparisonResult> getComparisonResults(Loan o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("instrumentId", (List<? extends InstrumentId>) o.getInstrumentId() == null ? 0 : ((List<? extends InstrumentId>) o.getInstrumentId()).size(), 1, 0), 
				checkCardinality("description", (String) o.getDescription() != null ? 1 : 0, 0, 1), 
				checkCardinality("currency", (IdentifiedCurrency) o.getCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("exchangeId", (ExchangeId) o.getExchangeId() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearanceSystem", (ClearanceSystem) o.getClearanceSystem() != null ? 1 : 0, 0, 1), 
				checkCardinality("definition", (ProductReference) o.getDefinition() != null ? 1 : 0, 0, 1), 
				checkCardinality("lien", (Lien) o.getLien() != null ? 1 : 0, 0, 1), 
				checkCardinality("facilityType", (FacilityType) o.getFacilityType() != null ? 1 : 0, 0, 1), 
				checkCardinality("maturity", (Date) o.getMaturity() != null ? 1 : 0, 0, 1), 
				checkCardinality("creditAgreementDate", (Date) o.getCreditAgreementDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("tranche", (UnderlyingAssetTranche) o.getTranche() != null ? 1 : 0, 0, 1), 
				checkCardinality("seniority", (CreditSeniority) o.getSeniority() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<Loan> validate(RosettaPath path, Loan o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Loan", ValidationType.CARDINALITY, "Loan", path, "", error);
		}
		return success("Loan", ValidationType.CARDINALITY, "Loan", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Loan o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Loan", ValidationType.CARDINALITY, "Loan", path, "", res.getError());
				}
				return success("Loan", ValidationType.CARDINALITY, "Loan", path, "");
			})
			.collect(toList());
	}

}
