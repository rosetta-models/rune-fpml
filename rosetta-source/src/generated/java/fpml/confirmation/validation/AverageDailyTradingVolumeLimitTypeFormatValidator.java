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
import static com.rosetta.model.lib.expression.ExpressionOperators.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AverageDailyTradingVolumeLimitTypeFormatValidator implements Validator<AverageDailyTradingVolumeLimit> {

	private List<ComparisonResult> getComparisonResults(AverageDailyTradingVolumeLimit o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("limitationPercentage", o.getLimitationPercentage(), empty(), empty(), of(new BigDecimal("0")), of(new BigDecimal("1"))), 
				checkNumber("limitationPeriod", o.getLimitationPeriod(), empty(), of(0), of(new BigDecimal("0")), empty())
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
			return failure("AverageDailyTradingVolumeLimit", ValidationType.TYPE_FORMAT, "AverageDailyTradingVolumeLimit", path, "", error);
		}
		return success("AverageDailyTradingVolumeLimit", ValidationType.TYPE_FORMAT, "AverageDailyTradingVolumeLimit", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AverageDailyTradingVolumeLimit o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AverageDailyTradingVolumeLimit", ValidationType.TYPE_FORMAT, "AverageDailyTradingVolumeLimit", path, "", res.getError());
				}
				return success("AverageDailyTradingVolumeLimit", ValidationType.TYPE_FORMAT, "AverageDailyTradingVolumeLimit", path, "");
			})
			.collect(toList());
	}

}
