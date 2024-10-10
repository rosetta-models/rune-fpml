package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityNotionalQuantity;
import fpml.confirmation.CommodityQuantityFrequency;
import fpml.confirmation.QuantityUnit;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityNotionalQuantityValidator implements Validator<CommodityNotionalQuantity> {

	private List<ComparisonResult> getComparisonResults(CommodityNotionalQuantity o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("quantityUnit", (QuantityUnit) o.getQuantityUnit() != null ? 1 : 0, 1, 1), 
				checkCardinality("quantityFrequency", (CommodityQuantityFrequency) o.getQuantityFrequency() != null ? 1 : 0, 1, 1), 
				checkCardinality("quantity", (BigDecimal) o.getQuantity() != null ? 1 : 0, 1, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityNotionalQuantity> validate(RosettaPath path, CommodityNotionalQuantity o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityNotionalQuantity", ValidationType.CARDINALITY, "CommodityNotionalQuantity", path, "", error);
		}
		return success("CommodityNotionalQuantity", ValidationType.CARDINALITY, "CommodityNotionalQuantity", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityNotionalQuantity o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityNotionalQuantity", ValidationType.CARDINALITY, "CommodityNotionalQuantity", path, "", res.getError());
				}
				return success("CommodityNotionalQuantity", ValidationType.CARDINALITY, "CommodityNotionalQuantity", path, "");
			})
			.collect(toList());
	}

}
