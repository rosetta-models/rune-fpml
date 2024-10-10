package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AgreementAndEffectiveDatesModel;
import fpml.confirmation.ExecutionDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AgreementAndEffectiveDatesModelValidator implements Validator<AgreementAndEffectiveDatesModel> {

	private List<ComparisonResult> getComparisonResults(AgreementAndEffectiveDatesModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("agreementDate", (Date) o.getAgreementDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("executionDateTime", (ExecutionDateTime) o.getExecutionDateTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("effectiveDate", (Date) o.getEffectiveDate() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<AgreementAndEffectiveDatesModel> validate(RosettaPath path, AgreementAndEffectiveDatesModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AgreementAndEffectiveDatesModel", ValidationType.CARDINALITY, "AgreementAndEffectiveDatesModel", path, "", error);
		}
		return success("AgreementAndEffectiveDatesModel", ValidationType.CARDINALITY, "AgreementAndEffectiveDatesModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AgreementAndEffectiveDatesModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AgreementAndEffectiveDatesModel", ValidationType.CARDINALITY, "AgreementAndEffectiveDatesModel", path, "", res.getError());
				}
				return success("AgreementAndEffectiveDatesModel", ValidationType.CARDINALITY, "AgreementAndEffectiveDatesModel", path, "");
			})
			.collect(toList());
	}

}
