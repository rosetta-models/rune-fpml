package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PartyReference;
import fpml.confirmation.ReturnSwapEarlyTermination;
import fpml.confirmation.StartingDate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReturnSwapEarlyTerminationValidator implements Validator<ReturnSwapEarlyTermination> {

	private List<ComparisonResult> getComparisonResults(ReturnSwapEarlyTermination o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyReference", (PartyReference) o.getPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("startingDate", (StartingDate) o.getStartingDate() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<ReturnSwapEarlyTermination> validate(RosettaPath path, ReturnSwapEarlyTermination o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReturnSwapEarlyTermination", ValidationType.CARDINALITY, "ReturnSwapEarlyTermination", path, "", error);
		}
		return success("ReturnSwapEarlyTermination", ValidationType.CARDINALITY, "ReturnSwapEarlyTermination", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnSwapEarlyTermination o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReturnSwapEarlyTermination", ValidationType.CARDINALITY, "ReturnSwapEarlyTermination", path, "", res.getError());
				}
				return success("ReturnSwapEarlyTermination", ValidationType.CARDINALITY, "ReturnSwapEarlyTermination", path, "");
			})
			.collect(toList());
	}

}
