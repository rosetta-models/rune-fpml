package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CreditSupportAgreementIdentifier;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CreditSupportAgreementIdentifierValidator implements Validator<CreditSupportAgreementIdentifier> {

	private List<ComparisonResult> getComparisonResults(CreditSupportAgreementIdentifier o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("creditSupportAgreementIdScheme", (String) o.getCreditSupportAgreementIdScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CreditSupportAgreementIdentifier> validate(RosettaPath path, CreditSupportAgreementIdentifier o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CreditSupportAgreementIdentifier", ValidationType.CARDINALITY, "CreditSupportAgreementIdentifier", path, "", error);
		}
		return success("CreditSupportAgreementIdentifier", ValidationType.CARDINALITY, "CreditSupportAgreementIdentifier", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditSupportAgreementIdentifier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditSupportAgreementIdentifier", ValidationType.CARDINALITY, "CreditSupportAgreementIdentifier", path, "", res.getError());
				}
				return success("CreditSupportAgreementIdentifier", ValidationType.CARDINALITY, "CreditSupportAgreementIdentifier", path, "");
			})
			.collect(toList());
	}

}
