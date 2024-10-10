package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ExtraordinaryEvents;
import fpml.confirmation.ProductModel;
import fpml.confirmation.VolatilityLeg;
import fpml.confirmation.VolatilitySwap;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class VolatilitySwapValidator implements Validator<VolatilitySwap> {

	private List<ComparisonResult> getComparisonResults(VolatilitySwap o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("extraordinaryEvents", (ExtraordinaryEvents) o.getExtraordinaryEvents() != null ? 1 : 0, 0, 1), 
				checkCardinality("volatilityLeg", (List<? extends VolatilityLeg>) o.getVolatilityLeg() == null ? 0 : ((List<? extends VolatilityLeg>) o.getVolatilityLeg()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<VolatilitySwap> validate(RosettaPath path, VolatilitySwap o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("VolatilitySwap", ValidationType.CARDINALITY, "VolatilitySwap", path, "", error);
		}
		return success("VolatilitySwap", ValidationType.CARDINALITY, "VolatilitySwap", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VolatilitySwap o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VolatilitySwap", ValidationType.CARDINALITY, "VolatilitySwap", path, "", res.getError());
				}
				return success("VolatilitySwap", ValidationType.CARDINALITY, "VolatilitySwap", path, "");
			})
			.collect(toList());
	}

}
