package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EquityStrikeSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EquityStrikeSequenceTypeFormatValidator implements Validator<EquityStrikeSequence> {

	private List<ComparisonResult> getComparisonResults(EquityStrikeSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<EquityStrikeSequence> validate(RosettaPath path, EquityStrikeSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EquityStrikeSequence", ValidationType.TYPE_FORMAT, "EquityStrikeSequence", path, "", error);
		}
		return success("EquityStrikeSequence", ValidationType.TYPE_FORMAT, "EquityStrikeSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityStrikeSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquityStrikeSequence", ValidationType.TYPE_FORMAT, "EquityStrikeSequence", path, "", res.getError());
				}
				return success("EquityStrikeSequence", ValidationType.TYPE_FORMAT, "EquityStrikeSequence", path, "");
			})
			.collect(toList());
	}

}
