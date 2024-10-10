package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CollateralValueAllocation;
import fpml.confirmation.CollateralValueAllocationEnum;
import fpml.confirmation.Money;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CollateralValueAllocationValidator implements Validator<CollateralValueAllocation> {

	private List<ComparisonResult> getComparisonResults(CollateralValueAllocation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("type", (CollateralValueAllocationEnum) o.getType_() != null ? 1 : 0, 1, 1), 
				checkCardinality("value", (List<? extends Money>) o.getValue() == null ? 0 : ((List<? extends Money>) o.getValue()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<CollateralValueAllocation> validate(RosettaPath path, CollateralValueAllocation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CollateralValueAllocation", ValidationType.CARDINALITY, "CollateralValueAllocation", path, "", error);
		}
		return success("CollateralValueAllocation", ValidationType.CARDINALITY, "CollateralValueAllocation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralValueAllocation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CollateralValueAllocation", ValidationType.CARDINALITY, "CollateralValueAllocation", path, "", res.getError());
				}
				return success("CollateralValueAllocation", ValidationType.CARDINALITY, "CollateralValueAllocation", path, "");
			})
			.collect(toList());
	}

}
