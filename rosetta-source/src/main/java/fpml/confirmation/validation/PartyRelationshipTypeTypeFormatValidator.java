package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PartyRelationshipType;
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

public class PartyRelationshipTypeTypeFormatValidator implements Validator<PartyRelationshipType> {

	private List<ComparisonResult> getComparisonResults(PartyRelationshipType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("partyRelationshipTypeScheme", o.getPartyRelationshipTypeScheme(), 1, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+")))
			);
	}

	@Override
	public ValidationResult<PartyRelationshipType> validate(RosettaPath path, PartyRelationshipType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PartyRelationshipType", ValidationType.TYPE_FORMAT, "PartyRelationshipType", path, "", error);
		}
		return success("PartyRelationshipType", ValidationType.TYPE_FORMAT, "PartyRelationshipType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyRelationshipType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyRelationshipType", ValidationType.TYPE_FORMAT, "PartyRelationshipType", path, "", res.getError());
				}
				return success("PartyRelationshipType", ValidationType.TYPE_FORMAT, "PartyRelationshipType", path, "");
			})
			.collect(toList());
	}

}
