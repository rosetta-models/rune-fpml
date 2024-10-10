package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TaxFormType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TaxFormTypeValidator implements Validator<TaxFormType> {

	private List<ComparisonResult> getComparisonResults(TaxFormType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("taxFormTypeScheme", (String) o.getTaxFormTypeScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<TaxFormType> validate(RosettaPath path, TaxFormType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TaxFormType", ValidationType.CARDINALITY, "TaxFormType", path, "", error);
		}
		return success("TaxFormType", ValidationType.CARDINALITY, "TaxFormType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TaxFormType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TaxFormType", ValidationType.CARDINALITY, "TaxFormType", path, "", res.getError());
				}
				return success("TaxFormType", ValidationType.CARDINALITY, "TaxFormType", path, "");
			})
			.collect(toList());
	}

}
