package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PriceModel;
import fpml.confirmation.SettlementPeriodsFixedPrice;
import fpml.confirmation.SettlementPeriodsReference;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SettlementPeriodsFixedPriceValidator implements Validator<SettlementPeriodsFixedPrice> {

	private List<ComparisonResult> getComparisonResults(SettlementPeriodsFixedPrice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("price", (BigDecimal) o.getPrice() != null ? 1 : 0, 1, 1), 
				checkCardinality("priceModel", (PriceModel) o.getPriceModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementPeriodsReference", (List<? extends SettlementPeriodsReference>) o.getSettlementPeriodsReference() == null ? 0 : ((List<? extends SettlementPeriodsReference>) o.getSettlementPeriodsReference()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<SettlementPeriodsFixedPrice> validate(RosettaPath path, SettlementPeriodsFixedPrice o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SettlementPeriodsFixedPrice", ValidationType.CARDINALITY, "SettlementPeriodsFixedPrice", path, "", error);
		}
		return success("SettlementPeriodsFixedPrice", ValidationType.CARDINALITY, "SettlementPeriodsFixedPrice", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementPeriodsFixedPrice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SettlementPeriodsFixedPrice", ValidationType.CARDINALITY, "SettlementPeriodsFixedPrice", path, "", res.getError());
				}
				return success("SettlementPeriodsFixedPrice", ValidationType.CARDINALITY, "SettlementPeriodsFixedPrice", path, "");
			})
			.collect(toList());
	}

}
