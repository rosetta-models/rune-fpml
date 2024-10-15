package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AbstractPartyProfile;
import fpml.confirmation.PartyProfileDocumentation;
import fpml.confirmation.PartyProfileIdentifier;
import fpml.confirmation.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AbstractPartyProfileValidator implements Validator<AbstractPartyProfile> {

	private List<ComparisonResult> getComparisonResults(AbstractPartyProfile o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyProfileIdentifier", (List<? extends PartyProfileIdentifier>) o.getPartyProfileIdentifier() == null ? 0 : ((List<? extends PartyProfileIdentifier>) o.getPartyProfileIdentifier()).size(), 1, 0), 
				checkCardinality("effectiveDate", (Date) o.getEffectiveDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("partyReference", (PartyReference) o.getPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("documentation", (PartyProfileDocumentation) o.getDocumentation() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<AbstractPartyProfile> validate(RosettaPath path, AbstractPartyProfile o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AbstractPartyProfile", ValidationType.CARDINALITY, "AbstractPartyProfile", path, "", error);
		}
		return success("AbstractPartyProfile", ValidationType.CARDINALITY, "AbstractPartyProfile", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AbstractPartyProfile o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AbstractPartyProfile", ValidationType.CARDINALITY, "AbstractPartyProfile", path, "", res.getError());
				}
				return success("AbstractPartyProfile", ValidationType.CARDINALITY, "AbstractPartyProfile", path, "");
			})
			.collect(toList());
	}

}
