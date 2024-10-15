package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.MasterAgreement;
import fpml.confirmation.MasterAgreementType;
import fpml.confirmation.MasterAgreementVersion;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MasterAgreementValidator implements Validator<MasterAgreement> {

	private List<ComparisonResult> getComparisonResults(MasterAgreement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("masterAgreementType", (MasterAgreementType) o.getMasterAgreementType() != null ? 1 : 0, 1, 1), 
				checkCardinality("masterAgreementVersion", (MasterAgreementVersion) o.getMasterAgreementVersion() != null ? 1 : 0, 0, 1), 
				checkCardinality("masterAgreementDate", (Date) o.getMasterAgreementDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<MasterAgreement> validate(RosettaPath path, MasterAgreement o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("MasterAgreement", ValidationType.CARDINALITY, "MasterAgreement", path, "", error);
		}
		return success("MasterAgreement", ValidationType.CARDINALITY, "MasterAgreement", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MasterAgreement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MasterAgreement", ValidationType.CARDINALITY, "MasterAgreement", path, "", res.getError());
				}
				return success("MasterAgreement", ValidationType.CARDINALITY, "MasterAgreement", path, "");
			})
			.collect(toList());
	}

}
