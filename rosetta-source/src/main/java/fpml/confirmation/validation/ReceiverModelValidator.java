package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AccountReference;
import fpml.confirmation.PartyReference;
import fpml.confirmation.ReceiverModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReceiverModelValidator implements Validator<ReceiverModel> {

	private List<ComparisonResult> getComparisonResults(ReceiverModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("receiverPartyReference", (PartyReference) o.getReceiverPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("receiverAccountReference", (AccountReference) o.getReceiverAccountReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ReceiverModel> validate(RosettaPath path, ReceiverModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReceiverModel", ValidationType.CARDINALITY, "ReceiverModel", path, "", error);
		}
		return success("ReceiverModel", ValidationType.CARDINALITY, "ReceiverModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReceiverModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReceiverModel", ValidationType.CARDINALITY, "ReceiverModel", path, "", res.getError());
				}
				return success("ReceiverModel", ValidationType.CARDINALITY, "ReceiverModel", path, "");
			})
			.collect(toList());
	}

}
