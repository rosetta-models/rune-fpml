package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LetterOfCreditRolesModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LetterOfCreditRolesModelTypeFormatValidator implements Validator<LetterOfCreditRolesModel> {

	private List<ComparisonResult> getComparisonResults(LetterOfCreditRolesModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<LetterOfCreditRolesModel> validate(RosettaPath path, LetterOfCreditRolesModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LetterOfCreditRolesModel", ValidationType.TYPE_FORMAT, "LetterOfCreditRolesModel", path, "", error);
		}
		return success("LetterOfCreditRolesModel", ValidationType.TYPE_FORMAT, "LetterOfCreditRolesModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LetterOfCreditRolesModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LetterOfCreditRolesModel", ValidationType.TYPE_FORMAT, "LetterOfCreditRolesModel", path, "", res.getError());
				}
				return success("LetterOfCreditRolesModel", ValidationType.TYPE_FORMAT, "LetterOfCreditRolesModel", path, "");
			})
			.collect(toList());
	}

}
