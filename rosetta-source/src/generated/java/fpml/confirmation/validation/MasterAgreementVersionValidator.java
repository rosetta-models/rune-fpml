package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.MasterAgreementVersion;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MasterAgreementVersionValidator implements Validator<MasterAgreementVersion> {

	private List<ComparisonResult> getComparisonResults(MasterAgreementVersion o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("masterAgreementVersionScheme", (String) o.getMasterAgreementVersionScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<MasterAgreementVersion> validate(RosettaPath path, MasterAgreementVersion o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("MasterAgreementVersion", ValidationType.CARDINALITY, "MasterAgreementVersion", path, "", error);
		}
		return success("MasterAgreementVersion", ValidationType.CARDINALITY, "MasterAgreementVersion", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MasterAgreementVersion o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MasterAgreementVersion", ValidationType.CARDINALITY, "MasterAgreementVersion", path, "", res.getError());
				}
				return success("MasterAgreementVersion", ValidationType.CARDINALITY, "MasterAgreementVersion", path, "");
			})
			.collect(toList());
	}

}
