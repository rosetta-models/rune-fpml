package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxAccrualSettlementPeriod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAccrualSettlementPeriodTypeFormatValidator implements Validator<FxAccrualSettlementPeriod> {

	private List<ComparisonResult> getComparisonResults(FxAccrualSettlementPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxAccrualSettlementPeriod> validate(RosettaPath path, FxAccrualSettlementPeriod o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAccrualSettlementPeriod", ValidationType.TYPE_FORMAT, "FxAccrualSettlementPeriod", path, "", error);
		}
		return success("FxAccrualSettlementPeriod", ValidationType.TYPE_FORMAT, "FxAccrualSettlementPeriod", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualSettlementPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualSettlementPeriod", ValidationType.TYPE_FORMAT, "FxAccrualSettlementPeriod", path, "", res.getError());
				}
				return success("FxAccrualSettlementPeriod", ValidationType.TYPE_FORMAT, "FxAccrualSettlementPeriod", path, "");
			})
			.collect(toList());
	}

}
