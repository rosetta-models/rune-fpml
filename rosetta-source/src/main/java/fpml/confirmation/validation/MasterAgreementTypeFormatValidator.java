package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.MasterAgreement;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MasterAgreementTypeFormatValidator implements Validator<MasterAgreement> {

	private List<ComparisonResult> getComparisonResults(MasterAgreement o) {
		return Lists.<ComparisonResult>newArrayList(
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
			return failure("MasterAgreement", ValidationType.TYPE_FORMAT, "MasterAgreement", path, "", error);
		}
		return success("MasterAgreement", ValidationType.TYPE_FORMAT, "MasterAgreement", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MasterAgreement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MasterAgreement", ValidationType.TYPE_FORMAT, "MasterAgreement", path, "", res.getError());
				}
				return success("MasterAgreement", ValidationType.TYPE_FORMAT, "MasterAgreement", path, "");
			})
			.collect(toList());
	}

}
