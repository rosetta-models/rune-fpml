package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CollateralProfile;
import fpml.confirmation.CollateralType;
import fpml.confirmation.PartyReference;
import fpml.confirmation.TriParty;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TriPartyValidator implements Validator<TriParty> {

	private List<ComparisonResult> getComparisonResults(TriParty o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("triPartyAgent", (PartyReference) o.getTriPartyAgent() != null ? 1 : 0, 1, 1), 
				checkCardinality("collateralProfile", (CollateralProfile) o.getCollateralProfile() != null ? 1 : 0, 1, 1), 
				checkCardinality("collateralType", (CollateralType) o.getCollateralType() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<TriParty> validate(RosettaPath path, TriParty o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TriParty", ValidationType.CARDINALITY, "TriParty", path, "", error);
		}
		return success("TriParty", ValidationType.CARDINALITY, "TriParty", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TriParty o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TriParty", ValidationType.CARDINALITY, "TriParty", path, "", res.getError());
				}
				return success("TriParty", ValidationType.CARDINALITY, "TriParty", path, "");
			})
			.collect(toList());
	}

}
