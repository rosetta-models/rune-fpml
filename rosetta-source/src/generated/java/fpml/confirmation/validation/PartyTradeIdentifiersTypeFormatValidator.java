package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PartyTradeIdentifiers;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PartyTradeIdentifiersTypeFormatValidator implements Validator<PartyTradeIdentifiers> {

	private List<ComparisonResult> getComparisonResults(PartyTradeIdentifiers o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PartyTradeIdentifiers> validate(RosettaPath path, PartyTradeIdentifiers o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PartyTradeIdentifiers", ValidationType.TYPE_FORMAT, "PartyTradeIdentifiers", path, "", error);
		}
		return success("PartyTradeIdentifiers", ValidationType.TYPE_FORMAT, "PartyTradeIdentifiers", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyTradeIdentifiers o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyTradeIdentifiers", ValidationType.TYPE_FORMAT, "PartyTradeIdentifiers", path, "", res.getError());
				}
				return success("PartyTradeIdentifiers", ValidationType.TYPE_FORMAT, "PartyTradeIdentifiers", path, "");
			})
			.collect(toList());
	}

}
