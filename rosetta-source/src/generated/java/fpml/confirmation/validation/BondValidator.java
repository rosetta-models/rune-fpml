package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Bond;
import fpml.confirmation.BondCalculationModel;
import fpml.confirmation.ClearanceSystem;
import fpml.confirmation.ExchangeId;
import fpml.confirmation.FixedIncomeSecurityContentModel;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.ProductReference;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BondValidator implements Validator<Bond> {

	private List<ComparisonResult> getComparisonResults(Bond o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("instrumentId", (List<? extends InstrumentId>) o.getInstrumentId() == null ? 0 : ((List<? extends InstrumentId>) o.getInstrumentId()).size(), 1, 0), 
				checkCardinality("description", (String) o.getDescription() != null ? 1 : 0, 0, 1), 
				checkCardinality("currency", (IdentifiedCurrency) o.getCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("exchangeId", (ExchangeId) o.getExchangeId() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearanceSystem", (ClearanceSystem) o.getClearanceSystem() != null ? 1 : 0, 0, 1), 
				checkCardinality("definition", (ProductReference) o.getDefinition() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedIncomeSecurityContentModel", (FixedIncomeSecurityContentModel) o.getFixedIncomeSecurityContentModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("parValue", (BigDecimal) o.getParValue() != null ? 1 : 0, 0, 1), 
				checkCardinality("faceAmount", (BigDecimal) o.getFaceAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("bondCalculationModel", (BondCalculationModel) o.getBondCalculationModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<Bond> validate(RosettaPath path, Bond o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Bond", ValidationType.CARDINALITY, "Bond", path, "", error);
		}
		return success("Bond", ValidationType.CARDINALITY, "Bond", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Bond o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Bond", ValidationType.CARDINALITY, "Bond", path, "", res.getError());
				}
				return success("Bond", ValidationType.CARDINALITY, "Bond", path, "");
			})
			.collect(toList());
	}

}
