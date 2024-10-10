package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EnvironmentalProduct;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EnvironmentalProductTypeFormatValidator implements Validator<EnvironmentalProduct> {

	private List<ComparisonResult> getComparisonResults(EnvironmentalProduct o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("vintage", o.getVintage(), empty(), of(0), empty(), empty())
			);
	}

	@Override
	public ValidationResult<EnvironmentalProduct> validate(RosettaPath path, EnvironmentalProduct o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EnvironmentalProduct", ValidationType.TYPE_FORMAT, "EnvironmentalProduct", path, "", error);
		}
		return success("EnvironmentalProduct", ValidationType.TYPE_FORMAT, "EnvironmentalProduct", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EnvironmentalProduct o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EnvironmentalProduct", ValidationType.TYPE_FORMAT, "EnvironmentalProduct", path, "", res.getError());
				}
				return success("EnvironmentalProduct", ValidationType.TYPE_FORMAT, "EnvironmentalProduct", path, "");
			})
			.collect(toList());
	}

}
