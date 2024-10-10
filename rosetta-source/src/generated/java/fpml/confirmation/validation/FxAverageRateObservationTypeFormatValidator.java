package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxAverageRateObservation;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAverageRateObservationTypeFormatValidator implements Validator<FxAverageRateObservation> {

	private List<ComparisonResult> getComparisonResults(FxAverageRateObservation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("rate", o.getRate(), empty(), empty(), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public ValidationResult<FxAverageRateObservation> validate(RosettaPath path, FxAverageRateObservation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAverageRateObservation", ValidationType.TYPE_FORMAT, "FxAverageRateObservation", path, "", error);
		}
		return success("FxAverageRateObservation", ValidationType.TYPE_FORMAT, "FxAverageRateObservation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAverageRateObservation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAverageRateObservation", ValidationType.TYPE_FORMAT, "FxAverageRateObservation", path, "", res.getError());
				}
				return success("FxAverageRateObservation", ValidationType.TYPE_FORMAT, "FxAverageRateObservation", path, "");
			})
			.collect(toList());
	}

}
