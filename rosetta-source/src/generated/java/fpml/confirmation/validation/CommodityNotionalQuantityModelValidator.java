package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityNotionalQuantityModel;
import fpml.confirmation.CommodityNotionalQuantityModelSequence;
import fpml.confirmation.QuantityReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityNotionalQuantityModelValidator implements Validator<CommodityNotionalQuantityModel> {

	private List<ComparisonResult> getComparisonResults(CommodityNotionalQuantityModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("commodityNotionalQuantityModelSequence", (CommodityNotionalQuantityModelSequence) o.getCommodityNotionalQuantityModelSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("quantityReference", (QuantityReference) o.getQuantityReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityNotionalQuantityModel> validate(RosettaPath path, CommodityNotionalQuantityModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityNotionalQuantityModel", ValidationType.CARDINALITY, "CommodityNotionalQuantityModel", path, "", error);
		}
		return success("CommodityNotionalQuantityModel", ValidationType.CARDINALITY, "CommodityNotionalQuantityModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityNotionalQuantityModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityNotionalQuantityModel", ValidationType.CARDINALITY, "CommodityNotionalQuantityModel", path, "", res.getError());
				}
				return success("CommodityNotionalQuantityModel", ValidationType.CARDINALITY, "CommodityNotionalQuantityModel", path, "");
			})
			.collect(toList());
	}

}
