package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CreditSupportAgreement;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CreditSupportAgreementTypeFormatValidator implements Validator<CreditSupportAgreement> {

	private List<ComparisonResult> getComparisonResults(CreditSupportAgreement o) {
		return Lists.<ComparisonResult>newArrayList(
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
			return failure("CreditSupportAgreement", ValidationType.TYPE_FORMAT, "CreditSupportAgreement", path, "", error);
		}
		return success("CreditSupportAgreement", ValidationType.TYPE_FORMAT, "CreditSupportAgreement", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditSupportAgreement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditSupportAgreement", ValidationType.TYPE_FORMAT, "CreditSupportAgreement", path, "", res.getError());
				}
				return success("CreditSupportAgreement", ValidationType.TYPE_FORMAT, "CreditSupportAgreement", path, "");
			})
			.collect(toList());
	}

}
