package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CreditSupportAgreement;
import fpml.confirmation.CreditSupportAgreementIdentifier;
import fpml.confirmation.CreditSupportAgreementType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CreditSupportAgreementValidator implements Validator<CreditSupportAgreement> {

	private List<ComparisonResult> getComparisonResults(CreditSupportAgreement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("type", (CreditSupportAgreementType) o.getType() != null ? 1 : 0, 1, 1), 
				checkCardinality("date", (Date) o.getDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("identifier", (CreditSupportAgreementIdentifier) o.getIdentifier() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CreditSupportAgreement> validate(RosettaPath path, CreditSupportAgreement o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CreditSupportAgreement", ValidationType.CARDINALITY, "CreditSupportAgreement", path, "", error);
		}
		return success("CreditSupportAgreement", ValidationType.CARDINALITY, "CreditSupportAgreement", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditSupportAgreement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditSupportAgreement", ValidationType.CARDINALITY, "CreditSupportAgreement", path, "", res.getError());
				}
				return success("CreditSupportAgreement", ValidationType.CARDINALITY, "CreditSupportAgreement", path, "");
			})
			.collect(toList());
	}

}
