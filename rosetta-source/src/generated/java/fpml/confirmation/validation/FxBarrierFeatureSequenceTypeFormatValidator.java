package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxBarrierFeatureSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxBarrierFeatureSequenceTypeFormatValidator implements Validator<FxBarrierFeatureSequence> {

	private List<ComparisonResult> getComparisonResults(FxBarrierFeatureSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxBarrierFeatureSequence> validate(RosettaPath path, FxBarrierFeatureSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxBarrierFeatureSequence", ValidationType.TYPE_FORMAT, "FxBarrierFeatureSequence", path, "", error);
		}
		return success("FxBarrierFeatureSequence", ValidationType.TYPE_FORMAT, "FxBarrierFeatureSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxBarrierFeatureSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxBarrierFeatureSequence", ValidationType.TYPE_FORMAT, "FxBarrierFeatureSequence", path, "", res.getError());
				}
				return success("FxBarrierFeatureSequence", ValidationType.TYPE_FORMAT, "FxBarrierFeatureSequence", path, "");
			})
			.collect(toList());
	}

}
