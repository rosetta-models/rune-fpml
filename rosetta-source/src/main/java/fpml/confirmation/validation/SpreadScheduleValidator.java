package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SpreadSchedule;
import fpml.confirmation.SpreadScheduleType;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SpreadScheduleValidator implements Validator<SpreadSchedule> {

	private List<ComparisonResult> getComparisonResults(SpreadSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("initialValue", (BigDecimal) o.getInitialValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("_type", (SpreadScheduleType) o.get_type() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<SpreadSchedule> validate(RosettaPath path, SpreadSchedule o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SpreadSchedule", ValidationType.CARDINALITY, "SpreadSchedule", path, "", error);
		}
		return success("SpreadSchedule", ValidationType.CARDINALITY, "SpreadSchedule", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SpreadSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SpreadSchedule", ValidationType.CARDINALITY, "SpreadSchedule", path, "", res.getError());
				}
				return success("SpreadSchedule", ValidationType.CARDINALITY, "SpreadSchedule", path, "");
			})
			.collect(toList());
	}

}
