package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CreditDerivativesNotices;
import fpml.confirmation.Empty;
import fpml.confirmation.FirstPeriodStartDate;
import fpml.confirmation.NovationTermsModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class NovationTermsModelValidator implements Validator<NovationTermsModel> {

	private List<ComparisonResult> getComparisonResults(NovationTermsModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fullFirstCalculationPeriod", (Boolean) o.getFullFirstCalculationPeriod() != null ? 1 : 0, 0, 1), 
				checkCardinality("firstPeriodStartDate", (List<? extends FirstPeriodStartDate>) o.getFirstPeriodStartDate() == null ? 0 : ((List<? extends FirstPeriodStartDate>) o.getFirstPeriodStartDate()).size(), 0, 2), 
				checkCardinality("nonReliance", (Empty) o.getNonReliance() != null ? 1 : 0, 0, 1), 
				checkCardinality("creditDerivativesNotices", (CreditDerivativesNotices) o.getCreditDerivativesNotices() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<NovationTermsModel> validate(RosettaPath path, NovationTermsModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NovationTermsModel", ValidationType.CARDINALITY, "NovationTermsModel", path, "", error);
		}
		return success("NovationTermsModel", ValidationType.CARDINALITY, "NovationTermsModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NovationTermsModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NovationTermsModel", ValidationType.CARDINALITY, "NovationTermsModel", path, "", res.getError());
				}
				return success("NovationTermsModel", ValidationType.CARDINALITY, "NovationTermsModel", path, "");
			})
			.collect(toList());
	}

}
