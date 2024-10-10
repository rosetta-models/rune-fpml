package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CapFloor;
import fpml.confirmation.EarlyTerminationProvision;
import fpml.confirmation.InterestRateStream;
import fpml.confirmation.ProductModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CapFloorValidator implements Validator<CapFloor> {

	private List<ComparisonResult> getComparisonResults(CapFloor o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("capFloorStream", (InterestRateStream) o.getCapFloorStream() != null ? 1 : 0, 1, 1), 
				checkCardinality("earlyTerminationProvision", (EarlyTerminationProvision) o.getEarlyTerminationProvision() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CapFloor> validate(RosettaPath path, CapFloor o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CapFloor", ValidationType.CARDINALITY, "CapFloor", path, "", error);
		}
		return success("CapFloor", ValidationType.CARDINALITY, "CapFloor", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CapFloor o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CapFloor", ValidationType.CARDINALITY, "CapFloor", path, "", res.getError());
				}
				return success("CapFloor", ValidationType.CARDINALITY, "CapFloor", path, "");
			})
			.collect(toList());
	}

}
