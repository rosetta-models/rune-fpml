package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanContractDetailsModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanContractDetailsModelTypeFormatValidator implements Validator<LoanContractDetailsModel> {

	private List<ComparisonResult> getComparisonResults(LoanContractDetailsModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<LoanContractDetailsModel> validate(RosettaPath path, LoanContractDetailsModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanContractDetailsModel", ValidationType.TYPE_FORMAT, "LoanContractDetailsModel", path, "", error);
		}
		return success("LoanContractDetailsModel", ValidationType.TYPE_FORMAT, "LoanContractDetailsModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanContractDetailsModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanContractDetailsModel", ValidationType.TYPE_FORMAT, "LoanContractDetailsModel", path, "", res.getError());
				}
				return success("LoanContractDetailsModel", ValidationType.TYPE_FORMAT, "LoanContractDetailsModel", path, "");
			})
			.collect(toList());
	}

}
