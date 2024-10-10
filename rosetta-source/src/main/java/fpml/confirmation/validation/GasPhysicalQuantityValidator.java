package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityFixedPhysicalQuantityModel;
import fpml.confirmation.GasPhysicalQuantity;
import fpml.confirmation.GasPhysicalQuantitySequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class GasPhysicalQuantityValidator implements Validator<GasPhysicalQuantity> {

	private List<ComparisonResult> getComparisonResults(GasPhysicalQuantity o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityFixedPhysicalQuantityModel", (CommodityFixedPhysicalQuantityModel) o.getCommodityFixedPhysicalQuantityModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("gasPhysicalQuantitySequence", (GasPhysicalQuantitySequence) o.getGasPhysicalQuantitySequence() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<GasPhysicalQuantity> validate(RosettaPath path, GasPhysicalQuantity o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("GasPhysicalQuantity", ValidationType.CARDINALITY, "GasPhysicalQuantity", path, "", error);
		}
		return success("GasPhysicalQuantity", ValidationType.CARDINALITY, "GasPhysicalQuantity", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GasPhysicalQuantity o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GasPhysicalQuantity", ValidationType.CARDINALITY, "GasPhysicalQuantity", path, "", res.getError());
				}
				return success("GasPhysicalQuantity", ValidationType.CARDINALITY, "GasPhysicalQuantity", path, "");
			})
			.collect(toList());
	}

}
