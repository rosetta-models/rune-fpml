package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanAllocationPartiesModel;
import fpml.confirmation.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanAllocationPartiesModelValidator implements Validator<LoanAllocationPartiesModel> {

	private List<ComparisonResult> getComparisonResults(LoanAllocationPartiesModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("originalPartyReference", (PartyReference) o.getOriginalPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("allocatedPartyReference", (PartyReference) o.getAllocatedPartyReference() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<LoanAllocationPartiesModel> validate(RosettaPath path, LoanAllocationPartiesModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanAllocationPartiesModel", ValidationType.CARDINALITY, "LoanAllocationPartiesModel", path, "", error);
		}
		return success("LoanAllocationPartiesModel", ValidationType.CARDINALITY, "LoanAllocationPartiesModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationPartiesModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanAllocationPartiesModel", ValidationType.CARDINALITY, "LoanAllocationPartiesModel", path, "", res.getError());
				}
				return success("LoanAllocationPartiesModel", ValidationType.CARDINALITY, "LoanAllocationPartiesModel", path, "");
			})
			.collect(toList());
	}

}
