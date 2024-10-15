package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PriceSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PriceSequenceTypeFormatValidator implements Validator<PriceSequence> {

	private List<ComparisonResult> getComparisonResults(PriceSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PriceSequence> validate(RosettaPath path, PriceSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PriceSequence", ValidationType.TYPE_FORMAT, "PriceSequence", path, "", error);
		}
		return success("PriceSequence", ValidationType.TYPE_FORMAT, "PriceSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PriceSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PriceSequence", ValidationType.TYPE_FORMAT, "PriceSequence", path, "", res.getError());
				}
				return success("PriceSequence", ValidationType.TYPE_FORMAT, "PriceSequence", path, "");
			})
			.collect(toList());
	}

}
