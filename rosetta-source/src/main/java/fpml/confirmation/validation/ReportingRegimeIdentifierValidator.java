package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ActionType;
import fpml.confirmation.ReportingRegimeIdentifier;
import fpml.confirmation.ReportingRegimeIdentifierSequence;
import fpml.confirmation.ReportingRole;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReportingRegimeIdentifierValidator implements Validator<ReportingRegimeIdentifier> {

	private List<ComparisonResult> getComparisonResults(ReportingRegimeIdentifier o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("reportingRegimeIdentifierSequence", (ReportingRegimeIdentifierSequence) o.getReportingRegimeIdentifierSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("reportingRole", (ReportingRole) o.getReportingRole() != null ? 1 : 0, 0, 1), 
				checkCardinality("actionType", (ActionType) o.getActionType() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ReportingRegimeIdentifier> validate(RosettaPath path, ReportingRegimeIdentifier o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReportingRegimeIdentifier", ValidationType.CARDINALITY, "ReportingRegimeIdentifier", path, "", error);
		}
		return success("ReportingRegimeIdentifier", ValidationType.CARDINALITY, "ReportingRegimeIdentifier", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportingRegimeIdentifier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReportingRegimeIdentifier", ValidationType.CARDINALITY, "ReportingRegimeIdentifier", path, "", res.getError());
				}
				return success("ReportingRegimeIdentifier", ValidationType.CARDINALITY, "ReportingRegimeIdentifier", path, "");
			})
			.collect(toList());
	}

}
