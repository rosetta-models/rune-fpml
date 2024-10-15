package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PartyTradeIdentifier;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PartyTradeIdentifierTypeFormatValidator implements Validator<PartyTradeIdentifier> {

	private List<ComparisonResult> getComparisonResults(PartyTradeIdentifier o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PartyTradeIdentifier> validate(RosettaPath path, PartyTradeIdentifier o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PartyTradeIdentifier", ValidationType.TYPE_FORMAT, "PartyTradeIdentifier", path, "", error);
		}
		return success("PartyTradeIdentifier", ValidationType.TYPE_FORMAT, "PartyTradeIdentifier", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyTradeIdentifier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyTradeIdentifier", ValidationType.TYPE_FORMAT, "PartyTradeIdentifier", path, "", res.getError());
				}
				return success("PartyTradeIdentifier", ValidationType.TYPE_FORMAT, "PartyTradeIdentifier", path, "");
			})
			.collect(toList());
	}

}
