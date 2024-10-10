package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FacilityLoanContractDetailsModelChoice0;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FacilityLoanContractDetailsModelChoice0TypeFormatValidator implements Validator<FacilityLoanContractDetailsModelChoice0> {

	private List<ComparisonResult> getComparisonResults(FacilityLoanContractDetailsModelChoice0 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FacilityLoanContractDetailsModelChoice0> validate(RosettaPath path, FacilityLoanContractDetailsModelChoice0 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FacilityLoanContractDetailsModelChoice0", ValidationType.TYPE_FORMAT, "FacilityLoanContractDetailsModelChoice0", path, "", error);
		}
		return success("FacilityLoanContractDetailsModelChoice0", ValidationType.TYPE_FORMAT, "FacilityLoanContractDetailsModelChoice0", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityLoanContractDetailsModelChoice0 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FacilityLoanContractDetailsModelChoice0", ValidationType.TYPE_FORMAT, "FacilityLoanContractDetailsModelChoice0", path, "", res.getError());
				}
				return success("FacilityLoanContractDetailsModelChoice0", ValidationType.TYPE_FORMAT, "FacilityLoanContractDetailsModelChoice0", path, "");
			})
			.collect(toList());
	}

}
