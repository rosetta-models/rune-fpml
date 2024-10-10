package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxBarrierFeatureSequenceSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxBarrierFeatureSequenceSequenceTypeFormatValidator implements Validator<FxBarrierFeatureSequenceSequence> {

	private List<ComparisonResult> getComparisonResults(FxBarrierFeatureSequenceSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxBarrierFeatureSequenceSequence> validate(RosettaPath path, FxBarrierFeatureSequenceSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxBarrierFeatureSequenceSequence", ValidationType.TYPE_FORMAT, "FxBarrierFeatureSequenceSequence", path, "", error);
		}
		return success("FxBarrierFeatureSequenceSequence", ValidationType.TYPE_FORMAT, "FxBarrierFeatureSequenceSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxBarrierFeatureSequenceSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxBarrierFeatureSequenceSequence", ValidationType.TYPE_FORMAT, "FxBarrierFeatureSequenceSequence", path, "", res.getError());
				}
				return success("FxBarrierFeatureSequenceSequence", ValidationType.TYPE_FORMAT, "FxBarrierFeatureSequenceSequence", path, "");
			})
			.collect(toList());
	}

}
