package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.FxTouchSequence;
import fpml.confirmation.FxTouchSequenceSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxTouchSequenceValidator implements Validator<FxTouchSequence> {

	private List<ComparisonResult> getComparisonResults(FxTouchSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("observationStartDate", (Date) o.getObservationStartDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("observationStartTime", (BusinessCenterTime) o.getObservationStartTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxTouchSequenceSequence", (FxTouchSequenceSequence) o.getFxTouchSequenceSequence() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxTouchSequence> validate(RosettaPath path, FxTouchSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxTouchSequence", ValidationType.CARDINALITY, "FxTouchSequence", path, "", error);
		}
		return success("FxTouchSequence", ValidationType.CARDINALITY, "FxTouchSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTouchSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTouchSequence", ValidationType.CARDINALITY, "FxTouchSequence", path, "", res.getError());
				}
				return success("FxTouchSequence", ValidationType.CARDINALITY, "FxTouchSequence", path, "");
			})
			.collect(toList());
	}

}
