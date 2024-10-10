package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AverageDailyTradingVolumeLimit;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AverageDailyTradingVolumeLimitValidator implements Validator<AverageDailyTradingVolumeLimit> {

	private List<ComparisonResult> getComparisonResults(AverageDailyTradingVolumeLimit o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("limitationPercentage", (BigDecimal) o.getLimitationPercentage() != null ? 1 : 0, 1, 1), 
				checkCardinality("limitationPeriod", (Integer) o.getLimitationPeriod() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<AverageDailyTradingVolumeLimit> validate(RosettaPath path, AverageDailyTradingVolumeLimit o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AverageDailyTradingVolumeLimit", ValidationType.CARDINALITY, "AverageDailyTradingVolumeLimit", path, "", error);
		}
		return success("AverageDailyTradingVolumeLimit", ValidationType.CARDINALITY, "AverageDailyTradingVolumeLimit", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AverageDailyTradingVolumeLimit o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AverageDailyTradingVolumeLimit", ValidationType.CARDINALITY, "AverageDailyTradingVolumeLimit", path, "", res.getError());
				}
				return success("AverageDailyTradingVolumeLimit", ValidationType.CARDINALITY, "AverageDailyTradingVolumeLimit", path, "");
			})
			.collect(toList());
	}

}
