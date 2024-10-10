package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AssetPool;
import fpml.confirmation.BondCalculationModel;
import fpml.confirmation.ClearanceSystem;
import fpml.confirmation.ExchangeId;
import fpml.confirmation.FixedIncomeSecurityContentModel;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.LegalEntity;
import fpml.confirmation.LegalEntityReference;
import fpml.confirmation.Mortgage;
import fpml.confirmation.MortgageSector;
import fpml.confirmation.ProductReference;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MortgageValidator implements Validator<Mortgage> {

	private List<ComparisonResult> getComparisonResults(Mortgage o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("instrumentId", (List<? extends InstrumentId>) o.getInstrumentId() == null ? 0 : ((List<? extends InstrumentId>) o.getInstrumentId()).size(), 1, 0), 
				checkCardinality("description", (String) o.getDescription() != null ? 1 : 0, 0, 1), 
				checkCardinality("currency", (IdentifiedCurrency) o.getCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("exchangeId", (ExchangeId) o.getExchangeId() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearanceSystem", (ClearanceSystem) o.getClearanceSystem() != null ? 1 : 0, 0, 1), 
				checkCardinality("definition", (ProductReference) o.getDefinition() != null ? 1 : 0, 0, 1), 
				checkCardinality("insurer", (LegalEntity) o.getInsurer() != null ? 1 : 0, 0, 1), 
				checkCardinality("insurerReference", (LegalEntityReference) o.getInsurerReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedIncomeSecurityContentModel", (FixedIncomeSecurityContentModel) o.getFixedIncomeSecurityContentModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("bondCalculationModel", (BondCalculationModel) o.getBondCalculationModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("originalPrincipalAmount", (BigDecimal) o.getOriginalPrincipalAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("pool", (AssetPool) o.getPool() != null ? 1 : 0, 0, 1), 
				checkCardinality("sector", (MortgageSector) o.getSector() != null ? 1 : 0, 0, 1), 
				checkCardinality("tranche", (String) o.getTranche() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<Mortgage> validate(RosettaPath path, Mortgage o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Mortgage", ValidationType.CARDINALITY, "Mortgage", path, "", error);
		}
		return success("Mortgage", ValidationType.CARDINALITY, "Mortgage", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Mortgage o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Mortgage", ValidationType.CARDINALITY, "Mortgage", path, "", res.getError());
				}
				return success("Mortgage", ValidationType.CARDINALITY, "Mortgage", path, "");
			})
			.collect(toList());
	}

}
