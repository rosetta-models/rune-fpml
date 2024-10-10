package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PartyProfileChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PartyProfileChoiceTypeFormatValidator implements Validator<PartyProfileChoice> {

	private List<ComparisonResult> getComparisonResults(PartyProfileChoice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PartyProfileChoice> validate(RosettaPath path, PartyProfileChoice o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PartyProfileChoice", ValidationType.TYPE_FORMAT, "PartyProfileChoice", path, "", error);
		}
		return success("PartyProfileChoice", ValidationType.TYPE_FORMAT, "PartyProfileChoice", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyProfileChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyProfileChoice", ValidationType.TYPE_FORMAT, "PartyProfileChoice", path, "", res.getError());
				}
				return success("PartyProfileChoice", ValidationType.TYPE_FORMAT, "PartyProfileChoice", path, "");
			})
			.collect(toList());
	}

}
