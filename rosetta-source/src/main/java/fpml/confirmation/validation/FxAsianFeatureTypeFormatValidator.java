package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxAsianFeature;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkNumber;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAsianFeatureTypeFormatValidator implements Validator<FxAsianFeature> {

	private List<ComparisonResult> getComparisonResults(FxAsianFeature o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("payoutFormula", o.getPayoutFormula(), 0, of(255), empty()), 
				checkNumber("precision", o.getPrecision(), empty(), of(0), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public ValidationResult<FxAsianFeature> validate(RosettaPath path, FxAsianFeature o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAsianFeature", ValidationType.TYPE_FORMAT, "FxAsianFeature", path, "", error);
		}
		return success("FxAsianFeature", ValidationType.TYPE_FORMAT, "FxAsianFeature", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAsianFeature o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAsianFeature", ValidationType.TYPE_FORMAT, "FxAsianFeature", path, "", res.getError());
				}
				return success("FxAsianFeature", ValidationType.TYPE_FORMAT, "FxAsianFeature", path, "");
			})
			.collect(toList());
	}

}
