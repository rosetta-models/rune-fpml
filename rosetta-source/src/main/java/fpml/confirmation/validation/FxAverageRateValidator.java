package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxAverageRate;
import fpml.confirmation.FxAveragingMethodEnum;
import fpml.confirmation.FxInformationSource;
import fpml.confirmation.FxWeightedFixingSchedule;
import fpml.confirmation.QuotedCurrencyPair;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAverageRateValidator implements Validator<FxAverageRate> {

	private List<ComparisonResult> getComparisonResults(FxAverageRate o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("quotedCurrencyPair", (QuotedCurrencyPair) o.getQuotedCurrencyPair() != null ? 1 : 0, 1, 1), 
				checkCardinality("informationSource", (FxInformationSource) o.getInformationSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixingSchedule", (FxWeightedFixingSchedule) o.getFixingSchedule() != null ? 1 : 0, 1, 1), 
				checkCardinality("averagingMethod", (FxAveragingMethodEnum) o.getAveragingMethod() != null ? 1 : 0, 1, 1), 
				checkCardinality("precision", (Integer) o.getPrecision() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxAverageRate> validate(RosettaPath path, FxAverageRate o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAverageRate", ValidationType.CARDINALITY, "FxAverageRate", path, "", error);
		}
		return success("FxAverageRate", ValidationType.CARDINALITY, "FxAverageRate", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAverageRate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAverageRate", ValidationType.CARDINALITY, "FxAverageRate", path, "", res.getError());
				}
				return success("FxAverageRate", ValidationType.CARDINALITY, "FxAverageRate", path, "");
			})
			.collect(toList());
	}

}
