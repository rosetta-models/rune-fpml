package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AmountSchedule;
import fpml.confirmation.Currency;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AmountScheduleValidator implements Validator<AmountSchedule> {

	private List<ComparisonResult> getComparisonResults(AmountSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("initialValue", (BigDecimal) o.getInitialValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("currency", (Currency) o.getCurrency() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<AmountSchedule> validate(RosettaPath path, AmountSchedule o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AmountSchedule", ValidationType.CARDINALITY, "AmountSchedule", path, "", error);
		}
		return success("AmountSchedule", ValidationType.CARDINALITY, "AmountSchedule", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AmountSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AmountSchedule", ValidationType.CARDINALITY, "AmountSchedule", path, "", res.getError());
				}
				return success("AmountSchedule", ValidationType.CARDINALITY, "AmountSchedule", path, "");
			})
			.collect(toList());
	}

}
