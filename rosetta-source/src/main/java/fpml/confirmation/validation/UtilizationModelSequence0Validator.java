package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.UtilizationModelSequence0;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class UtilizationModelSequence0Validator implements Validator<UtilizationModelSequence0> {

	private List<ComparisonResult> getComparisonResults(UtilizationModelSequence0 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fundedUtilizedAmount", (MoneyWithParticipantShare) o.getFundedUtilizedAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("unfundedUtilizedAmount", (MoneyWithParticipantShare) o.getUnfundedUtilizedAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<UtilizationModelSequence0> validate(RosettaPath path, UtilizationModelSequence0 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("UtilizationModelSequence0", ValidationType.CARDINALITY, "UtilizationModelSequence0", path, "", error);
		}
		return success("UtilizationModelSequence0", ValidationType.CARDINALITY, "UtilizationModelSequence0", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, UtilizationModelSequence0 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("UtilizationModelSequence0", ValidationType.CARDINALITY, "UtilizationModelSequence0", path, "", res.getError());
				}
				return success("UtilizationModelSequence0", ValidationType.CARDINALITY, "UtilizationModelSequence0", path, "");
			})
			.collect(toList());
	}

}
