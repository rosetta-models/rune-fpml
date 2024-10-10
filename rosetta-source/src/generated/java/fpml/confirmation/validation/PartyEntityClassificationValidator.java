package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EntityClassification;
import fpml.confirmation.PartyEntityClassification;
import fpml.confirmation.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PartyEntityClassificationValidator implements Validator<PartyEntityClassification> {

	private List<ComparisonResult> getComparisonResults(PartyEntityClassification o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyReference", (PartyReference) o.getPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("entityClassification", (EntityClassification) o.getEntityClassification() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<PartyEntityClassification> validate(RosettaPath path, PartyEntityClassification o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PartyEntityClassification", ValidationType.CARDINALITY, "PartyEntityClassification", path, "", error);
		}
		return success("PartyEntityClassification", ValidationType.CARDINALITY, "PartyEntityClassification", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyEntityClassification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyEntityClassification", ValidationType.CARDINALITY, "PartyEntityClassification", path, "", res.getError());
				}
				return success("PartyEntityClassification", ValidationType.CARDINALITY, "PartyEntityClassification", path, "");
			})
			.collect(toList());
	}

}
