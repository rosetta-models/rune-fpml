package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SettlementPeriodLeverage;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SettlementPeriodLeverageTypeFormatValidator implements Validator<SettlementPeriodLeverage> {

	private List<ComparisonResult> getComparisonResults(SettlementPeriodLeverage o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<SettlementPeriodLeverage> validate(RosettaPath path, SettlementPeriodLeverage o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SettlementPeriodLeverage", ValidationType.TYPE_FORMAT, "SettlementPeriodLeverage", path, "", error);
		}
		return success("SettlementPeriodLeverage", ValidationType.TYPE_FORMAT, "SettlementPeriodLeverage", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementPeriodLeverage o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SettlementPeriodLeverage", ValidationType.TYPE_FORMAT, "SettlementPeriodLeverage", path, "", res.getError());
				}
				return success("SettlementPeriodLeverage", ValidationType.TYPE_FORMAT, "SettlementPeriodLeverage", path, "");
			})
			.collect(toList());
	}

}
