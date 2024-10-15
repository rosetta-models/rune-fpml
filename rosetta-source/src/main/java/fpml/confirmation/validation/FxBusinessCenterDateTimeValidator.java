package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.FxBusinessCenterDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxBusinessCenterDateTimeValidator implements Validator<FxBusinessCenterDateTime> {

	private List<ComparisonResult> getComparisonResults(FxBusinessCenterDateTime o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("date", (Date) o.getDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("time", (BusinessCenterTime) o.getTime() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxBusinessCenterDateTime> validate(RosettaPath path, FxBusinessCenterDateTime o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxBusinessCenterDateTime", ValidationType.CARDINALITY, "FxBusinessCenterDateTime", path, "", error);
		}
		return success("FxBusinessCenterDateTime", ValidationType.CARDINALITY, "FxBusinessCenterDateTime", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxBusinessCenterDateTime o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxBusinessCenterDateTime", ValidationType.CARDINALITY, "FxBusinessCenterDateTime", path, "", res.getError());
				}
				return success("FxBusinessCenterDateTime", ValidationType.CARDINALITY, "FxBusinessCenterDateTime", path, "");
			})
			.collect(toList());
	}

}
