package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.FxExpiryDate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxExpiryDateValidator implements Validator<FxExpiryDate> {

	private List<ComparisonResult> getComparisonResults(FxExpiryDate o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dateAdjustments", (BusinessDayAdjustments) o.getDateAdjustments() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustedDate", (Date) o.getAdjustedDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("expiryTime", (BusinessCenterTime) o.getExpiryTime() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxExpiryDate> validate(RosettaPath path, FxExpiryDate o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxExpiryDate", ValidationType.CARDINALITY, "FxExpiryDate", path, "", error);
		}
		return success("FxExpiryDate", ValidationType.CARDINALITY, "FxExpiryDate", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxExpiryDate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxExpiryDate", ValidationType.CARDINALITY, "FxExpiryDate", path, "", res.getError());
				}
				return success("FxExpiryDate", ValidationType.CARDINALITY, "FxExpiryDate", path, "");
			})
			.collect(toList());
	}

}
