package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessCenters;
import fpml.confirmation.FxFlexibleForwardExecutionPeriod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxFlexibleForwardExecutionPeriodValidator implements Validator<FxFlexibleForwardExecutionPeriod> {

	private List<ComparisonResult> getComparisonResults(FxFlexibleForwardExecutionPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("startDate", (Date) o.getStartDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("expiryDate", (Date) o.getExpiryDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("businessCenters", (BusinessCenters) o.getBusinessCenters() != null ? 1 : 0, 1, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<FxFlexibleForwardExecutionPeriod> validate(RosettaPath path, FxFlexibleForwardExecutionPeriod o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxFlexibleForwardExecutionPeriod", ValidationType.CARDINALITY, "FxFlexibleForwardExecutionPeriod", path, "", error);
		}
		return success("FxFlexibleForwardExecutionPeriod", ValidationType.CARDINALITY, "FxFlexibleForwardExecutionPeriod", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxFlexibleForwardExecutionPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxFlexibleForwardExecutionPeriod", ValidationType.CARDINALITY, "FxFlexibleForwardExecutionPeriod", path, "", res.getError());
				}
				return success("FxFlexibleForwardExecutionPeriod", ValidationType.CARDINALITY, "FxFlexibleForwardExecutionPeriod", path, "");
			})
			.collect(toList());
	}

}
