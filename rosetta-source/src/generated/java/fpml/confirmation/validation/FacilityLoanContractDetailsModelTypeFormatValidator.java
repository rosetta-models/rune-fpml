package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FacilityLoanContractDetailsModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FacilityLoanContractDetailsModelTypeFormatValidator implements Validator<FacilityLoanContractDetailsModel> {

	private List<ComparisonResult> getComparisonResults(FacilityLoanContractDetailsModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FacilityLoanContractDetailsModel> validate(RosettaPath path, FacilityLoanContractDetailsModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FacilityLoanContractDetailsModel", ValidationType.TYPE_FORMAT, "FacilityLoanContractDetailsModel", path, "", error);
		}
		return success("FacilityLoanContractDetailsModel", ValidationType.TYPE_FORMAT, "FacilityLoanContractDetailsModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityLoanContractDetailsModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FacilityLoanContractDetailsModel", ValidationType.TYPE_FORMAT, "FacilityLoanContractDetailsModel", path, "", res.getError());
				}
				return success("FacilityLoanContractDetailsModel", ValidationType.TYPE_FORMAT, "FacilityLoanContractDetailsModel", path, "");
			})
			.collect(toList());
	}

}
