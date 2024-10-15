package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CorrelationLeg;
import fpml.confirmation.CorrelationSwap;
import fpml.confirmation.ExtraordinaryEvents;
import fpml.confirmation.ProductModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CorrelationSwapValidator implements Validator<CorrelationSwap> {

	private List<ComparisonResult> getComparisonResults(CorrelationSwap o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("extraordinaryEvents", (ExtraordinaryEvents) o.getExtraordinaryEvents() != null ? 1 : 0, 0, 1), 
				checkCardinality("correlationLeg", (CorrelationLeg) o.getCorrelationLeg() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CorrelationSwap> validate(RosettaPath path, CorrelationSwap o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CorrelationSwap", ValidationType.CARDINALITY, "CorrelationSwap", path, "", error);
		}
		return success("CorrelationSwap", ValidationType.CARDINALITY, "CorrelationSwap", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CorrelationSwap o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CorrelationSwap", ValidationType.CARDINALITY, "CorrelationSwap", path, "", res.getError());
				}
				return success("CorrelationSwap", ValidationType.CARDINALITY, "CorrelationSwap", path, "");
			})
			.collect(toList());
	}

}
