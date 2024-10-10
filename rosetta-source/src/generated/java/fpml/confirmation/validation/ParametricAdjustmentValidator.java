package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ParametricAdjustment;
import fpml.confirmation.ParametricAdjustmentPoint;
import fpml.confirmation.PriceQuoteUnits;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ParametricAdjustmentValidator implements Validator<ParametricAdjustment> {

	private List<ComparisonResult> getComparisonResults(ParametricAdjustment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("name", (String) o.getName() != null ? 1 : 0, 1, 1), 
				checkCardinality("inputUnits", (PriceQuoteUnits) o.getInputUnits() != null ? 1 : 0, 0, 1), 
				checkCardinality("datapoint", (List<? extends ParametricAdjustmentPoint>) o.getDatapoint() == null ? 0 : ((List<? extends ParametricAdjustmentPoint>) o.getDatapoint()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<ParametricAdjustment> validate(RosettaPath path, ParametricAdjustment o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ParametricAdjustment", ValidationType.CARDINALITY, "ParametricAdjustment", path, "", error);
		}
		return success("ParametricAdjustment", ValidationType.CARDINALITY, "ParametricAdjustment", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ParametricAdjustment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ParametricAdjustment", ValidationType.CARDINALITY, "ParametricAdjustment", path, "", res.getError());
				}
				return success("ParametricAdjustment", ValidationType.CARDINALITY, "ParametricAdjustment", path, "");
			})
			.collect(toList());
	}

}
