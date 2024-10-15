package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.GenericProduct;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class GenericProductTypeFormatValidator implements Validator<GenericProduct> {

	private List<ComparisonResult> getComparisonResults(GenericProduct o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<GenericProduct> validate(RosettaPath path, GenericProduct o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("GenericProduct", ValidationType.TYPE_FORMAT, "GenericProduct", path, "", error);
		}
		return success("GenericProduct", ValidationType.TYPE_FORMAT, "GenericProduct", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericProduct o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GenericProduct", ValidationType.TYPE_FORMAT, "GenericProduct", path, "", res.getError());
				}
				return success("GenericProduct", ValidationType.TYPE_FORMAT, "GenericProduct", path, "");
			})
			.collect(toList());
	}

}
