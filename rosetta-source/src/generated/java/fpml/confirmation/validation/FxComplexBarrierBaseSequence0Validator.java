package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.FxComplexBarrierBaseSequence0;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxComplexBarrierBaseSequence0Validator implements Validator<FxComplexBarrierBaseSequence0> {

	private List<ComparisonResult> getComparisonResults(FxComplexBarrierBaseSequence0 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("observationStartDate", (Date) o.getObservationStartDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("observationStartTime", (BusinessCenterTime) o.getObservationStartTime() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxComplexBarrierBaseSequence0> validate(RosettaPath path, FxComplexBarrierBaseSequence0 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxComplexBarrierBaseSequence0", ValidationType.CARDINALITY, "FxComplexBarrierBaseSequence0", path, "", error);
		}
		return success("FxComplexBarrierBaseSequence0", ValidationType.CARDINALITY, "FxComplexBarrierBaseSequence0", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxComplexBarrierBaseSequence0 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxComplexBarrierBaseSequence0", ValidationType.CARDINALITY, "FxComplexBarrierBaseSequence0", path, "", res.getError());
				}
				return success("FxComplexBarrierBaseSequence0", ValidationType.CARDINALITY, "FxComplexBarrierBaseSequence0", path, "");
			})
			.collect(toList());
	}

}
