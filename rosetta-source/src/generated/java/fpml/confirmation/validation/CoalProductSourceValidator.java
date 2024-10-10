package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CoalProductSource;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CoalProductSourceValidator implements Validator<CoalProductSource> {

	private List<ComparisonResult> getComparisonResults(CoalProductSource o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityCoalProductSourceScheme", (String) o.getCommodityCoalProductSourceScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CoalProductSource> validate(RosettaPath path, CoalProductSource o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CoalProductSource", ValidationType.CARDINALITY, "CoalProductSource", path, "", error);
		}
		return success("CoalProductSource", ValidationType.CARDINALITY, "CoalProductSource", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CoalProductSource o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CoalProductSource", ValidationType.CARDINALITY, "CoalProductSource", path, "", res.getError());
				}
				return success("CoalProductSource", ValidationType.CARDINALITY, "CoalProductSource", path, "");
			})
			.collect(toList());
	}

}
