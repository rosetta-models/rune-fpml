package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.OtherAgreementVersion;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OtherAgreementVersionValidator implements Validator<OtherAgreementVersion> {

	private List<ComparisonResult> getComparisonResults(OtherAgreementVersion o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("agreementVersionScheme", (String) o.getAgreementVersionScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<OtherAgreementVersion> validate(RosettaPath path, OtherAgreementVersion o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OtherAgreementVersion", ValidationType.CARDINALITY, "OtherAgreementVersion", path, "", error);
		}
		return success("OtherAgreementVersion", ValidationType.CARDINALITY, "OtherAgreementVersion", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OtherAgreementVersion o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OtherAgreementVersion", ValidationType.CARDINALITY, "OtherAgreementVersion", path, "", res.getError());
				}
				return success("OtherAgreementVersion", ValidationType.CARDINALITY, "OtherAgreementVersion", path, "");
			})
			.collect(toList());
	}

}
