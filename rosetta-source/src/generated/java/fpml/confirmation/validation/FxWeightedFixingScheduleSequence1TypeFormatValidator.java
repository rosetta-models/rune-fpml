package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxWeightedFixingScheduleSequence1;
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

public class FxWeightedFixingScheduleSequence1TypeFormatValidator implements Validator<FxWeightedFixingScheduleSequence1> {

	private List<ComparisonResult> getComparisonResults(FxWeightedFixingScheduleSequence1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("numberOfFixings", o.getNumberOfFixings(), empty(), of(0), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public ValidationResult<FxWeightedFixingScheduleSequence1> validate(RosettaPath path, FxWeightedFixingScheduleSequence1 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxWeightedFixingScheduleSequence1", ValidationType.TYPE_FORMAT, "FxWeightedFixingScheduleSequence1", path, "", error);
		}
		return success("FxWeightedFixingScheduleSequence1", ValidationType.TYPE_FORMAT, "FxWeightedFixingScheduleSequence1", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxWeightedFixingScheduleSequence1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxWeightedFixingScheduleSequence1", ValidationType.TYPE_FORMAT, "FxWeightedFixingScheduleSequence1", path, "", res.getError());
				}
				return success("FxWeightedFixingScheduleSequence1", ValidationType.TYPE_FORMAT, "FxWeightedFixingScheduleSequence1", path, "");
			})
			.collect(toList());
	}

}
