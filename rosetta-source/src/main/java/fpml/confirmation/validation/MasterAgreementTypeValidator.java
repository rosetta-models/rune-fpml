package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.MasterAgreementType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MasterAgreementTypeValidator implements Validator<MasterAgreementType> {

	private List<ComparisonResult> getComparisonResults(MasterAgreementType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("masterAgreementTypeScheme", (String) o.getMasterAgreementTypeScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<MasterAgreementType> validate(RosettaPath path, MasterAgreementType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("MasterAgreementType", ValidationType.CARDINALITY, "MasterAgreementType", path, "", error);
		}
		return success("MasterAgreementType", ValidationType.CARDINALITY, "MasterAgreementType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MasterAgreementType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MasterAgreementType", ValidationType.CARDINALITY, "MasterAgreementType", path, "", res.getError());
				}
				return success("MasterAgreementType", ValidationType.CARDINALITY, "MasterAgreementType", path, "");
			})
			.collect(toList());
	}

}
