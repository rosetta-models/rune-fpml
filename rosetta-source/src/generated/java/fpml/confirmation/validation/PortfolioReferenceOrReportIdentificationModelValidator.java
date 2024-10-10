package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PortfolioConstituentReferenceModel;
import fpml.confirmation.PortfolioReferenceOrReportIdentificationModel;
import fpml.confirmation.ReportSectionIdentificationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PortfolioReferenceOrReportIdentificationModelValidator implements Validator<PortfolioReferenceOrReportIdentificationModel> {

	private List<ComparisonResult> getComparisonResults(PortfolioReferenceOrReportIdentificationModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("portfolioConstituentReferenceModel", (PortfolioConstituentReferenceModel) o.getPortfolioConstituentReferenceModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("reportSectionIdentificationModel", (ReportSectionIdentificationModel) o.getReportSectionIdentificationModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<PortfolioReferenceOrReportIdentificationModel> validate(RosettaPath path, PortfolioReferenceOrReportIdentificationModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PortfolioReferenceOrReportIdentificationModel", ValidationType.CARDINALITY, "PortfolioReferenceOrReportIdentificationModel", path, "", error);
		}
		return success("PortfolioReferenceOrReportIdentificationModel", ValidationType.CARDINALITY, "PortfolioReferenceOrReportIdentificationModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PortfolioReferenceOrReportIdentificationModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PortfolioReferenceOrReportIdentificationModel", ValidationType.CARDINALITY, "PortfolioReferenceOrReportIdentificationModel", path, "", res.getError());
				}
				return success("PortfolioReferenceOrReportIdentificationModel", ValidationType.CARDINALITY, "PortfolioReferenceOrReportIdentificationModel", path, "");
			})
			.collect(toList());
	}

}
