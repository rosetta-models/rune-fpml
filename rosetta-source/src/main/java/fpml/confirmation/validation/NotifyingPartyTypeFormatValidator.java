package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.NotifyingParty;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class NotifyingPartyTypeFormatValidator implements Validator<NotifyingParty> {

	private List<ComparisonResult> getComparisonResults(NotifyingParty o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<NotifyingParty> validate(RosettaPath path, NotifyingParty o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NotifyingParty", ValidationType.TYPE_FORMAT, "NotifyingParty", path, "", error);
		}
		return success("NotifyingParty", ValidationType.TYPE_FORMAT, "NotifyingParty", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NotifyingParty o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NotifyingParty", ValidationType.TYPE_FORMAT, "NotifyingParty", path, "", res.getError());
				}
				return success("NotifyingParty", ValidationType.TYPE_FORMAT, "NotifyingParty", path, "");
			})
			.collect(toList());
	}

}
