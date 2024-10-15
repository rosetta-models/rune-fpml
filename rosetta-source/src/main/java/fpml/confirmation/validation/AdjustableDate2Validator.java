package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableDate2;
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.BusinessDayAdjustmentsReference;
import fpml.confirmation.IdentifiedDate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AdjustableDate2Validator implements Validator<AdjustableDate2> {

	private List<ComparisonResult> getComparisonResults(AdjustableDate2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("unadjustedDate", (IdentifiedDate) o.getUnadjustedDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("dateAdjustments", (BusinessDayAdjustments) o.getDateAdjustments() != null ? 1 : 0, 0, 1), 
				checkCardinality("dateAdjustmentsReference", (BusinessDayAdjustmentsReference) o.getDateAdjustmentsReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustedDate", (IdentifiedDate) o.getAdjustedDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<AdjustableDate2> validate(RosettaPath path, AdjustableDate2 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AdjustableDate2", ValidationType.CARDINALITY, "AdjustableDate2", path, "", error);
		}
		return success("AdjustableDate2", ValidationType.CARDINALITY, "AdjustableDate2", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableDate2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AdjustableDate2", ValidationType.CARDINALITY, "AdjustableDate2", path, "", res.getError());
				}
				return success("AdjustableDate2", ValidationType.CARDINALITY, "AdjustableDate2", path, "");
			})
			.collect(toList());
	}

}
