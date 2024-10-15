package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.GasPhysicalQuantitySequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class GasPhysicalQuantitySequenceTypeFormatValidator implements Validator<GasPhysicalQuantitySequence> {

	private List<ComparisonResult> getComparisonResults(GasPhysicalQuantitySequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<GasPhysicalQuantitySequence> validate(RosettaPath path, GasPhysicalQuantitySequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("GasPhysicalQuantitySequence", ValidationType.TYPE_FORMAT, "GasPhysicalQuantitySequence", path, "", error);
		}
		return success("GasPhysicalQuantitySequence", ValidationType.TYPE_FORMAT, "GasPhysicalQuantitySequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GasPhysicalQuantitySequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GasPhysicalQuantitySequence", ValidationType.TYPE_FORMAT, "GasPhysicalQuantitySequence", path, "", res.getError());
				}
				return success("GasPhysicalQuantitySequence", ValidationType.TYPE_FORMAT, "GasPhysicalQuantitySequence", path, "");
			})
			.collect(toList());
	}

}
