package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Asset;
import fpml.confirmation.InstrumentSetSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class InstrumentSetSequenceValidator implements Validator<InstrumentSetSequence> {

	private List<ComparisonResult> getComparisonResults(InstrumentSetSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("underlyingAsset", (Asset) o.getUnderlyingAsset() != null ? 1 : 0, 0, 1), 
				checkCardinality("curveInstrument", (Asset) o.getCurveInstrument() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<InstrumentSetSequence> validate(RosettaPath path, InstrumentSetSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("InstrumentSetSequence", ValidationType.CARDINALITY, "InstrumentSetSequence", path, "", error);
		}
		return success("InstrumentSetSequence", ValidationType.CARDINALITY, "InstrumentSetSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InstrumentSetSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InstrumentSetSequence", ValidationType.CARDINALITY, "InstrumentSetSequence", path, "", res.getError());
				}
				return success("InstrumentSetSequence", ValidationType.CARDINALITY, "InstrumentSetSequence", path, "");
			})
			.collect(toList());
	}

}
