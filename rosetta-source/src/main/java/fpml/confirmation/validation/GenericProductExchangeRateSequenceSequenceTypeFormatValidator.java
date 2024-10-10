package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.GenericProductExchangeRateSequenceSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class GenericProductExchangeRateSequenceSequenceTypeFormatValidator implements Validator<GenericProductExchangeRateSequenceSequence> {

	private List<ComparisonResult> getComparisonResults(GenericProductExchangeRateSequenceSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<GenericProductExchangeRateSequenceSequence> validate(RosettaPath path, GenericProductExchangeRateSequenceSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("GenericProductExchangeRateSequenceSequence", ValidationType.TYPE_FORMAT, "GenericProductExchangeRateSequenceSequence", path, "", error);
		}
		return success("GenericProductExchangeRateSequenceSequence", ValidationType.TYPE_FORMAT, "GenericProductExchangeRateSequenceSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericProductExchangeRateSequenceSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GenericProductExchangeRateSequenceSequence", ValidationType.TYPE_FORMAT, "GenericProductExchangeRateSequenceSequence", path, "", res.getError());
				}
				return success("GenericProductExchangeRateSequenceSequence", ValidationType.TYPE_FORMAT, "GenericProductExchangeRateSequenceSequence", path, "");
			})
			.collect(toList());
	}

}
