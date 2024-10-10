package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.PhysicalSettlement;
import fpml.confirmation.Product;
import fpml.confirmation.Trade;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PhysicalSettlementValidator implements Validator<PhysicalSettlement> {

	private List<ComparisonResult> getComparisonResults(PhysicalSettlement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("resultingTradeIdentifier", (PartyTradeIdentifier) o.getResultingTradeIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("resultingTrade", (Trade) o.getResultingTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("product", (Product) o.getProduct() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<PhysicalSettlement> validate(RosettaPath path, PhysicalSettlement o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PhysicalSettlement", ValidationType.CARDINALITY, "PhysicalSettlement", path, "", error);
		}
		return success("PhysicalSettlement", ValidationType.CARDINALITY, "PhysicalSettlement", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PhysicalSettlement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PhysicalSettlement", ValidationType.CARDINALITY, "PhysicalSettlement", path, "", res.getError());
				}
				return success("PhysicalSettlement", ValidationType.CARDINALITY, "PhysicalSettlement", path, "");
			})
			.collect(toList());
	}

}
