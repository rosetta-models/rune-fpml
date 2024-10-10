package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PartyProfile;
import fpml.confirmation.PartyProfileChoice;
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

public class PartyProfileValidator implements Validator<PartyProfile> {

	private List<ComparisonResult> getComparisonResults(PartyProfile o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyProfileIdentifier", (List<? extends PartyProfileIdentifier>) o.getPartyProfileIdentifier() == null ? 0 : ((List<? extends PartyProfileIdentifier>) o.getPartyProfileIdentifier()).size(), 1, 0), 
				checkCardinality("effectiveDate", (Date) o.getEffectiveDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("partyReference", (PartyReference) o.getPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("documentation", (PartyProfileDocumentation) o.getDocumentation() != null ? 1 : 0, 0, 1), 
				checkCardinality("partyProfileChoice", (List<? extends PartyProfileChoice>) o.getPartyProfileChoice() == null ? 0 : ((List<? extends PartyProfileChoice>) o.getPartyProfileChoice()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<PartyProfile> validate(RosettaPath path, PartyProfile o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PartyProfile", ValidationType.CARDINALITY, "PartyProfile", path, "", error);
		}
		return success("PartyProfile", ValidationType.CARDINALITY, "PartyProfile", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyProfile o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyProfile", ValidationType.CARDINALITY, "PartyProfile", path, "", res.getError());
				}
				return success("PartyProfile", ValidationType.CARDINALITY, "PartyProfile", path, "");
			})
			.collect(toList());
	}

}
