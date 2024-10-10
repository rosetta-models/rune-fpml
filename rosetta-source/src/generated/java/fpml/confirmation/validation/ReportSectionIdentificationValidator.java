package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ReportId;
import fpml.confirmation.ReportSectionIdentification;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReportSectionIdentificationValidator implements Validator<ReportSectionIdentification> {

	private List<ComparisonResult> getComparisonResults(ReportSectionIdentification o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("reportId", (ReportId) o.getReportId() != null ? 1 : 0, 0, 1), 
				checkCardinality("sectionNumber", (Integer) o.getSectionNumber() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ReportSectionIdentification> validate(RosettaPath path, ReportSectionIdentification o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReportSectionIdentification", ValidationType.CARDINALITY, "ReportSectionIdentification", path, "", error);
		}
		return success("ReportSectionIdentification", ValidationType.CARDINALITY, "ReportSectionIdentification", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportSectionIdentification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReportSectionIdentification", ValidationType.CARDINALITY, "ReportSectionIdentification", path, "", res.getError());
				}
				return success("ReportSectionIdentification", ValidationType.CARDINALITY, "ReportSectionIdentification", path, "");
			})
			.collect(toList());
	}

}
