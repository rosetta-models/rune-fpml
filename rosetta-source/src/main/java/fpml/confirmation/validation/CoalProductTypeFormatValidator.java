package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CoalProduct;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CoalProductTypeFormatValidator implements Validator<CoalProduct> {

	private List<ComparisonResult> getComparisonResults(CoalProduct o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CoalProduct> validate(RosettaPath path, CoalProduct o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CoalProduct", ValidationType.TYPE_FORMAT, "CoalProduct", path, "", error);
		}
		return success("CoalProduct", ValidationType.TYPE_FORMAT, "CoalProduct", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CoalProduct o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CoalProduct", ValidationType.TYPE_FORMAT, "CoalProduct", path, "", res.getError());
				}
				return success("CoalProduct", ValidationType.TYPE_FORMAT, "CoalProduct", path, "");
			})
			.collect(toList());
	}

}
