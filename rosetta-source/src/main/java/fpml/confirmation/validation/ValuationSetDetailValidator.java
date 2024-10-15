package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ValuationSetDetail;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ValuationSetDetailValidator implements Validator<ValuationSetDetail> {

	private List<ComparisonResult> getComparisonResults(ValuationSetDetail o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("valuationSetDetailScheme", (String) o.getValuationSetDetailScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ValuationSetDetail> validate(RosettaPath path, ValuationSetDetail o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ValuationSetDetail", ValidationType.CARDINALITY, "ValuationSetDetail", path, "", error);
		}
		return success("ValuationSetDetail", ValidationType.CARDINALITY, "ValuationSetDetail", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ValuationSetDetail o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ValuationSetDetail", ValidationType.CARDINALITY, "ValuationSetDetail", path, "", res.getError());
				}
				return success("ValuationSetDetail", ValidationType.CARDINALITY, "ValuationSetDetail", path, "");
			})
			.collect(toList());
	}

}
