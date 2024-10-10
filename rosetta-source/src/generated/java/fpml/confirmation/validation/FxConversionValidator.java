package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AmountReference;
import fpml.confirmation.FxConversion;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxConversionValidator implements Validator<FxConversion> {

	private List<ComparisonResult> getComparisonResults(FxConversion o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("amountRelativeTo", (AmountReference) o.getAmountRelativeTo() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxConversion> validate(RosettaPath path, FxConversion o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxConversion", ValidationType.CARDINALITY, "FxConversion", path, "", error);
		}
		return success("FxConversion", ValidationType.CARDINALITY, "FxConversion", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxConversion o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxConversion", ValidationType.CARDINALITY, "FxConversion", path, "", res.getError());
				}
				return success("FxConversion", ValidationType.CARDINALITY, "FxConversion", path, "");
			})
			.collect(toList());
	}

}
