package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOffset;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AdjustableOffsetTypeFormatValidator implements Validator<AdjustableOffset> {

	private List<ComparisonResult> getComparisonResults(AdjustableOffset o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("periodMultiplier", o.getPeriodMultiplier(), empty(), of(0), empty(), empty())
			);
	}

	@Override
	public ValidationResult<AdjustableOffset> validate(RosettaPath path, AdjustableOffset o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AdjustableOffset", ValidationType.TYPE_FORMAT, "AdjustableOffset", path, "", error);
		}
		return success("AdjustableOffset", ValidationType.TYPE_FORMAT, "AdjustableOffset", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableOffset o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AdjustableOffset", ValidationType.TYPE_FORMAT, "AdjustableOffset", path, "", res.getError());
				}
				return success("AdjustableOffset", ValidationType.TYPE_FORMAT, "AdjustableOffset", path, "");
			})
			.collect(toList());
	}

}
