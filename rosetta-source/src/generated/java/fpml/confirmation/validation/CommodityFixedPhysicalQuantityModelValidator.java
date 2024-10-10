package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityFixedPhysicalQuantityModel;
import fpml.confirmation.CommodityNotionalQuantity;
import fpml.confirmation.CommodityPhysicalQuantitySchedule;
import fpml.confirmation.UnitQuantity;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityFixedPhysicalQuantityModelValidator implements Validator<CommodityFixedPhysicalQuantityModel> {

	private List<ComparisonResult> getComparisonResults(CommodityFixedPhysicalQuantityModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("physicalQuantity", (CommodityNotionalQuantity) o.getPhysicalQuantity() != null ? 1 : 0, 0, 1), 
				checkCardinality("physicalQuantitySchedule", (CommodityPhysicalQuantitySchedule) o.getPhysicalQuantitySchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("totalPhysicalQuantity", (UnitQuantity) o.getTotalPhysicalQuantity() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityFixedPhysicalQuantityModel> validate(RosettaPath path, CommodityFixedPhysicalQuantityModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityFixedPhysicalQuantityModel", ValidationType.CARDINALITY, "CommodityFixedPhysicalQuantityModel", path, "", error);
		}
		return success("CommodityFixedPhysicalQuantityModel", ValidationType.CARDINALITY, "CommodityFixedPhysicalQuantityModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityFixedPhysicalQuantityModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityFixedPhysicalQuantityModel", ValidationType.CARDINALITY, "CommodityFixedPhysicalQuantityModel", path, "", res.getError());
				}
				return success("CommodityFixedPhysicalQuantityModel", ValidationType.CARDINALITY, "CommodityFixedPhysicalQuantityModel", path, "");
			})
			.collect(toList());
	}

}
