package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxAccrualTrigger;
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

public class FxAccrualTriggerTypeFormatValidator implements Validator<FxAccrualTrigger> {

	private List<ComparisonResult> getComparisonResults(FxAccrualTrigger o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("triggerRate", o.getTriggerRate(), empty(), empty(), of(new BigDecimal("0")), empty()), 
				checkNumber("spotRate", o.getSpotRate(), empty(), empty(), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public ValidationResult<FxAccrualTrigger> validate(RosettaPath path, FxAccrualTrigger o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAccrualTrigger", ValidationType.TYPE_FORMAT, "FxAccrualTrigger", path, "", error);
		}
		return success("FxAccrualTrigger", ValidationType.TYPE_FORMAT, "FxAccrualTrigger", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualTrigger o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualTrigger", ValidationType.TYPE_FORMAT, "FxAccrualTrigger", path, "", res.getError());
				}
				return success("FxAccrualTrigger", ValidationType.TYPE_FORMAT, "FxAccrualTrigger", path, "");
			})
			.collect(toList());
	}

}
