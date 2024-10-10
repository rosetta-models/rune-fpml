package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.FxTouchSequenceSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxTouchSequenceSequenceValidator implements Validator<FxTouchSequenceSequence> {

	private List<ComparisonResult> getComparisonResults(FxTouchSequenceSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("observationEndDate", (Date) o.getObservationEndDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("observationEndTime", (BusinessCenterTime) o.getObservationEndTime() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxTouchSequenceSequence> validate(RosettaPath path, FxTouchSequenceSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxTouchSequenceSequence", ValidationType.CARDINALITY, "FxTouchSequenceSequence", path, "", error);
		}
		return success("FxTouchSequenceSequence", ValidationType.CARDINALITY, "FxTouchSequenceSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTouchSequenceSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTouchSequenceSequence", ValidationType.CARDINALITY, "FxTouchSequenceSequence", path, "", res.getError());
				}
				return success("FxTouchSequenceSequence", ValidationType.CARDINALITY, "FxTouchSequenceSequence", path, "");
			})
			.collect(toList());
	}

}
