package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.UtilizationModelSequence1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class UtilizationModelSequence1Validator implements Validator<UtilizationModelSequence1> {

	private List<ComparisonResult> getComparisonResults(UtilizationModelSequence1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("unfundedUtilizedAmount", (MoneyWithParticipantShare) o.getUnfundedUtilizedAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("fundedUtilizedAmount", (MoneyWithParticipantShare) o.getFundedUtilizedAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<UtilizationModelSequence1> validate(RosettaPath path, UtilizationModelSequence1 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("UtilizationModelSequence1", ValidationType.CARDINALITY, "UtilizationModelSequence1", path, "", error);
		}
		return success("UtilizationModelSequence1", ValidationType.CARDINALITY, "UtilizationModelSequence1", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, UtilizationModelSequence1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("UtilizationModelSequence1", ValidationType.CARDINALITY, "UtilizationModelSequence1", path, "", res.getError());
				}
				return success("UtilizationModelSequence1", ValidationType.CARDINALITY, "UtilizationModelSequence1", path, "");
			})
			.collect(toList());
	}

}
