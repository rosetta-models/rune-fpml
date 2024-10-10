package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TaxForm;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TaxFormTypeFormatValidator implements Validator<TaxForm> {

	private List<ComparisonResult> getComparisonResults(TaxForm o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<TaxForm> validate(RosettaPath path, TaxForm o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TaxForm", ValidationType.TYPE_FORMAT, "TaxForm", path, "", error);
		}
		return success("TaxForm", ValidationType.TYPE_FORMAT, "TaxForm", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TaxForm o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TaxForm", ValidationType.TYPE_FORMAT, "TaxForm", path, "", res.getError());
				}
				return success("TaxForm", ValidationType.TYPE_FORMAT, "TaxForm", path, "");
			})
			.collect(toList());
	}

}
