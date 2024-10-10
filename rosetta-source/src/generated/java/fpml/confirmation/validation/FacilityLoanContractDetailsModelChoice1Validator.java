package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FacilityLoanContractDetailsModelChoice1;
import fpml.confirmation.LetterOfCredit;
import fpml.confirmation.LoanContract;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FacilityLoanContractDetailsModelChoice1Validator implements Validator<FacilityLoanContractDetailsModelChoice1> {

	private List<ComparisonResult> getComparisonResults(FacilityLoanContractDetailsModelChoice1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("loanContract", (LoanContract) o.getLoanContract() != null ? 1 : 0, 0, 1), 
				checkCardinality("letterOfCredit", (LetterOfCredit) o.getLetterOfCredit() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FacilityLoanContractDetailsModelChoice1> validate(RosettaPath path, FacilityLoanContractDetailsModelChoice1 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FacilityLoanContractDetailsModelChoice1", ValidationType.CARDINALITY, "FacilityLoanContractDetailsModelChoice1", path, "", error);
		}
		return success("FacilityLoanContractDetailsModelChoice1", ValidationType.CARDINALITY, "FacilityLoanContractDetailsModelChoice1", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityLoanContractDetailsModelChoice1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FacilityLoanContractDetailsModelChoice1", ValidationType.CARDINALITY, "FacilityLoanContractDetailsModelChoice1", path, "", res.getError());
				}
				return success("FacilityLoanContractDetailsModelChoice1", ValidationType.CARDINALITY, "FacilityLoanContractDetailsModelChoice1", path, "");
			})
			.collect(toList());
	}

}
