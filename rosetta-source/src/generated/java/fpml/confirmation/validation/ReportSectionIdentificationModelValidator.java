package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ReportSectionIdentification;
import fpml.confirmation.ReportSectionIdentificationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReportSectionIdentificationModelValidator implements Validator<ReportSectionIdentificationModel> {

	private List<ComparisonResult> getComparisonResults(ReportSectionIdentificationModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("reportIdentification", (ReportSectionIdentification) o.getReportIdentification() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<ReportSectionIdentificationModel> validate(RosettaPath path, ReportSectionIdentificationModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReportSectionIdentificationModel", ValidationType.CARDINALITY, "ReportSectionIdentificationModel", path, "", error);
		}
		return success("ReportSectionIdentificationModel", ValidationType.CARDINALITY, "ReportSectionIdentificationModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportSectionIdentificationModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReportSectionIdentificationModel", ValidationType.CARDINALITY, "ReportSectionIdentificationModel", path, "", res.getError());
				}
				return success("ReportSectionIdentificationModel", ValidationType.CARDINALITY, "ReportSectionIdentificationModel", path, "");
			})
			.collect(toList());
	}

}
