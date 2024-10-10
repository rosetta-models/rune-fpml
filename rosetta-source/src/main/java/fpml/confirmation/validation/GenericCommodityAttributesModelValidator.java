package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityQuantityFrequency;
import fpml.confirmation.FixedPrice;
import fpml.confirmation.GenericCommodityAttributesModel;
import fpml.confirmation.InterconnectionPoint;
import fpml.confirmation.LoadTypeEnum;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class GenericCommodityAttributesModelValidator implements Validator<GenericCommodityAttributesModel> {

	private List<ComparisonResult> getComparisonResults(GenericCommodityAttributesModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("loadType", (LoadTypeEnum) o.getLoadType() != null ? 1 : 0, 0, 1), 
				checkCardinality("quantity", (BigDecimal) o.getQuantity() != null ? 1 : 0, 0, 1), 
				checkCardinality("quantityFrequency", (CommodityQuantityFrequency) o.getQuantityFrequency() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedPrice", (FixedPrice) o.getFixedPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("interconnectionPoint", (InterconnectionPoint) o.getInterconnectionPoint() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<GenericCommodityAttributesModel> validate(RosettaPath path, GenericCommodityAttributesModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("GenericCommodityAttributesModel", ValidationType.CARDINALITY, "GenericCommodityAttributesModel", path, "", error);
		}
		return success("GenericCommodityAttributesModel", ValidationType.CARDINALITY, "GenericCommodityAttributesModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericCommodityAttributesModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GenericCommodityAttributesModel", ValidationType.CARDINALITY, "GenericCommodityAttributesModel", path, "", res.getError());
				}
				return success("GenericCommodityAttributesModel", ValidationType.CARDINALITY, "GenericCommodityAttributesModel", path, "");
			})
			.collect(toList());
	}

}
