package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CoalProductType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CoalProductTypeValidator implements Validator<CoalProductType> {

	private List<ComparisonResult> getComparisonResults(CoalProductType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityCoalProductTypeScheme", (String) o.getCommodityCoalProductTypeScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CoalProductType> validate(RosettaPath path, CoalProductType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CoalProductType", ValidationType.CARDINALITY, "CoalProductType", path, "", error);
		}
		return success("CoalProductType", ValidationType.CARDINALITY, "CoalProductType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CoalProductType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CoalProductType", ValidationType.CARDINALITY, "CoalProductType", path, "", res.getError());
				}
				return success("CoalProductType", ValidationType.CARDINALITY, "CoalProductType", path, "");
			})
			.collect(toList());
	}

}
