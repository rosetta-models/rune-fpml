package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FacilityContractIdentifier;
import fpml.confirmation.LetterOfCredit;
import fpml.confirmation.LetterOfCreditDetailsModel;
import fpml.confirmation.LetterOfCreditSummary;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LetterOfCreditDetailsModelValidator implements Validator<LetterOfCreditDetailsModel> {

	private List<ComparisonResult> getComparisonResults(LetterOfCreditDetailsModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("letterOfCreditIdentifier", (FacilityContractIdentifier) o.getLetterOfCreditIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("letterOfCreditSummary", (LetterOfCreditSummary) o.getLetterOfCreditSummary() != null ? 1 : 0, 0, 1), 
				checkCardinality("letterOfCredit", (LetterOfCredit) o.getLetterOfCredit() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<LetterOfCreditDetailsModel> validate(RosettaPath path, LetterOfCreditDetailsModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LetterOfCreditDetailsModel", ValidationType.CARDINALITY, "LetterOfCreditDetailsModel", path, "", error);
		}
		return success("LetterOfCreditDetailsModel", ValidationType.CARDINALITY, "LetterOfCreditDetailsModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LetterOfCreditDetailsModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LetterOfCreditDetailsModel", ValidationType.CARDINALITY, "LetterOfCreditDetailsModel", path, "", res.getError());
				}
				return success("LetterOfCreditDetailsModel", ValidationType.CARDINALITY, "LetterOfCreditDetailsModel", path, "");
			})
			.collect(toList());
	}

}
