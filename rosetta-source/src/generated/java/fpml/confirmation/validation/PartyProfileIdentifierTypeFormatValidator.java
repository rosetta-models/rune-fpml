package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PartyProfileIdentifier;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PartyProfileIdentifierTypeFormatValidator implements Validator<PartyProfileIdentifier> {

	private List<ComparisonResult> getComparisonResults(PartyProfileIdentifier o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PartyProfileIdentifier> validate(RosettaPath path, PartyProfileIdentifier o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PartyProfileIdentifier", ValidationType.TYPE_FORMAT, "PartyProfileIdentifier", path, "", error);
		}
		return success("PartyProfileIdentifier", ValidationType.TYPE_FORMAT, "PartyProfileIdentifier", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyProfileIdentifier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyProfileIdentifier", ValidationType.TYPE_FORMAT, "PartyProfileIdentifier", path, "", res.getError());
				}
				return success("PartyProfileIdentifier", ValidationType.TYPE_FORMAT, "PartyProfileIdentifier", path, "");
			})
			.collect(toList());
	}

}
