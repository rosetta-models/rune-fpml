package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FloatingRateIndex;
import fpml.confirmation.ForecastRateIndex;
import fpml.confirmation.Period;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ForecastRateIndexValidator implements Validator<ForecastRateIndex> {

	private List<ComparisonResult> getComparisonResults(ForecastRateIndex o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("floatingRateIndex", (FloatingRateIndex) o.getFloatingRateIndex() != null ? 1 : 0, 1, 1), 
				checkCardinality("indexTenor", (Period) o.getIndexTenor() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<ForecastRateIndex> validate(RosettaPath path, ForecastRateIndex o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ForecastRateIndex", ValidationType.CARDINALITY, "ForecastRateIndex", path, "", error);
		}
		return success("ForecastRateIndex", ValidationType.CARDINALITY, "ForecastRateIndex", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ForecastRateIndex o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ForecastRateIndex", ValidationType.CARDINALITY, "ForecastRateIndex", path, "", res.getError());
				}
				return success("ForecastRateIndex", ValidationType.CARDINALITY, "ForecastRateIndex", path, "");
			})
			.collect(toList());
	}

}
