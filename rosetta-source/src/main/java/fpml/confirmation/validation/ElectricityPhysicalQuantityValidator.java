package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ElectricityPhysicalQuantity;
import fpml.confirmation.UnitQuantity;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ElectricityPhysicalQuantityValidator implements Validator<ElectricityPhysicalQuantity> {

	private List<ComparisonResult> getComparisonResults(ElectricityPhysicalQuantity o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("totalPhysicalQuantity", (UnitQuantity) o.getTotalPhysicalQuantity() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ElectricityPhysicalQuantity> validate(RosettaPath path, ElectricityPhysicalQuantity o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ElectricityPhysicalQuantity", ValidationType.CARDINALITY, "ElectricityPhysicalQuantity", path, "", error);
		}
		return success("ElectricityPhysicalQuantity", ValidationType.CARDINALITY, "ElectricityPhysicalQuantity", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ElectricityPhysicalQuantity o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ElectricityPhysicalQuantity", ValidationType.CARDINALITY, "ElectricityPhysicalQuantity", path, "", res.getError());
				}
				return success("ElectricityPhysicalQuantity", ValidationType.CARDINALITY, "ElectricityPhysicalQuantity", path, "");
			})
			.collect(toList());
	}

}
