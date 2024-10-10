package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AbstractPartyProfileId;
import fpml.confirmation.PartyProfileIdentifier;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AbstractPartyProfileIdValidator implements Validator<AbstractPartyProfileId> {

	private List<ComparisonResult> getComparisonResults(AbstractPartyProfileId o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyProfileIdentifier", (List<? extends PartyProfileIdentifier>) o.getPartyProfileIdentifier() == null ? 0 : ((List<? extends PartyProfileIdentifier>) o.getPartyProfileIdentifier()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<AbstractPartyProfileId> validate(RosettaPath path, AbstractPartyProfileId o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AbstractPartyProfileId", ValidationType.CARDINALITY, "AbstractPartyProfileId", path, "", error);
		}
		return success("AbstractPartyProfileId", ValidationType.CARDINALITY, "AbstractPartyProfileId", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AbstractPartyProfileId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AbstractPartyProfileId", ValidationType.CARDINALITY, "AbstractPartyProfileId", path, "", res.getError());
				}
				return success("AbstractPartyProfileId", ValidationType.CARDINALITY, "AbstractPartyProfileId", path, "");
			})
			.collect(toList());
	}

}
