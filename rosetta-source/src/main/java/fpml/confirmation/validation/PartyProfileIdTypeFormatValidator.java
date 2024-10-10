package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PartyProfileId;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PartyProfileIdTypeFormatValidator implements Validator<PartyProfileId> {

	private List<ComparisonResult> getComparisonResults(PartyProfileId o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("partyProfileIdScheme", o.getPartyProfileIdScheme(), 0, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+")))
			);
	}

	@Override
	public ValidationResult<PartyProfileId> validate(RosettaPath path, PartyProfileId o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PartyProfileId", ValidationType.TYPE_FORMAT, "PartyProfileId", path, "", error);
		}
		return success("PartyProfileId", ValidationType.TYPE_FORMAT, "PartyProfileId", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyProfileId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyProfileId", ValidationType.TYPE_FORMAT, "PartyProfileId", path, "", res.getError());
				}
				return success("PartyProfileId", ValidationType.TYPE_FORMAT, "PartyProfileId", path, "");
			})
			.collect(toList());
	}

}
