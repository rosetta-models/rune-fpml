package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanContractReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanContractReferenceTypeFormatValidator implements Validator<LoanContractReference> {

	private List<ComparisonResult> getComparisonResults(LoanContractReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<LoanContractReference> validate(RosettaPath path, LoanContractReference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanContractReference", ValidationType.TYPE_FORMAT, "LoanContractReference", path, "", error);
		}
		return success("LoanContractReference", ValidationType.TYPE_FORMAT, "LoanContractReference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanContractReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanContractReference", ValidationType.TYPE_FORMAT, "LoanContractReference", path, "", res.getError());
				}
				return success("LoanContractReference", ValidationType.TYPE_FORMAT, "LoanContractReference", path, "");
			})
			.collect(toList());
	}

}
