package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityBase;
import fpml.confirmation.CommodityDetails;
import fpml.confirmation.CommodityInformationSource;
import fpml.confirmation.CommodityReferencePriceFrameworkModel;
import fpml.confirmation.Currency;
import fpml.confirmation.ExchangeId;
import fpml.confirmation.QuantityUnit;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityReferencePriceFrameworkModelValidator implements Validator<CommodityReferencePriceFrameworkModel> {

	private List<ComparisonResult> getComparisonResults(CommodityReferencePriceFrameworkModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("commodityBase", (CommodityBase) o.getCommodityBase() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityDetails", (CommodityDetails) o.getCommodityDetails() != null ? 1 : 0, 1, 1), 
				checkCardinality("unit", (QuantityUnit) o.getUnit() != null ? 1 : 0, 1, 1), 
				checkCardinality("currency", (Currency) o.getCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("exchangeId", (ExchangeId) o.getExchangeId() != null ? 1 : 0, 0, 1), 
				checkCardinality("publication", (CommodityInformationSource) o.getPublication() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityReferencePriceFrameworkModel> validate(RosettaPath path, CommodityReferencePriceFrameworkModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityReferencePriceFrameworkModel", ValidationType.CARDINALITY, "CommodityReferencePriceFrameworkModel", path, "", error);
		}
		return success("CommodityReferencePriceFrameworkModel", ValidationType.CARDINALITY, "CommodityReferencePriceFrameworkModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityReferencePriceFrameworkModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityReferencePriceFrameworkModel", ValidationType.CARDINALITY, "CommodityReferencePriceFrameworkModel", path, "", res.getError());
				}
				return success("CommodityReferencePriceFrameworkModel", ValidationType.CARDINALITY, "CommodityReferencePriceFrameworkModel", path, "");
			})
			.collect(toList());
	}

}
