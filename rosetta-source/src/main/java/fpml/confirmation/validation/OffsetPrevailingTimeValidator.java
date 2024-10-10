package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Offset;
import fpml.confirmation.OffsetPrevailingTime;
import fpml.confirmation.PrevailingTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OffsetPrevailingTimeValidator implements Validator<OffsetPrevailingTime> {

	private List<ComparisonResult> getComparisonResults(OffsetPrevailingTime o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("time", (PrevailingTime) o.getTime() != null ? 1 : 0, 1, 1), 
				checkCardinality("offset", (Offset) o.getOffset() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<OffsetPrevailingTime> validate(RosettaPath path, OffsetPrevailingTime o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OffsetPrevailingTime", ValidationType.CARDINALITY, "OffsetPrevailingTime", path, "", error);
		}
		return success("OffsetPrevailingTime", ValidationType.CARDINALITY, "OffsetPrevailingTime", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OffsetPrevailingTime o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OffsetPrevailingTime", ValidationType.CARDINALITY, "OffsetPrevailingTime", path, "", res.getError());
				}
				return success("OffsetPrevailingTime", ValidationType.CARDINALITY, "OffsetPrevailingTime", path, "");
			})
			.collect(toList());
	}

}
