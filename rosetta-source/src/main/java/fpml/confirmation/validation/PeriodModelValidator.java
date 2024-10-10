package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PeriodModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PeriodModelValidator implements Validator<PeriodModel> {

	private List<ComparisonResult> getComparisonResults(PeriodModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("startDate", (Date) o.getStartDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("endDate", (Date) o.getEndDate() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<PeriodModel> validate(RosettaPath path, PeriodModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PeriodModel", ValidationType.CARDINALITY, "PeriodModel", path, "", error);
		}
		return success("PeriodModel", ValidationType.CARDINALITY, "PeriodModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PeriodModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PeriodModel", ValidationType.CARDINALITY, "PeriodModel", path, "", res.getError());
				}
				return success("PeriodModel", ValidationType.CARDINALITY, "PeriodModel", path, "");
			})
			.collect(toList());
	}

}
