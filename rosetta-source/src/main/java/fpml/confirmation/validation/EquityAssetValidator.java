package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ClearanceSystem;
import fpml.confirmation.EquityAsset;
import fpml.confirmation.ExchangeId;
import fpml.confirmation.ExchangeIdentifierModel;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.ProductReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EquityAssetValidator implements Validator<EquityAsset> {

	private List<ComparisonResult> getComparisonResults(EquityAsset o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("instrumentId", (List<? extends InstrumentId>) o.getInstrumentId() == null ? 0 : ((List<? extends InstrumentId>) o.getInstrumentId()).size(), 1, 0), 
				checkCardinality("description", (String) o.getDescription() != null ? 1 : 0, 0, 1), 
				checkCardinality("currency", (IdentifiedCurrency) o.getCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("exchangeId", (ExchangeId) o.getExchangeId() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearanceSystem", (ClearanceSystem) o.getClearanceSystem() != null ? 1 : 0, 0, 1), 
				checkCardinality("definition", (ProductReference) o.getDefinition() != null ? 1 : 0, 0, 1), 
				checkCardinality("exchangeIdentifierModel", (ExchangeIdentifierModel) o.getExchangeIdentifierModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<EquityAsset> validate(RosettaPath path, EquityAsset o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EquityAsset", ValidationType.CARDINALITY, "EquityAsset", path, "", error);
		}
		return success("EquityAsset", ValidationType.CARDINALITY, "EquityAsset", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityAsset o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquityAsset", ValidationType.CARDINALITY, "EquityAsset", path, "", res.getError());
				}
				return success("EquityAsset", ValidationType.CARDINALITY, "EquityAsset", path, "");
			})
			.collect(toList());
	}

}
