package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ProductReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ProductReferenceTypeFormatValidator implements Validator<ProductReference> {

	private List<ComparisonResult> getComparisonResults(ProductReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ProductReference> validate(RosettaPath path, ProductReference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ProductReference", ValidationType.TYPE_FORMAT, "ProductReference", path, "", error);
		}
		return success("ProductReference", ValidationType.TYPE_FORMAT, "ProductReference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ProductReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ProductReference", ValidationType.TYPE_FORMAT, "ProductReference", path, "", res.getError());
				}
				return success("ProductReference", ValidationType.TYPE_FORMAT, "ProductReference", path, "");
			})
			.collect(toList());
	}

}
